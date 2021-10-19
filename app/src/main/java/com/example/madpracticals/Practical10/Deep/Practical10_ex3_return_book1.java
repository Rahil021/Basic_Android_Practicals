package com.example.madpracticals.Practical10.Deep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.madpracticals.Practical10.helper;
import com.example.madpracticals.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Practical10_ex3_return_book1 extends AppCompatActivity {

    EditText name;
    String sname, sbook_name, return_time;
    Spinner sp;
    String rtnId, rtnname, rtnbook, rtnRegDate, rtnDueDate;
    Button btn;
    String[] books = {"Let Us C", "Python Crash Course", "Web Development", "Android Application Development",
            "Flutter Programming", "Kotlin Programming",
            "Artificial Intelligence for Beginners", "Engineering Mathematics",
            "Machine Learning for Hackers",
            "Cyber Security", "JavaScript Programming"};
    helper h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical10_ex3);

        name = findViewById(R.id.name_return_et_4);
        sp = findViewById(R.id.sp_return_4);
        btn = findViewById(R.id.btn_return_4);
        return_time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, books);
        sp.setAdapter(arrayAdapter);
        sname = name.getText().toString();
        sbook_name = sp.getSelectedItem().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent i = new Intent(pract_10_4.this,pract_10_5.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("book",sp.getSelectedItem().toString());
                startActivity(i);*/

                h = new helper(getApplicationContext());
                Cursor c = h.returnBook(name.getText().toString(), sp.getSelectedItem().toString());

                StringBuffer sb = new StringBuffer();

                while (c.moveToNext()) {

                    /*sb.append("ID :"+c.getString(0)+",\n");sb.append("Name :"+c.getString(1)+",\n");
                    sb.append("Book :"+c.getString(2)+",\n");
                    sb.append("reg_date :"+c.getString(3)+",\n");
                    sb.append("return_date :"+c.getString(4)+",\n");*/

                    rtnId = c.getString(0);
                    rtnname = c.getString(1);
                    rtnbook = c.getString(2);
                    rtnRegDate = c.getString(3);
                    rtnDueDate = c.getString(4);
                }
                Intent i = new Intent(Practical10_ex3_return_book1.this, Practical10_ex4_return_book_2.class);
                i.putExtra("id", rtnId);
                i.putExtra("name", rtnname);
                i.putExtra("book", rtnbook);
                i.putExtra("reg_date", rtnRegDate);
                i.putExtra("return_date", rtnDueDate);
                i.putExtra("return_time", return_time);
                startActivity(i);

                //Toast.makeText(pract_10_4.this,""+sb,Toast.LENGTH_SHORT).show();
            }
        });


    }
}