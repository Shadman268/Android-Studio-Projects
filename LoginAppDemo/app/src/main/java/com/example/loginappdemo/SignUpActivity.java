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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpEmailEditText,signUpPasswordEditText;
    private TextView signInTextView;
    private Button signUpbutton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("SignUp Activity");

        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_sign_up);
        signUpEmailEditText=(EditText) findViewById(R.id.signUpEmailEdittextId);
        signUpPasswordEditText=(EditText)findViewById(R.id.signUpPasswordEdittextId);
        signInTextView=(TextView) findViewById(R.id.signIntextviewId);
        signUpbutton=(Button) findViewById(R.id.signUpButtonId);
        progressBar=(ProgressBar)findViewById(R.id.ProgressbarId);

        signInTextView.setOnClickListener(this);
        signUpbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.signUpButtonId:
                userRegister();
                break;
            case R.id.signIntextviewId:
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userRegister() {
        String Email=signUpEmailEditText.getText().toString().trim();
        String password=signUpPasswordEditText.getText().toString().trim();

        if(Email.isEmpty())
        {
            signUpEmailEditText.setError("Enter an Email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            signUpEmailEditText.setError("Enter a valid Email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter a Password");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signUpPasswordEditText.setError("Minimum length of password should be 6");
            signUpPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();

                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(),"User is already registered",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}