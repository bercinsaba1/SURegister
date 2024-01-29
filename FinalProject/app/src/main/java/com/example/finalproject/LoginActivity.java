package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    public static String username;
    int isuser = -1;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            View snackbar = findViewById(R.id.buttonn);
            isuser = (int)msg.what;

            if(isuser != 0) {
                i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
            }else{
                Snackbar.make(LoginActivity.this,snackbar , "No such user!", Snackbar.LENGTH_SHORT).show();
            }

            return true;
        }
    });

    Handler SignUpHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            View snackbar = findViewById(R.id.buttonn);
            Snackbar.make(LoginActivity.this, snackbar,msg.obj.toString(),Snackbar.LENGTH_SHORT).show();

            return true;
        }
    });
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText usernameview=findViewById(R.id.editTextText);
        EditText passwordview=findViewById(R.id.editTextTextPassword);
        Button button2= findViewById(R.id.button2);
        Button button1= findViewById(R.id.buttonn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ClassRepository repo = new ClassRepository();
                SU_Register_Application app = new SU_Register_Application();
                username = usernameview.getText().toString();
                repo.isUser(app.srv, handler,usernameview.getText().toString(), passwordview.getText().toString());

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassRepository repo = new ClassRepository();
                SU_Register_Application app = new SU_Register_Application();

                repo.SıgnUp(app.srv, SignUpHandler, usernameview.getText().toString(), passwordview.getText().toString());
            }
        });
    }
}