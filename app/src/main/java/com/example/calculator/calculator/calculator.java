package com.example.calculator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Switch;
import android.widget.TextView;

public class calculator extends android.app.Activity implements View.OnClickListener{


    private enum OPEARTOR{

            plus,mul,div,sub,finalans
    }

     TextView ans;
     TextView ansview;

    //Instance variables

    private String currentnumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRigth;
    private OPEARTOR currentoperator;
    private int calculator;
    private String calculationString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentnumber = "";
        calculator = 0;
        calculationString ="";


        ans = findViewById(R.id.ans);
        ansview = findViewById(R.id.ansview);

        findViewById(R.id.zero).setOnClickListener(calculator.this);
        findViewById(R.id.one).setOnClickListener(calculator.this);
        findViewById(R.id.two).setOnClickListener(calculator.this);
        findViewById(R.id.three).setOnClickListener(calculator.this);
        findViewById(R.id.four).setOnClickListener(calculator.this);
        findViewById(R.id.five).setOnClickListener(calculator.this);
        findViewById(R.id.six).setOnClickListener(calculator.this);
        findViewById(R.id.seven).setOnClickListener(calculator.this);
        findViewById(R.id.eigth).setOnClickListener(calculator.this);
        findViewById(R.id.nine).setOnClickListener(calculator.this);
        findViewById(R.id.plus).setOnClickListener(calculator.this);
        findViewById(R.id.sub).setOnClickListener(calculator.this);
        findViewById(R.id.mul).setOnClickListener(calculator.this);
        findViewById(R.id.div).setOnClickListener(calculator.this);
        findViewById(R.id.finalans).setOnClickListener(calculator.this);
        findViewById(R.id.clear).setOnClickListener(calculator.this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

             case R.id.zero:
                 numberIsTapped(0);
                break;
            case R.id.one:
                numberIsTapped(1);
                break;
            case R.id.two:
                numberIsTapped(2);
                break;
            case R.id.three:
                numberIsTapped(3);
                break;
            case R.id.four:
                numberIsTapped(4);
                break;
            case R.id.five:
                numberIsTapped(5);
                break;
            case R.id.six:
                numberIsTapped(6);
                break;
            case R.id.seven:
                numberIsTapped(7);
                break;
            case R.id.eigth:
                numberIsTapped(8);
                break;
            case R.id.nine:
                numberIsTapped(9);
                break;
            case R.id.sub:
                operatorIsTapped(OPEARTOR.sub);
                calculationString = calculationString + "-";
                break;
            case R.id.plus:
                operatorIsTapped(OPEARTOR.plus);
                calculationString = calculationString + "+";
                break;
            case R.id.mul:
                operatorIsTapped(OPEARTOR.mul);
                calculationString = calculationString + "*";
                break;
            case R.id.div:
                operatorIsTapped(OPEARTOR.div);
                calculationString = calculationString + "/";
                break;
            case R.id.clear:
                break;
            case R.id.finalans:
                break;



        }


    }

    private void numberIsTapped(int tappednumber){

        currentnumber = currentnumber + String.valueOf(tappednumber);
        ans.setText(currentnumber);
        calculationString = currentnumber;
        ansview.setText(calculationString);

    }

    private void operatorIsTapped(OPEARTOR tappedOperator){

        if (currentnumber !=null && currentnumber != "") {

            stringNumberAtRigth = currentnumber;
            currentnumber = "";

            switch (currentoperator) {

                case plus:
                    calculator = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRigth);
                    break;
                case div:
                    calculator = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRigth);
                    break;
                case mul:
                    calculator = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRigth);
                    break;
                case sub:
                    calculator = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRigth);
                    break;

            }
            stringNumberAtLeft = String.valueOf(calculator);
            ans.setText(stringNumberAtLeft);
            calculationString = stringNumberAtLeft;
            }else {

            stringNumberAtLeft = currentnumber;
            currentnumber ="";

        }
        currentoperator = tappedOperator;
    }
}
