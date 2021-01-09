package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox milkCheckbox,CoffeeCheckbox,TeaCheckbox;
    private Button showBtn;
    private TextView resultTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milkCheckbox=(CheckBox)findViewById(R.id.MilkCheckboxId);
        CoffeeCheckbox=(CheckBox)findViewById(R.id.CoffeeCheckboxId);
        TeaCheckbox=(CheckBox)findViewById(R.id.TeaCheckboxId);

        showBtn=(Button)findViewById(R.id.ButtonId);

        resultTextview=(TextView)findViewById(R.id.resultTextviewID);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder=new StringBuilder();

                if(milkCheckbox.isChecked())
                {
                    String value=milkCheckbox.getText().toString();
                    stringBuilder.append(value + " is ordered\n");
                }
                if(CoffeeCheckbox.isChecked())
                {
                    String value=CoffeeCheckbox.getText().toString();
                    stringBuilder.append(value + " is ordered\n");
                }
                if(TeaCheckbox.isChecked())
                {
                    String value=TeaCheckbox.getText().toString();
                    stringBuilder.append(value + " is ordered\n");
                }

                resultTextview.setText(stringBuilder);

            }
        });
    }
}