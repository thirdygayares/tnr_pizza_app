package com.example.tnrpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button orderBtn,anotherOrderBtn;
    CheckBox onionCkbx,tomatoeCkbx,pineappleCkbx,xtrCheeseCkbx,mushroomCkbx;
    RadioGroup radioGroup1,radioGroup2,radioGroup3;
    RadioButton small,medium,large,hawaiian,hamCheese,thinBtn,thickBtn;
    TextView textOrder,orderPizzaNameDisplay,crustPrintTxtView,orderPizzaPriceDisplay,xtraToppingsPrint,xtraToppingsOrderPrint,xtraToppingsPricePrint,totalDisplayTxtView,totalPricePrint;
    double xtraToppingsPrice = 0, totalPrice=0, priceOnSize  = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderBtn = (Button) findViewById(R.id.orderBtn);
        anotherOrderBtn = (Button) findViewById(R.id.anotherOrderBtn);
        onionCkbx = (CheckBox) findViewById(R.id.onionCkbx);
        tomatoeCkbx = (CheckBox) findViewById(R.id.tomatoeCkbx);
        pineappleCkbx = (CheckBox) findViewById(R.id.pineappleCkbx);
        xtrCheeseCkbx = (CheckBox) findViewById(R.id.xtrCheeseCkbx);
        mushroomCkbx = (CheckBox) findViewById(R.id.mushroomCkbx);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        small = (RadioButton) findViewById(R.id.small);
        medium = (RadioButton) findViewById(R.id.medium);
        large = (RadioButton) findViewById(R.id.large);
        hawaiian = (RadioButton) findViewById(R.id.hawaiian);
        hamCheese = (RadioButton) findViewById(R.id.hamCheese);
        thinBtn = (RadioButton) findViewById(R.id.thinBtn);
        thickBtn = (RadioButton) findViewById(R.id.thickBtn);
        textOrder = (TextView) findViewById(R.id.textOrder);
        orderPizzaNameDisplay = (TextView) findViewById(R.id.orderPizzaNameDisplay);
        crustPrintTxtView = (TextView) findViewById(R.id.crustPrintTxtView);
        orderPizzaPriceDisplay = (TextView) findViewById(R.id.orderPizzaPriceDisplay);
        xtraToppingsPrint = (TextView) findViewById(R.id.xtraToppingsPrint);
        xtraToppingsPricePrint = (TextView) findViewById(R.id.xtraToppingsPricePrint);
        xtraToppingsOrderPrint = (TextView) findViewById(R.id.xtraToppingsOrderPrint);
        totalDisplayTxtView = (TextView) findViewById(R.id.totalDisplayTxtView);
        totalPricePrint = (TextView) findViewById(R.id.totalPricePrint);


    }

    @Override
    protected void onResume() {

        super.onResume();

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer sizelang = new StringBuffer();
                StringBuffer xtraToppingslang = new StringBuffer();

                if(small.isChecked()){
                    sizelang.append("(Small& ");
                    pizzaSize(100);
                }

                if(medium.isChecked()){
                    sizelang.append("(Medium& ");
                    pizzaSize(150);
                }

                if(large.isChecked()){
                    sizelang.append("(Large& ");
                    pizzaSize(200);
                }


                if(thinBtn.isChecked()){
                    sizelang.append("thin)");
                    itemPrice(priceOnSize);
                }

                if(thickBtn.isChecked()){
                    sizelang.append("thick)");
                    itemPrice(priceOnSize,0.5);
                }


                if(xtrCheeseCkbx.isChecked()){
                    extraToppings(20);
                    xtraToppingslang.append(" Extra Cheese ");
                }

                if(mushroomCkbx.isChecked()){
                    extraToppings(20);
                    xtraToppingslang.append(" Mushroom ");
                }

                if(onionCkbx.isChecked()){
                    extraToppings(10);
                    xtraToppingslang.append(" Onion ");
                }

                if(tomatoeCkbx.isChecked()){
                    extraToppings(10);
                    xtraToppingslang.append(" Tomatoes ");
                }

                if(pineappleCkbx.isChecked()){
                    extraToppings(15);
                    xtraToppingslang.append(" Pineapple ");
                }


                Log.v("total",String.valueOf(priceOnSize));
                orderPizzaPriceDisplay.setText(String.valueOf(priceOnSize));
                Log.v("total",String.valueOf(sizelang));
                crustPrintTxtView.setText(String.valueOf(sizelang));
                Log.v("total",String.valueOf(xtraToppingslang));
                xtraToppingsOrderPrint.setText(String.valueOf(xtraToppingslang));
                Log.v("total",String.valueOf(xtraToppingsPrice));
                xtraToppingsPricePrint.setText(String.valueOf(xtraToppingsPrice));

                total(priceOnSize,xtraToppingsPrice);
                totalPricePrint.setText(String.valueOf(totalPrice));
                priceOnSize = 0;
                xtraToppingsPrice = 0;

            }
        });


        anotherOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalPrice = 0;


                orderPizzaPriceDisplay.setText("");
                crustPrintTxtView.setText("");
                xtraToppingsOrderPrint.setText("");
                xtraToppingsPricePrint.setText("");
                totalPricePrint.setText("0");
                hawaiian.setChecked(false);
                hamCheese.setChecked(false);
                small.setChecked(false);
                medium.setChecked(false);
                large.setChecked(false);
                thinBtn.setChecked(false);
                thickBtn.setChecked(false);
                tomatoeCkbx.setChecked(false);
                onionCkbx.setChecked(false);
                pineappleCkbx.setChecked(false);
                xtrCheeseCkbx.setChecked(false);
                mushroomCkbx.setChecked(false);

            }
        });

    }


    public void itemPrice(double pizza){
        this.priceOnSize = pizza;
    }

    public void itemPrice(double pizza,double thick){
        this.priceOnSize += pizza * thick;
    }

    public void pizzaSize(double forPriceSize){
        StringBuffer pizzaname = new StringBuffer();
        if(hawaiian.isChecked()){
            pizzaname.append("Hawaiian");
            this.priceOnSize += forPriceSize;
        }
         if(hamCheese.isChecked()){
             pizzaname.append("Ham & Cheese");
            this.priceOnSize += forPriceSize * 2;
        }
        orderPizzaNameDisplay.setText(String.valueOf(pizzaname));

    }

    public void extraToppings(double toppingPriced){
        this.xtraToppingsPrice += toppingPriced;
    }

    public void total(double pizza,double toppings){
       this.totalPrice = pizza + toppings;
    }



}