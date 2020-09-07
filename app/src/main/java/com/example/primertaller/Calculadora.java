package com.example.primertaller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity{

    private  EditText num1,num2;
    public TextView result;
    public Button sum,res,mul,div,mcm,mcd,may;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        result = findViewById(R.id.setResult);
        sum = findViewById(R.id.btnSum);
        res = findViewById(R.id.btnRes);
        mul = findViewById(R.id.btnMul);
        may = findViewById(R.id.btnMayor);
        div = findViewById(R.id.btnDiv);
        mcm = findViewById(R.id.btnMCM);
        mcd = findViewById(R.id.btnMcd);



        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText( suma( Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString()) )+"");
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText( resta( Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString()) )+"");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText( mult( Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString()) )+"");
            }
        });

        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText( mayor( Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString()) )+"");
            }
        });

        /*
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b = Integer.parseInt(num2.getText().toString());
                if( b == 0 ){
                    result.setText("Error");
                }
                result.setText(division(Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString())) + "");
            }
        });

         */

        mcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText( mcmm( Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString()) )+"");
            }
        });

        mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText( mcdd( Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString()) )+"");
            }
        });
    }

    public int suma(int a , int b){
        return a + b;
    }

    public int resta(int a , int b ){
        return a - b;
    }

    public int mult(int a , int b){
        return a * b;
    }

    public int mayor(int a , int b){
        int mayor = a;
        if (b > mayor){
            return b;
        }
        return a;
    }

    /*
    public int division(int a , int b){ return  a / b; }
     */

    public int mcmm (int a , int b){
        int mcm = 1;
        int i = 2;
        while (i <= a || i <= b){
            if (a % i == 0 || b % i == 0){
                mcm = mcm * i ;
                if (a % i == 0 ) a = a / i;
                if (b % i == 0 ) b = b / i;
            }else i = i + 1;

        }
        return mcm;
    }

    public int mcdd (int a , int b){
        while (a != b){
            if (a > b){
                a = a - b;
            }else  b = b - a;
        }
        return  a;
    }

}