package com.example.ako.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String Numbr1 = "0";
    String Numbr2 = "";
    String Oparater = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button One   = (Button) findViewById(R.id.btnOne);
        Button two   = (Button) findViewById(R.id.btnTwo);
        Button three = (Button) findViewById(R.id.btnThree);
        Button four  = (Button) findViewById(R.id.btnFour);
        Button five  = (Button) findViewById(R.id.btnFive);
        Button six   = (Button) findViewById(R.id.btnSix);
        Button seven = (Button) findViewById(R.id.btnSeven);
        Button Eight = (Button) findViewById(R.id.btnEight);
        Button Nine  = (Button) findViewById(R.id.btnNine);
        Button zero  = (Button) findViewById(R.id.btnZero);

        Button Decimal = (Button) findViewById(R.id.btnDecimal);

        Button Add = (Button) findViewById(R.id.btnAdd);
        Button Sub = (Button) findViewById(R.id.btnSubtract);
        Button Mult = (Button) findViewById(R.id.btnMultiply);
        Button Div = (Button) findViewById(R.id.btnDivide);
        Button Equ = (Button) findViewById(R.id.btnEquals);
        Button Bck = (Button) findViewById(R.id.btnBack);
        Button Clr = (Button) findViewById(R.id.btnClear);

        final TextView InputView = (TextView) findViewById(R.id.txtInput);
        final TextView Solution  = (TextView) findViewById(R.id.txtSolution);


        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "1");
                Numbr1 = Numbr1 + "1";
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "2");
                Numbr1 = Numbr1 + "2";
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "3");
                Numbr1 = Numbr1 + "3";
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "4");
                Numbr1 = Numbr1 + "4";
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputView.setText(Numbr1 + "5");
                Numbr1 = Numbr1 + "5";
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "6");
                Numbr1 = Numbr1 + "6";
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "7");
                Numbr1 = Numbr1 + "7";
            }
        });

        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "8");
                Numbr1 = Numbr1 + "8";
            }
        });

        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoZerio();
                InputView.setText(Numbr1 + "9");
                Numbr1 = Numbr1 + "9";
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputView.setText(Numbr1 + "0");
                Numbr1 = Numbr1 + "0";
            }
        });

        Decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputView.setText(Numbr1 + ".");
                Numbr1 = Numbr1 + ".";
            }
        });


        //*******************************************//

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Oparater.equals("")){
                    Opare();
                    Solution.setText(Numbr2);
                }else{
                    Solution.setText(Numbr1);
                    Numbr1 = "0";
                }
                Oparater = "+";
//                Solution.setText(Numbr2);
                InputView.setText(Oparater);
            }
        });

        Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Oparater.equals("")){
                    Opare();
                    Solution.setText(Numbr2);
                }else{
                    Solution.setText(Numbr1);
                    Numbr2 = Numbr1;
                    Numbr1 = "0";
                }
                Oparater = "-";
//                Solution.setText(Numbr2);
                InputView.setText(Oparater);
            }
        });

        Mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Oparater.equals("")){
                    Opare();
                    Solution.setText(Numbr2);
                }else{
                    Solution.setText(Numbr1);
                    Numbr1 = "0";
                }
                Oparater = "*";
//                Solution.setText(Numbr2);
                InputView.setText(Oparater);
            }
        });

        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Oparater.equals("")){
                    Opare();
                    Solution.setText(Numbr2);
                }else{
                    Solution.setText(Numbr1);
                    Numbr1 = "0";
                }
                Oparater = "/";
                InputView.setText(Oparater);
            }
        });

        Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opare();
                Solution.setText(Numbr2);
                InputView.setText(Numbr1);
            }
        });

        Bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Numbr1.length() > 0){
                    Numbr1 = Numbr1.substring(0,Numbr1.length() - 1);
                    InputView.setText(Numbr1);
                }
            }
        });

        Clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputView.setText("");
                Solution.setText("");
                Numbr1 = "0";
                Numbr2 = "";
                Oparater = "";
            }
        });

    }

    private void RemoZerio() {
        if (Numbr1.equals("0")){
            Numbr1 = "";
        }
    }

    private void Opare() {
        Log.e("INFO",Numbr1);
        Log.e("INFO",Numbr2);

        if (Numbr2.equals(null) || Numbr2.equals("")){
                Numbr2 = Numbr1;
                Numbr1 = "0";
            } else {
                if (!Numbr1.equals(null)) {
                    if (Oparater.equals("-")) {
                        Numbr2 = String.valueOf(Main.Sub(Float.valueOf("0" + Numbr1), Float.valueOf(Numbr2)));
                    }
                    if (Oparater.equals("+")){
                        Numbr2 = String.valueOf(Main.add(Float.valueOf("0" + Numbr1), Float.valueOf(Numbr2)));
                    }
                    if (Oparater.equals("/")){
                        Numbr2 = String.valueOf(Main.div(Float.valueOf("0" + Numbr1), Float.valueOf(Numbr2)));
                    }
                    if (Oparater.equals("*")){
                        Numbr2 = String.valueOf(Main.mult(Float.valueOf("0" + Numbr1), Float.valueOf(Numbr2)));
                    }
                    Numbr1 = "0";
                }
            }
        Oparater = "";
    }

}
