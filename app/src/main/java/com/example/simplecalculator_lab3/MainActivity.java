package com.example.simplecalculator_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonScript = button.getText().toString();

        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + buttonScript);
    }
    public void onArithmeticClick(View view) {
        Button button = (Button) view;
        String buttonScript = button.getText().toString();
        int pressID = view.getId();
        
        if (pressID == R.id.btnAdd) {
            optr = Operator.add;
        } else if (pressID == R.id.btnMinus) {
            optr = Operator.minus;
        } else if (pressID == R.id.btnDivide) {
            optr = Operator.divide;
        } else if (pressID == R.id.btnMultiply) {
            optr = Operator.multiply;
        }
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }
    public void btnClearClick(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText("");
    }
    public void btnResultClick(View view) {
        if (optr != Operator.none) {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr == Operator.add) {
                result = data1 + data2;
            } else if (optr == Operator.minus) {
                result = data1 - data2;
            } else if (optr == Operator.divide) {
                result = data1/data2;
            } else if (optr == Operator.multiply) {
                result = data1*data2;
            }
            optr = Operator.none;
            data1 = result;

            if(0 != (result - (int) result)) {
                eText.setText(String.valueOf(result));
            } else {
                eText.setText(String.valueOf((int)result));
            }
        }
    }
}