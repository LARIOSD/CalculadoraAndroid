package com.example.primertaller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText user,pass;
    public Button get_in,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.editTextUserName);
        pass = findViewById(R.id.editTextPass);
        get_in = findViewById(R.id.btnGet);
        cancel = findViewById(R.id.btnCancel);

        get_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(user.getText().toString()) || TextUtils.isEmpty(pass.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(),Calculadora.class);
                    startActivity(i);
                }
            }

        });

    }
}