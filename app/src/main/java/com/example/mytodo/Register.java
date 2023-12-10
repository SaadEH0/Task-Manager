package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytodo.Utils.DatabaseHandler;

public class Register extends AppCompatActivity {

    EditText usernm, pass;
    DatabaseHandler dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dh = new DatabaseHandler(this);
        dh.openDatabase();

        usernm = findViewById(R.id.regUsername);
        pass = findViewById(R.id.regPassword);
    }

    public void Register(View v) {
        String username = usernm.getText().toString();
        String password = pass.getText().toString();

        // Check if the username and password are not empty
        if (!username.isEmpty() && !password.isEmpty()) {
            // Check if the user already exists
            if (dh.getUser(username, password) == -1) {
                // User does not exist, proceed with registration
                dh.createUser(username, password);
                showSuccessMessage();
                LogLogin(v);
            } else {
                // User already exists, show an error message
                showErrorMessage("User already exists. Please choose a different username.");
            }
        } else {
            // Display an error message for empty username or password
            showErrorMessage("Username and password cannot be empty.");
        }
    }

    private void showSuccessMessage() {
        Toast.makeText(this, "Signed up successfully", Toast.LENGTH_SHORT).show();
    }

    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void LogLogin(View v) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }
}

