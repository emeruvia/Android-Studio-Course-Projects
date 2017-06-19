package com.mailloux.chris.volevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ForgotPasswordActivity extends AppCompatActivity
{
    String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setTitle(R.string.forgot_password_activity_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Retrieve the email address the user entered on the last screen
        Intent intent = getIntent();
        emailAddress = intent.getStringExtra("emailAddress");
    }

    private void requestPasswordResetEmail(String emailAddress)
    {
        // TODO: Implement
    }

    public void onSendEmailButtonClicked(View view)
    {
        requestPasswordResetEmail(emailAddress);
    }

    public void onResetCodeCorrect()
    {
        // TODO: Implement
    }
}
