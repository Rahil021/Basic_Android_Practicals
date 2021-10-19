package com.example.madpracticals.Practical10.Deep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.madpracticals.R;

public class Practical10 extends AppCompatActivity {

    Button btn1, btn2, btn3;
    //String date,date1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical10);

        btn1 = findViewById(R.id.buy_book);
        btn2 = findViewById(R.id.return_book);
        btn3 = findViewById(R.id.get_details);

        //date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",Locale.getDefault().format(new Date());

        //date1 = addHour(date,2);
        //Toast.makeText(this, "current :"+date+"\n after"+"\n 2 hrs :"+date1, Toast.LENGTH_SHORT).show();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Practical10.this, Practical10_ex1_get_book.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Practical10.this, Practical10_ex3_return_book1.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Practical10.this, Practical10_ex2_book_details.class));
            }
        });


    }
}