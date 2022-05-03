package com.example.tnrpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button processOrder,newOrder;
    CheckBox onion,tomatoes,pineapple,extraCheese,mushroom;
    RadioGroup pizzaGroup,sizeGroup,crustGroup;
    RadioButton small,medium,large,hawaiian,hamCheese,thin,thick;
    TextView yourOrder,orderPizzaNameDisplay,sizeCrustDisplay,orderPizzaPriceDisplay,extraToppingsWordDisplay,extraToppingsOrderDisplay,totalWordDisplay,totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





}