package com.example.madpracticals.Practical10.Deep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.madpracticals.Practical10.Adapter;
import com.example.madpracticals.Practical10.helper;
import com.example.madpracticals.Practical10.pojo;
import com.example.madpracticals.R;

import java.util.ArrayList;

public class Practical10_ex2_book_details extends AppCompatActivity {

    ListView listView;
    helper h;
    ArrayList<pojo> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical10_ex2);

        listView = findViewById(R.id.listview_details);
        h = new helper(Practical10_ex2_book_details.this);
        lst = h.getData2();
        Adapter adp = new Adapter(Practical10_ex2_book_details.this,lst);
        listView.setAdapter(adp);


    }
}