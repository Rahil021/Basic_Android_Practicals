package com.example.madpracticals.Practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madpracticals.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class book_return extends AppCompatActivity {

    String book_name,author_name,reg_date;
    String amt_pday,id2;
    Integer id;
    Drawable img;
    ImageView back_btn,book_cover;
    String current_date_time;
    Button return_button;
    Integer diff;
    Float total_amount;
    TextView total_amt;
    helper h;
    RadioButton rb1,rb2;
    RadioGroup rg;
    String[] reg_date_time;
    Integer book_id;

    TextView Book_name,Author_name;
    TextView no_of_days,rent_date,rent_time,amt_pday_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_return);

        Book_name = findViewById(R.id.book_name);
        Author_name = findViewById(R.id.author_name);
        back_btn = findViewById(R.id.back_btn);
        return_button = findViewById(R.id.return_button);
        total_amt = findViewById(R.id.total_amt);

        no_of_days = findViewById(R.id.no_of_days);
        rent_date = findViewById(R.id.rent_date);
        rent_time = findViewById(R.id.rent_time);
        amt_pday_tv = findViewById(R.id.amt_pday);

        book_cover = findViewById(R.id.book_cover_img);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rg = findViewById(R.id.rg);

        rb1.setChecked(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gdark, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gdark));
        }

        Intent intent = getIntent();
        id2 = intent.getStringExtra("id");
        book_name = intent.getStringExtra("book_name");
        author_name = intent.getStringExtra("author_name");
        reg_date = intent.getStringExtra("reg_date");
        amt_pday = intent.getStringExtra("amt_pday");
        book_id = intent.getIntExtra("book_id",0);

        id = Integer.valueOf(id2);

        h = new helper(book_return.this);

        current_date_time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());

        diff = Integer.valueOf(findDifference(current_date_time,reg_date))+1;

        Book_name.setText(book_name);
        Author_name.setText(author_name.replace("by ",""));

        if(diff == 1) {
            no_of_days.setText(diff+ " Day");
        }else {
            no_of_days.setText(diff+ " Days");
        }

        setImage(book_id);

        reg_date_time = reg_date.split(" ");

        rent_date.setText(reg_date_time[0]);
        rent_time.setText(reg_date_time[1]);
        amt_pday_tv.setText(amt_pday);

        total_amount = Float.valueOf(diff * Float.valueOf(amt_pday));
        total_amt.setText("₹"+total_amount);

        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Toast toast = Toast.makeText(book_return.this, ""+amt_pday, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,200,200);
                toast.show();*/

                h.update(id,0);
                Intent intent1 = new Intent(book_return.this,your_books.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                finish();

            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        
    }

    String findDifference(String current_date_time, String reg_date_time) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String diffHrs = "";
        try {
            Date d1 = sdf.parse(current_date_time);
            Date d2 = sdf.parse(reg_date_time);
            long difference_In_Time
                    = d1.getTime() - d2.getTime();
            
            long difference_In_Seconds
                    = (difference_In_Time
                    / 1000)
                    % 60;
            long difference_In_Minutes
                    = (difference_In_Time
                    / (1000 * 60))
                    % 60;
            long difference_In_Hours
                    = (difference_In_Time
                    / (1000 * 60 * 60))
                    % 24;
            long difference_In_Years
                    = (difference_In_Time
                    / (1000l * 60 * 60 * 24 * 365));
            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;

            //diffHrs = String.valueOf(difference_In_Hours)+","+String.valueOf(difference_In_Days);

            diffHrs = String.valueOf(difference_In_Days);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return diffHrs;
    }
    
    public void setImage(Integer id){

        if(id == 1) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.cover_hamlet));
        } else if(id == 2) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.killing_hemingway));
        } else if(id == 3) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.thirteenreasonswhy));
        } else if(id == 4) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.terminal_rage));
        }else if(id == 5) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.philosopher_stone));
        }else if(id == 6) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.chamber_of_secrets2));
        }else if(id == 7) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.prisoner_of_azkaban));
        }else if(id == 8) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.goblet_of_fire));
        }else if(id == 9) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.order_of_phoenix));
        }else if(id == 10) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.half_blood_prince));
        }else if(id == 11) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.deathly_hallows));
        }else if(id == 12) {
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.harry_potter_curse_child));
        }
        
    }
}