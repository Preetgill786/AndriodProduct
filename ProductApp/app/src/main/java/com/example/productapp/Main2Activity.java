package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener,View.OnClickListener {
ImageView iVimg;
Spinner sp;
EditText etPrice,etqty,etbill;
Button btnorder,btnlogOut;
static  int i;
double qnty;
    double[] price = {1665, 2705, 555, 600, 955, 1000};
    int[] imageList={R.drawable.macair,R.drawable.macpro,R.drawable.keyboard,R.drawable.mouse,R.drawable.printer,R.drawable.scanner};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iVimg=findViewById(R.id.img);
        sp=findViewById(R.id.productName);
        etPrice=findViewById(R.id.price);
        etqty=findViewById(R.id.qty);
        etbill=findViewById(R.id.bill);
        btnorder=findViewById(R.id.order);
        btnlogOut=findViewById(R.id.logout);


        iVimg.setBackgroundResource(R.drawable.macair);


        List<String> product = new ArrayList<String>();
        product.add("MacBook Air");
        product.add("MacBook Pro");
        product.add("Keyboard");
        product.add("Mouse");
        product.add("Printer");
        product.add("Scanner");

        //create an adapter and fill it from the list
        ArrayAdapter<String> productAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, product);
        //make the drop down style
        productAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        sp.setAdapter(productAdapter);
        sp.setOnItemSelectedListener(this);

btnorder.setOnClickListener(this);
btnlogOut.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        i = position;
        Double pr = new Double(price[i]);
        int img = imageList[i];
        iVimg.setBackgroundResource(img);
        etPrice.setText(pr.toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {

            case R.id.order:
                qnty = Double.parseDouble(etqty.getText().toString());
                double total = (qnty * price[i]) + (price[i] * 13 / 100);
                Double Total = new Double(total);
                etbill.setText(Total.toString());
                break;
            case R.id.logout:
                Intent act1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(act1);
                break;
        }
    }
}
