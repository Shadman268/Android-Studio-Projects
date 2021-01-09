package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1=(ImageView) findViewById(R.id.ImageViewID1);
        imageView2=(ImageView) findViewById(R.id.ImageViewID2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ImageViewID1)
        {
            Toast.makeText(MainActivity.this,"this is Shadman",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.ImageViewID2)
        {
            Toast.makeText(MainActivity.this,"this is Kuttar baccha",Toast.LENGTH_SHORT).show();
        }
    }
}