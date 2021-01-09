package com.example.countryprofileapp;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bangladeshBtn,indiaBtn,pakistanBtn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangladeshBtn=(Button)findViewById(R.id.BangladeshBtnId);
        indiaBtn=(Button)findViewById(R.id.IndiaBtnId);
        pakistanBtn=(Button)findViewById(R.id.PakistanBtnId);

        bangladeshBtn.setOnClickListener(this);
        indiaBtn.setOnClickListener(this);
        pakistanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.BangladeshBtnId)
        {
            intent=new Intent(MainActivity.this,ProfileActivity.class);
            intent.putExtra("name","Bangladesh");
            startActivity(intent);
        }
        if(v.getId()==R.id.IndiaBtnId)
        {
            intent=new Intent(MainActivity.this,ProfileActivity.class);
            intent.putExtra("name","India");
            startActivity(intent);
        }
        if(v.getId()==R.id.PakistanBtnId)
        {
            intent=new Intent(MainActivity.this,ProfileActivity.class);
            intent.putExtra("name","Pakistan");
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setTitle(R.string.title_text);
        alertDialogBuilder.setMessage(R.string.msg_text);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
              AlertDialog alertDialog=alertDialogBuilder.create();
              alertDialog.show();
    }
}