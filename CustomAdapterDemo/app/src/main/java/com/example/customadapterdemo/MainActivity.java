package com.example.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countryNames;
    private int[] flags={R.drawable.bangladesh,R.drawable.india,R.drawable.brazil,R.drawable.usa,R.drawable.pakistan,R.drawable.germany,R.drawable.belgium};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.ListViewId);
        countryNames=getResources().getStringArray(R.array.country_name);
        CustomAdapter adapter=new CustomAdapter(this,countryNames,flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value=countryNames[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });

    }
}