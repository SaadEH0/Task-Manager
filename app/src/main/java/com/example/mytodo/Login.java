package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytodo.Utils.DatabaseHandler;

public class Login extends AppCompatActivity {
    DatabaseHandler dh;
    EditText usernm , pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dh = new DatabaseHandler(this);
        dh.openDatabase();

        usernm = (EditText) findViewById(R.id.logUsername);
        pass = (EditText) findViewById(R.id.logPassword);
    }


    public void Login(View v){
        int res = dh.getUser(usernm.getText().toString(),pass.getText().toString());
        if (res >=  0){
            Toast.makeText(this,"Logged in successfully",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,MainActivity.class);
            i.putExtra("UID",String.valueOf(res));
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this,"Log in Failed",Toast.LENGTH_SHORT).show();
        }

    }


    public void LogRegister(View v){
        Intent i = new Intent(this,Register.class);
        startActivity(i);
        finish();
    }


}