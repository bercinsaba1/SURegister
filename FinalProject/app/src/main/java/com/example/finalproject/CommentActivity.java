package com.example.finalproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        List<Comment> comments = (List<Comment>) getIntent().getSerializableExtra("comments");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_layout);

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<Comment> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comments);

        listView.setAdapter(adp);

        Button btnAdd = findViewById(R.id.btnComment);
        EditText txtComment = findViewById(R.id.txtInput);

        btnAdd.setOnClickListener(v->{

            Comment newcomment = new Comment(txtComment.getText().toString(),LoginActivity.username);

            comments.add(newcomment);

            ArrayAdapter<Comment> newadp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comments);

            listView.setAdapter(newadp);






        });


    }
}
