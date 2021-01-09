package com.example.countryprofileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView=(ImageView)findViewById(R.id.ImageViewId);
        textView=(TextView) findViewById(R.id.textviewid);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String CountryName=bundle.getString("name");
            showDetails(CountryName);
        }

    }
    void showDetails(String CountryName)
    {
        if(CountryName.equals("Bangladesh"))
        {
            imageView.setImageResource(R.drawable.bangladesh);
            textView.setText(R.string.Bangladesh_text);
        }
        if(CountryName.equals("India"))
        {
            imageView.setImageResource(R.drawable.india);
            textView.setText(R.string.India_text);
        }
        if(CountryName.equals("Pakistan"))
        {
            imageView.setImageResource(R.drawable.pakistan);
            textView.setText(R.string.Pakistan_text);
        }

    }
}