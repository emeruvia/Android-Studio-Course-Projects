package com.mailloux.chris.volevents;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViewReferences();
    }

    private void initializeViewReferences()
    {
        emailField = (EditText) findViewById(R.id.email_field);
        passwordField = (EditText) findViewById(R.id.password_field);
    }

    public void onSignInButtonClick(View view)
    {
        String emailEntered = emailField.getText().toString();
        String passwordEntered = passwordField.getText().toString();

        // TODO: More advanced input validation

        // Validate input before proceeding and warn user of any problems
        if(emailEntered.isEmpty())
        {
            String errorMessage = "Missing email!";
            onFormValidationFail(emailField, errorMessage);
        }
        else if(!isValidEmailAddressFormat(emailEntered))
        {
            String message = "Invalid email address format!";
            onFormValidationFail(emailField, message);
        }
        else if(passwordEntered.isEmpty())
        {
            String errorMessage = "Missing password!";
            onFormValidationFail(passwordField, errorMessage);
        }
        else
        {
            boolean success = attemptSignIn(emailEntered, passwordEntered);
            if(success)
            {
                Intent mainActivityIntent = new Intent(
                    LoginActivity.this, MainActivity.class
                );
                startActivity(mainActivityIntent);
                // TODO: Finish implementing
            }
            else
            {
                String message = "Incorrect email/password.";
                Toast.makeText(
                    getApplicationContext(), message, Toast.LENGTH_SHORT
                );
            }
        }
    }

    public void onCreateAccountButtonClick(View view)
    {
        // TODO: Implement
    }

    public void onForgotPasswordButtonClick(View view)
    {
        String emailFieldText = emailField.getText().toString();
        if(emailFieldText.isEmpty())
        {
            String message = "Missing email!";
            onFormValidationFail(emailField, message);
        }
        else if(!isValidEmailAddressFormat(emailFieldText))
        {
            String message = "Invalid email address format!";
            onFormValidationFail(emailField, message);
        }
        else
        {
            Intent forgotPasswordIntent = new Intent(
                LoginActivity.this, ForgotPasswordActivity.class
            );
            forgotPasswordIntent.putExtra("emailAddress", emailFieldText);
            startActivity(forgotPasswordIntent);
        }
    }

    private boolean attemptSignIn(String email, String password)
    {
        return true;

        // TODO: Implement
    }

    private void onFormValidationFail(View editText, String errorMessage)
    {
        Context appContext = getApplicationContext();

        // Vibrate the device
        Vibrator vibrator = (Vibrator)appContext.getSystemService(
            Context.VIBRATOR_SERVICE
        );
        vibrator.vibrate(100);

        // Show a toast with an error message
        Toast.makeText(appContext, errorMessage, Toast.LENGTH_SHORT).show();

        // Shake the offending EditText
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        editText.startAnimation(shake);
    }

    private boolean isValidEmailAddressFormat(String emailAddress)
    {
        // TODO: Implement

        return true;
    }
}
