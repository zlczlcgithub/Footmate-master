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



public class RegisterActivity extends Activity {

    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserpassword;
    protected EditText mUserRePassword;
    protected EditText mUserStar;
    protected Button mRegisterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "Q0ReOV28L4wAsDTryszNXesl8P6sEgacq8SrArd4", "FNDDFZ7UVYR8epJSE0DGwXTV3DMHgs639iOvzpSK");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initialize
        mUsername = (EditText)findViewById(R.id.registerUsernameEditText);
        mUserEmail = (EditText)findViewById(R.id.registerEmailEditText);
        mUserpassword = (EditText)findViewById(R.id.registerPasswordEditText);
        mUserRePassword = (EditText)findViewById(R.id.registerPasswordReEditText);
        mUserStar = (EditText)findViewById(R.id.registerStarText);
        mRegisterButton = (Button)findViewById(R.id.registerButton);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the username, email and password
                String userName = mUsername.getText().toString().trim();
                String userEmail = mUserEmail.getText().toString().trim();
                String userPassword = mUserpassword.getText().toString().trim();
                String userRePassword = mUserRePassword.getText().toString().trim();
                String userStar = mUserStar.getText().toString().trim();

                if(!userPassword.equals(userRePassword)) {
                    Toast.makeText(RegisterActivity.this, "两次输入密码不相同", Toast.LENGTH_LONG).show();
                }

                else {
                    //Store the user in parse.com
                    ParseUser user = new ParseUser();

                    user.setUsername(userName);
                    user.setPassword(userPassword);
                    user.setEmail(userEmail);
                    user.put("star", userStar);

                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Hooray! Let them use the app now.
                                Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_LONG).show();

                                //Take user to homepage
                                Intent takeUserHome = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(takeUserHome);
                            } else {
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong
                            }
                        }
                    });
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
