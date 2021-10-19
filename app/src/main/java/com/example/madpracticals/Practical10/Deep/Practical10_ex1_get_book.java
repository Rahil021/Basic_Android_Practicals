package com.example.madpracticals.Practical10.Deep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.madpracticals.Practical10.helper;
import com.example.madpracticals.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Practical10_ex1_get_book extends AppCompatActivity {

    EditText et;
    Spinner sp;
    Button get_book;
    String sid,sname,sbook,sreg_date,sdue_date;
    helper h;
    String reg_date,due_date;
    String[] books = {"Let Us C","Python Crash Course","Web Development",
            "Android Application Development","Flutter Programming","Kotlin Programming",
            "Artificial Intelligence for Beginners","Engineering Mathematics",
            "Machine Learning for Hackers",
            "Cyber Security","JavaScript Programming"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical10_ex1);

        et = findViewById(R.id.name_et_10);
        sp = findViewById(R.id.spinner_book_10);
        get_book = findViewById(R.id.get_book_activity);

        h = new helper(Practical10_ex1_get_book.this);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,books);
        sp.setAdapter(arrayAdapter);

        reg_date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",
                Locale.getDefault()).format(new Date());
        due_date = addHour(reg_date,2);

        get_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h.insert(et.getText().toString(),sp.getSelectedItem().toString(),reg_date,due_date);
                startActivity(new Intent(Practical10_ex1_get_book.this,Practical10.class));
                finish();
            }
        });
    }
    public static String addHour(String myTime,int hrs)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date d = df.parse(myTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);cal.add(Calendar.HOUR, hrs);
            String newTime = df.format(cal.getTime());
            return newTime;
        }
        catch(Exception e)
        {
            System.out.println(" Parsing Exception");
        }
        return null;


    }
}