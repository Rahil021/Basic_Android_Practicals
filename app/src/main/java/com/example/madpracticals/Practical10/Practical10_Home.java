package com.example.madpracticals.Practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.madpracticals.R;
import com.hanks.htextview.fade.FadeTextView;
import com.hanks.htextview.typer.TyperTextView;

import java.util.Calendar;

public class Practical10_Home extends AppCompatActivity {

    LinearLayout NA1,NA2,NA3,NA4;
    LinearLayout hp1,hp2,hp3,hp4;
    TyperTextView name;
    FadeTextView greeting;
    ImageView menu;
    TextView ViewAll2;

    String greet = "Good \nAfternoon,";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical10_home);

        NA1 = findViewById( R.id.NA1);
        NA2 = findViewById( R.id.NA2);
        NA3 = findViewById( R.id.NA3);
        NA4 = findViewById( R.id.NA4);

        hp1 = findViewById( R.id.hp1);
        hp2 = findViewById( R.id.hp2);
        hp3 = findViewById( R.id.hp3);
        hp4 = findViewById( R.id.hp4);


        greeting = findViewById( R.id.greeting);
        name = findViewById( R.id.name);
        menu = findViewById( R.id.menu);
        ViewAll2 = findViewById(R.id.ViewAll2);

        getTimeFromAndroid();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lgrey, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lgrey));
        }


        name.animateText(getString(R.string.user_name));
        greeting.animateText(greet);

        NA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",1);
                startActivity(intent);
                //finish();
            }
        });

        NA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",2);
                startActivity(intent);
                //finish();
            }
        });
        NA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",3);
                startActivity(intent);
                //finish();
            }
        });
        NA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",4);
                startActivity(intent);
                //finish();
            }
        });

        hp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",5);
                startActivity(intent);
                //finish();
            }
        });

        hp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",6);
                startActivity(intent);
                //finish();
            }
        });
        hp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",7);
                startActivity(intent);
                //finish();
            }
        });
        hp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical10_Home.this, book_descrciption.class);
                intent.putExtra("NA",8);
                startActivity(intent);
                //finish();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Practical10_Home.this, your_books.class));
            }
        });

        ViewAll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Practical10_Home.this,ViewAll.class));
            }
        });

    }

    private void getTimeFromAndroid() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            greet = "Good \nMorning,";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            greet = "Good \nAfternoon,";
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            greet = "Good \nEvening,";
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            greet = "Good \nEvening,";
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}