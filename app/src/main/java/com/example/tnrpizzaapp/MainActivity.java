package com.example.tnrpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    CheckBox linux,windows,macos;
    RadioGroup group1;
    RadioButton male,female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit);
        linux = (CheckBox) findViewById(R.id.linux);
        windows = (CheckBox) findViewById(R.id.windows);
        macos = (CheckBox) findViewById(R.id.macos);

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                StringBuffer result = new StringBuffer();
                if(linux.isChecked()){
                    result.append("Linux selected");
                }
                if(macos.isChecked()){
                    result.append("mac OS Selected");
                }
                if(windows.isChecked()){
                    result.append("Windows Selecters");
                }

                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();

            }

        });


    }


}