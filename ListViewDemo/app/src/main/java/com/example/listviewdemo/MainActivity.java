package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.ListViewId);

        String[] countryNames=getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this,R.layout.sample_view,R.id.TextViewID,countryNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=countryNames[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
            }
        });
    }
}