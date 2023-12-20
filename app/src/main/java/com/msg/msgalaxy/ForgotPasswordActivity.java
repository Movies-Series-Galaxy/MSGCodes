package com.msg.msgalaxy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ForgotPasswordActivity extends AppCompatActivity {

    private CardView arrowBackButton , sendButton;
    private TextView sendTextFromSendBtn;
    private LottieAnimationView loadingAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        sendButton = (CardView) findViewById(R.id.forgotPasswordActivity_sendButtonId);
        sendTextFromSendBtn = (TextView) findViewById(R.id.forgotPasswordActivity_sendButtonId_textView);
        loadingAnimation = (LottieAnimationView) findViewById(R.id.forgotPasswordActivity_sendButtonId_loadingLottie);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting of visibility
                sendTextFromSendBtn.setVisibility(View.GONE);
                loadingAnimation.setVisibility(View.VISIBLE);
            }
        });

        arrowBackButton = (CardView) findViewById(R.id.forgotPasswordActivity_arrowBackId);
        arrowBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Back From this Activity to LoginActivity
                ForgotPasswordActivity.super.onBackPressed();
            }
        });
    }
}