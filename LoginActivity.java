package com.example.ronald.footmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.*;


public class LoginActivity extends Activity {

    protected EditText loginUsername;
    protected EditText loginPassword;
    protected Button registerButton;
    protected Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "Q0ReOV28L4wAsDTryszNXesl8P6sEgacq8SrArd4", "FNDDFZ7UVYR8epJSE0DGwXTV3DMHgs639iOvzpSK");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize
        loginUsername = (EditText)findViewById(R.id.loginNameEditText);
        loginPassword = (EditText)findViewById(R.id.loginPasswordEditText);
        registerButton = (Button)findViewById(R.id.registerButton);
        loginButton = (Button)findViewById(R.id.loginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent takeUserHome = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(takeUserHome);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String userName = loginUsername.getText().toString().trim();
                String userPassword = loginPassword.getText().toString().trim();


                ParseUser.logInInBackground(userName, userPassword, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        ParseUser currentUser = ParseUser.getCurrentUser();
                        if (user != null) {
                            Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_LONG).show();
                            if (currentUser != null) {
                                Intent nextActivity = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(nextActivity);
                            }
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            Toast.makeText(LoginActivity.this, "登陆失败 :(", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
