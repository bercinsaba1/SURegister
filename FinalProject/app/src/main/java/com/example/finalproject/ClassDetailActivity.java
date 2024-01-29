package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.List;

public class ClassDetailActivity  extends AppCompatActivity {

    ClassRepository repo = new ClassRepository();

    ClassItem details;

    String courseID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        details = (ClassItem)getIntent().getSerializableExtra("classitem");

        TextView txtHeader = findViewById(R.id.txtHeader);
        TextView txtInst = findViewById(R.id.textInstructor);
        TextView txtInfo = findViewById(R.id.txtInfo);
        TextView txtCapacity = findViewById(R.id.txtCapacity);
        TextView txtAbout = findViewById(R.id.txtAbout);
        Button btnAtt = findViewById(R.id.btnAttend);
        Button btnComments = findViewById(R.id.btnComments);
        Button btnBack = findViewById(R.id.btnBack);

        txtHeader.setText(details.getTitle());
        txtInst.setText(details.getInstructor());
        txtInfo.setText(details.getInfo());
        txtCapacity.setText("Current ratio: " + details.getAttendnum() + "/" + details.getCapacity());
        txtAbout.setText(details.getAbout());

        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });

        btnComments.setOnClickListener(v -> {
            Intent i = new Intent(ClassDetailActivity.this,CommentActivity.class);
            i.putExtra("comments", (Serializable) details.getComments());
            startActivity(i);
        });


        btnAtt.setOnClickListener(v -> {
            details.setAttendnum(details.getAttendnum() + 1);
            txtCapacity.setText("Current ratio: " + details.getAttendnum() + "/" + details.getCapacity());
            View btn = findViewById(R.id.btnAttend);
            Snackbar.make(ClassDetailActivity.this, btn, "You have successfully attended", Snackbar.LENGTH_SHORT).show();
        });
    }
}
