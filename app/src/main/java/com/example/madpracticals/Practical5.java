package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Practical5 extends AppCompatActivity {

    double in1 = 0, i2 = 0;
    TextView edittext1,textview;
    boolean Add, Sub, Multiply, Divide, Remainder, deci;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot, button_Remainder;
    Integer count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical5);

        button_0 =  findViewById(R.id.b0);
        button_1 =  findViewById(R.id.b1);
        button_2 =  findViewById(R.id.b2);
        button_3 =  findViewById(R.id.b3);
        button_4 =  findViewById(R.id.b4);
        button_5 =  findViewById(R.id.b5);
        button_6 =  findViewById(R.id.b6);
        button_7 =  findViewById(R.id.b7);
        button_8 =  findViewById(R.id.b8);
        button_9 =  findViewById(R.id.b9);
        button_Dot =  findViewById(R.id.bDot);
        button_Add =  findViewById(R.id.badd);
        button_Sub =  findViewById(R.id.bsub);
        button_Mul =  findViewById(R.id.bmul);
        button_Div =  findViewById(R.id.bdiv);
        button_Remainder =  findViewById(R.id.BRemain);
        button_Del =  findViewById(R.id.buttonDel);
        button_Equ =  findViewById(R.id.buttoneql);

        edittext1 = findViewById(R.id.display);
        textview = findViewById(R.id.display2);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "9");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "0");
            }
        });

        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    textview.setText((int) in1 +"+");
                    Add = true;
                    deci = false;
                    edittext1.setText(null);
                    count++;

                }
            }
        });

        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    textview.setText((int) in1 +"-");
                    Sub = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    textview.setText((int) in1 +"x");
                    Multiply = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    textview.setText((int) in1 +"÷");
                    Divide = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Remainder = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                equal();
                count = 1;

            }
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText("");
                textview.setText("");
                in1 = 0.0;
                i2 = 0.0;
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deci) {
                    //do nothing or you can show the error
                } else {
                    edittext1.setText(edittext1.getText() + ".");
                    deci = true;
                }

            }
        });
    }

    public void equal(){

        if (Add || Sub || Multiply) {
            i2 = Float.parseFloat(edittext1.getText() + "");
        }else if( Divide || Remainder){
            i2 = Float.parseFloat(edittext1.getText() + "");
        }

        if (Add) {

            edittext1.setText(in1 + i2 + "");

            String x = String.valueOf(in1);
            String y = String.valueOf(i2);

            textview.setText( x + " + "+ y+" =" );
            Add = false;
        }

        if (Sub) {

            edittext1.setText(in1 - i2 + "");

            String x = String.valueOf(in1);
            String y = String.valueOf(i2);

            textview.setText( x + " - "+ y+" =" );
            Sub = false;
        }

        if (Multiply) {
            edittext1.setText(in1 * i2 + "");

            String x = String.valueOf(in1);
            String y = String.valueOf(i2);

            textview.setText( x + " x "+ y+" =" );

            Multiply = false;
        }

        if (Divide) {
            edittext1.setText(in1 / i2 + "");

            String x = String.valueOf(in1);
            String y = String.valueOf(i2);

            textview.setText( x + " ÷ "+ y+" =" );

            Divide = false;
        }
        if (Remainder) {
            edittext1.setText(in1 % i2 + "");
            Remainder = false;
        }

    }

}


