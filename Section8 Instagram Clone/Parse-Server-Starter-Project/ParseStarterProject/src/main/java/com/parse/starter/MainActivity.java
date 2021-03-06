/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

  //Global Variables
  Boolean signUpModeActive = true;

  TextView changeSignUpModeTextView;
  EditText passwordEditText;

  public void showUserList() {

    Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
    startActivity(intent);

  }

  public boolean onKey(View v, int keyCode, KeyEvent event) {

    //This checks if the enter keyboard was pressed
    if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
      signUp(v);
    }
    return false;
  }

  @Override
  public void onClick(View view) {

    if (view.getId() == R.id.changeSignupModeTextView) {

      Log.i("AppInfo", "Change Signup Mode");
      Button signUpButton = (Button)findViewById(R.id.signupButton);

      if (signUpModeActive) {

        signUpModeActive = false;
        signUpButton.setText("Login");
        changeSignUpModeTextView.setText("Or, Sign Up");
      } else {

        signUpModeActive = true;
        signUpButton.setText("Sign Up");
        changeSignUpModeTextView.setText("Or, Login");
      }
    } else if (view.getId() == R.id.backgroundRelativeLayout || view.getId() == R.id.logoImageView) {

      InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
      inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }

  public void signUp (View view) {

    EditText usernameEditText = (EditText)findViewById(R.id.usernameEditText);
    passwordEditText = (EditText)findViewById(R.id.passwordEditText);

    if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {

      Toast.makeText(this, "A username and password are required.", Toast.LENGTH_SHORT).show();

    } else {

      if (signUpModeActive) {

        ParseUser user = new ParseUser();

        user.setUsername(usernameEditText.getText().toString());
        user.setPassword(passwordEditText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
          @Override
          public void done(ParseException e) {
            if (e == null) {
              Log.i("SignUp", "Successful");
              showUserList();
            } else {
              Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
          }
        });
      } else {

        ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
          @Override
          public void done(ParseUser user, ParseException e) {
            if (user != null) {
              Log.i("SignUp", "Login Successful");
              showUserList();
            } else {
              Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
          }
        });

      }
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    changeSignUpModeTextView = (TextView)findViewById(R.id.changeSignupModeTextView);

    changeSignUpModeTextView.setOnClickListener(this);

    RelativeLayout backgroundRelativeLayout = (RelativeLayout)findViewById(R.id.backgroundRelativeLayout);
    ImageView logoImageView = (ImageView)findViewById(R.id.logoImageView);

    backgroundRelativeLayout.setOnClickListener(this);
    logoImageView.setOnClickListener(this);

    passwordEditText = (EditText) findViewById(R.id.passwordEditText);

    passwordEditText.setOnKeyListener(this);

    if (ParseUser.getCurrentUser() != null) {
      showUserList();
    }

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }
}


//
//    ParseUser user = new ParseUser();
//    user.setUsername("emeruvia");
//    user.setPassword("myPass");
//
//    user.signUpInBackground(new SignUpCallback() {
//      @Override
//      public void done(ParseException e) {
//        if (e == null) {
//          Log.i("Sign Up", "Successful");
//        } else {
//          Log.i("Sign Up", "Failed. Error " + e.toString());
//        }
//      }
//    });

//To log users in
//    ParseUser.logInInBackground("emeruvia", "asd", new LogInCallback() {
//      @Override
//      public void done(ParseUser user, ParseException e) {
//        if (user != null) {
//          Log.i("Login", "Login successful");
//        } else {
//          Log.i("Login", "Failed: Error" + e.toString());
//        }
//      }
//    });


//Logout
//    ParseUser.logOut();
//
//    //Test if a user is logged in when the app is launched
//    if (ParseUser.getCurrentUser() != null) {
//      Log.i("currentUser", "User logged in " + ParseUser.getCurrentUser().getUsername());
//    } else {
//      Log.i("currentUser", "User not logged in");
//    }