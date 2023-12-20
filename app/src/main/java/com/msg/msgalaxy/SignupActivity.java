package com.msg.msgalaxy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private CardView signupButton;
    private TextInputLayout usernameEditText, emailEditText ,passwordEditText;
    private LottieAnimationView loadingAnimation;
    private TextView signupTextFromSignupBtn;
    private final String URL = "http://192.168.1.159/MSG/signup.php";
    private TextView loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupButton = (CardView) findViewById(R.id.signupActivity_signupButtonId);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Signup Function
                signupProcess();
            }
        });

        loginButton = (TextView) findViewById(R.id.signupActivity_loginButtonId);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void signupProcess() {
        //Initialize the variables
        usernameEditText = (TextInputLayout) findViewById(R.id.signupActivity_usernameId);
        emailEditText = (TextInputLayout) findViewById(R.id.signupActivity_emailId);
        passwordEditText = (TextInputLayout) findViewById(R.id.signupActivity_passwordId);
        loadingAnimation = (LottieAnimationView) findViewById(R.id.signupActivity_signupButtonId_loadingLottie);
        signupTextFromSignupBtn = (TextView) findViewById(R.id.signupActivity_signupButtonId_textView);

        String username = usernameEditText.getEditText().getText().toString().trim();
        String email = emailEditText.getEditText().getText().toString().trim();
        String password = passwordEditText.getEditText().getText().toString().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() ) {
            if (username.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
            }
            if (email.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            }
            if (password.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            }
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(SignupActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingAnimation.setVisibility(View.VISIBLE);
            signupTextFromSignupBtn.setVisibility(View.GONE);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equals("EmailExists")) {
                                // email already exists in the database
                                Toast.makeText(SignupActivity.this, "Email already exists. Please use a different email.", Toast.LENGTH_SHORT).show();
                                loadingAnimation.setVisibility(View.GONE);
                                signupTextFromSignupBtn.setVisibility(View.VISIBLE);
                            }
                            else if(response.equals("UsernameExists")) {
                                // username already exists in the database
                                Toast.makeText(SignupActivity.this, "Username already exists. Please use a different username.", Toast.LENGTH_SHORT).show();
                                loadingAnimation.setVisibility(View.GONE);
                                signupTextFromSignupBtn.setVisibility(View.VISIBLE);
                            }
                            else if(response.equals("SignUpSuccess")) {
                                Toast.makeText(SignupActivity.this, "Congratulations! You have successfully signed up.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else if(response.equals("SignUpFail")) {
                                Toast.makeText(SignupActivity.this, "Sign-up failed. Please try again.", Toast.LENGTH_SHORT).show();
                                loadingAnimation.setVisibility(View.GONE);
                                signupTextFromSignupBtn.setVisibility(View.VISIBLE);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Nullable
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(SignupActivity.this, "Unexpected response from the server. Please try again.", Toast.LENGTH_SHORT).show();
                    loadingAnimation.setVisibility(View.GONE);
                    signupTextFromSignupBtn.setVisibility(View.VISIBLE);
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("usernamekey", username);
                    data.put("emailkey" , email);
                    data.put("passwordkey", password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}