package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnClose,btn1,btn2,btn3,btn4,btn5,
            btn6,btn7,btn8,btn9,btn0,btnPlus,
            btnMinus,btnMultiplication,btnDivision,btnCls,btnEqual,btn;

    EditText ET1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            btnClose = findViewById(R.id.btnClose);
            btn1 = findViewById(R.id.num1);
            btn2 = findViewById(R.id.num2);
            btn3 = findViewById(R.id.num3);
            btn4 = findViewById(R.id.num4);
            btn5 = findViewById(R.id.num5);
            btn6 = findViewById(R.id.num6);
            btn7 = findViewById(R.id.num7);
            btn8 = findViewById(R.id.num8);
            btn9 = findViewById(R.id.num9);
            btn0 = findViewById(R.id.num0);
            btnPlus = findViewById(R.id.numPlus);
            btnMinus = findViewById(R.id.numMinus);
            btnMultiplication = findViewById(R.id.numMultiplication);
            btnDivision = findViewById(R.id.numDivision);
            btnCls = findViewById(R.id.numCls);
            btnEqual = findViewById(R.id.numEqual);

            ET1 = findViewById(R.id.ET1);

            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });








    }




}

