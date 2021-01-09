package com.example.intendemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondAcitivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);

        textView=(TextView) findViewById(R.id.textviewId);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String value = bundle.getString("tag");
            textView.setText(value);
        }

    }
}