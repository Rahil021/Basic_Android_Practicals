package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Practical4 extends AppCompatActivity {

    ConstraintLayout c_layout;
    TextView tv;
    Boolean first = false;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical4);

        tv = findViewById(R.id.tv);
        c_layout = findViewById(R.id.c_layout);

        c_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;

                if(first == false){

                    tv.setTextColor(getResources().getColor(R.color.White));
                    c_layout.setBackground(getResources().getDrawable(R.drawable.background));
                    first = true;
                }else{
                    tv.setTextColor(getResources().getColor(R.color.Blue));
                    c_layout.setBackgroundColor(getResources().getColor(R.color.White));
                    first = false;
                }


            }
        });

    }
}