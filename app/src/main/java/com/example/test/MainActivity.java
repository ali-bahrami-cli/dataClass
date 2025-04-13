package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button calculateBtn;
    TextView result;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        calculateBtn = findViewById(R.id.calculateBtn);
        result = findViewById(R.id.result);

        preferences = getApplicationContext().getSharedPreferences("calcPrefs", Context.MODE_PRIVATE);

        String lastResult = preferences.getString("result", "no data");
        editor = preferences.edit();

        result.setText(" the last result : \n " + lastResult);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1Str = number1.getText().toString();
                String num2Str = number2.getText().toString();

                if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);

                    double sum = num1 + num2;
                    double sub = num1 - num2;
                    double mul = num1 * num2;
                    String div;
                    if (num2 != 0) {
                        div = String.valueOf(num1 / num2);
                    } else {
                        div = "cant divide by zero";
                    }

                    String resultText =
                            "sum is : " + sum +
                            "\n minus is : " + sub +
                            "\n multiplication is : " + mul +
                            "\n division is : " + div;

                    result.setText(" result: \n " + resultText);

                    editor.putString("result", resultText);
                    editor.apply();
                } else {
                    result.setText("please enter num 1 & 2");
                }
            }
        });
    }
}
