package com.example.loginappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputActivity extends AppCompatActivity {

    private Button saveDatabtn;
    private EditText nameEditText,ageEditText;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        databaseReference= FirebaseDatabase.getInstance().getReference("students");

        saveDatabtn=(Button)findViewById(R.id.saveDataId);
        nameEditText=(EditText)findViewById(R.id.nameEdittxtId);
        ageEditText=(EditText)findViewById(R.id.ageEdittxtId);

        saveDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
    public void saveData()
    {
        String name=nameEditText.getText().toString().trim();
        String age=ageEditText.getText().toString().trim();

        String key=databaseReference.push().getKey();
        Student student=new Student(name,age);

        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(),"Student info is added",Toast.LENGTH_SHORT).show();

    }
}