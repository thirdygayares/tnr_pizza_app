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
        male= (RadioButton) findViewById(R.id.male);
        female= (RadioButton) findViewById(R.id.female);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                StringBuffer result = new StringBuffer();
                if(female.isChecked()){
                    result.append("female selected");
                }
                if(male.isChecked()){
                    result.append("male Selected");
                }
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }


}