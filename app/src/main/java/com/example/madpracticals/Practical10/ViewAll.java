package com.example.madpracticals.Practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.madpracticals.R;

public class ViewAll extends AppCompatActivity {
    
    LinearLayout hp1,hp2,hp3,hp4,hp5,hp6,hp7,hp8;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        hp1 = findViewById( R.id.hp1);
        hp2 = findViewById( R.id.hp2);
        hp3 = findViewById( R.id.hp3);
        hp4 = findViewById( R.id.hp4);
        hp5 = findViewById( R.id.hp5);
        hp6 = findViewById( R.id.hp6);
        hp7 = findViewById( R.id.hp7);
        hp8 = findViewById( R.id.hp8);

        back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gdark, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gdark));
        }

        hp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",5);
                startActivity(intent);
                //finish();
            }
        });

        hp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",6);
                startActivity(intent);
                //finish();
            }
        });
        hp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",7);
                startActivity(intent);
                //finish();
            }
        });
        hp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",8);
                startActivity(intent);
                //finish();
            }
        });

        hp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",9);
                startActivity(intent);
                //finish();
            }
        });

        hp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",10);
                startActivity(intent);
                //finish();
            }
        });
        hp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",11);
                startActivity(intent);
                //finish();
            }
        });
        hp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, book_descrciption.class);
                intent.putExtra("NA",12);
                startActivity(intent);
                //finish();
            }
        });
        
        
    }
}