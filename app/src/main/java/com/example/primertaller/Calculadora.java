package com.example.primertaller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private EditText num1, num2;
    public TextView result;
    public Button sum, res, mul, div, mcm, mcd, may;

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

        sum.setOnClickListener(this);
        res.setOnClickListener(this);
        mul.setOnClickListener(this);
        may.setOnClickListener(this);
        div.setOnClickListener(this);
        mcm.setOnClickListener(this);
        mcd.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(num1.getText().toString()) || TextUtils.isEmpty(num2.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();
        } else {

            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());

            switch (view.getId()) {
                case R.id.btnSum:
                    result.setText(suma(n1, n2) + "");
                    break;

                case R.id.btnRes:
                    result.setText(resta(n1, n2) + "");
                    break;

                case R.id.btnMul:
                    result.setText(mult(n1, n2) + "");
                    break;

                case R.id.btnMayor:
                    result.setText(mayor(n1, n2) + "");
                    break;

                case R.id.btnDiv:
                    if (n2 != 0) {
                        result.setText(division(n1, n2) + "");
                    } else result.setText("Math ERROR");
                    break;

                case R.id.btnMCM:
                    if (n1 == 0 && n2 == 0) {
                        result.setText(mcmm(n1, n2) + "");
                    } else result.setText("Math ERROR");
                    break;

                case R.id.btnMcd:
                    if (n1 == 0 && n2 == 0) {
                        result.setText(mcdd(n1, n2) + "");
                    } else result.setText("Math ERROR");
                    break;
            }
        }

    }


    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }


    public int mult(int a, int b) {
        return a * b;
    }

    public int mayor(int a, int b) {
        int mayor = a;
        if (b > mayor) {
            return b;
        }
        return a;
    }


    public int division(int a, int b) {
        return a / b;
    }


    public int mcmm(int a, int b) {
        int mcm = 1;
        int i = 2;
        while (i <= a || i <= b) {
            if (a % i == 0 || b % i == 0) {
                mcm = mcm * i;
                if (a % i == 0) a = a / i;
                if (b % i == 0) b = b / i;
            } else i = i + 1;

        }
        return mcm;
    }

    public int mcdd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else b = b - a;
        }
        return a;
    }

}