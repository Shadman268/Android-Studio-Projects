package com.example.alertdialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private AlertDialog.Builder alertdialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.ButtonId);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        alertdialogBuilder=new AlertDialog.Builder(MainActivity.this);

        alertdialogBuilder.setTitle(R.string.title_txt);

        alertdialogBuilder.setMessage(R.string.msg_txt);

        alertdialogBuilder.setIcon(R.drawable.question);

        alertdialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertdialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=alertdialogBuilder.create();
        alertDialog.show();

    }
}