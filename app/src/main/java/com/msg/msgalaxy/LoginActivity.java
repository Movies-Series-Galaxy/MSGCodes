package com.msg.msgalaxy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private CardView loginButton;
    private TextInputLayout usernameEditText, passwordEditText;
    private LottieAnimationView loadingAnimation;
    private TextView loginTextFromLoginBtn;
    private final String URL = "http://192.168.1.159/MSG/login.php";
    private TextView signupButton, forgotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (CardView) findViewById(R.id.loginActivity_loginButtonId);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Login Function
                loginProcess();
            }
        });

        signupButton = (TextView) findViewById(R.id.loginActivity_signupButtonId);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });


        forgotButton = (TextView) findViewById(R.id.loginActivity_forgotPasswordButtonId);
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginProcess() {
        //Initialize the variables
        usernameEditText = (TextInputLayout) findViewById(R.id.loginActivity_usernameId);
        passwordEditText = (TextInputLayout) findViewById(R.id.loginActivity_passwordId);
        loadingAnimation = (LottieAnimationView) findViewById(R.id.loginActivity_loginButtonId_loadingLottie);
        loginTextFromLoginBtn = (TextView) findViewById(R.id.loginActivity_loginButtonId_textView);

        String username = usernameEditText.getEditText().getText().toString().trim();
        String password = passwordEditText.getEditText().getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            if (username.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
            }
            if (password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            }
        } else {
            //set visibility of Loading and textview of Button
            loadingAnimation.setVisibility(View.VISIBLE);
            loginTextFromLoginBtn.setVisibility(View.GONE);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equals("LogInSuccess")) {
                                // email already exists in the database
                                Toast.makeText(LoginActivity.this, "Welcome back! You have successfully logged in.", Toast.LENGTH_SHORT).show();
                                loadingAnimation.setVisibility(View.GONE);
                                loginTextFromLoginBtn.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else if(response.equals("LogInFail")) {
                                // username already exists in the database
                                Toast.makeText(LoginActivity.this, "Log-in failed. Please check your credentials and try again", Toast.LENGTH_SHORT).show();
                                loadingAnimation.setVisibility(View.GONE);
                                loginTextFromLoginBtn.setVisibility(View.VISIBLE);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Nullable
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this, "Unexpected response from the server. Please try again.", Toast.LENGTH_SHORT).show();
                    loadingAnimation.setVisibility(View.GONE);
                    loginTextFromLoginBtn.setVisibility(View.VISIBLE);
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("usernamekey", username);
                    data.put("passwordkey", password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}