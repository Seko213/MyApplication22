package com.example.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText e1, e2;
    Button badd, bmi, bx, bdev;
    TextView tresult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIds = {R.id.bnum0, R.id.bnum1, R.id.bnum2, R.id.bnum3, R.id.bnum4, R.id.bnum5, R.id.bnum6,
            R.id.bnum7, R.id.bnum8, R.id.bnum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        badd = (Button) findViewById(R.id.badd);
        bmi = (Button) findViewById(R.id.bmi);
        bx = (Button) findViewById(R.id.bx);
        bdev = (Button) findViewById(R.id.bdev);
        tresult = (TextView) findViewById(R.id.tresult);

        badd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = e1.getText().toString();
                num2 = e2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        bmi.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = e1.getText().toString();
                num2 = e2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        bx.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = e1.getText().toString();
                num2 = e2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        bdev.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = e1.getText().toString();
                num2 = e2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                tresult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        for (i=0; i< numBtnIds.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIds[i]);
        }

        for(i=0; i<numBtnIds.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(e1.isFocused() == true) {
                        num1 = e1.getText().toString() + numButtons[index].getText().toString();
                        e1.setText(num1);
                    }
                    else if(e2.isFocused() == true) {
                        num2 = e2.getText().toString() + numButtons[index].getText().toString();
                        e2.setText(num2);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}