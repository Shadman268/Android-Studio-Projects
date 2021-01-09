package com.example.loginappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signInEmailEditText,signInPasswordEditText;
    private TextView signUpTextView;
    private Button signInbutton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("SignIn Activity");

        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);
        signInEmailEditText=(EditText) findViewById(R.id.signInEmailEdittextId);
        signInPasswordEditText=(EditText)findViewById(R.id.signInPasswordEdittextId);
        signUpTextView=(TextView) findViewById(R.id.signUptextviewId);
        signInbutton=(Button) findViewById(R.id.signInButtonId);
        progressBar=(ProgressBar)findViewById(R.id.ProgressbarId);

        signUpTextView.setOnClickListener(this);
        signInbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.signInButtonId:
                userLogin();
                break;
            case R.id.signUptextviewId:
                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userLogin() {
        String Email=signInEmailEditText.getText().toString().trim();
        String password=signInPasswordEditText.getText().toString().trim();

        if(Email.isEmpty())
        {
            signInEmailEditText.setError("Enter an Email address");
            signInEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            signInEmailEditText.setError("Enter a valid Email address");
            signInEmailEditText.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            signInPasswordEditText.setError("Enter a Password");
            signInPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signInPasswordEditText.setError("Minimum length of password should be 6");
            signInPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}