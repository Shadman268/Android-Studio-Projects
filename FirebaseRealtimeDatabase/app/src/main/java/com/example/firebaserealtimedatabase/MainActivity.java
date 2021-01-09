package com.example.firebaserealtimedatabase;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    Spinner spinner;
    private DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseArtists = FirebaseDatabase.getInstance().getReference("Artists");

        editText=(EditText)findViewById(R.id.EdittextNameId);
        btn=(Button)findViewById(R.id.ButtonId);
        spinner=(Spinner)findViewById(R.id.SpinnerId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
    }
    private  void addArtist()
    {
        String name=editText.getText().toString().trim();
        String genre=spinner.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name))
        {
           String id = databaseArtists.push().getKey();

           Artist artist=new Artist(id,name,genre);
           databaseArtists.child(id).setValue(artist);
           Toast.makeText(this,"Artist is added",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"You should enter a name",Toast.LENGTH_SHORT).show();
        }
    }
}