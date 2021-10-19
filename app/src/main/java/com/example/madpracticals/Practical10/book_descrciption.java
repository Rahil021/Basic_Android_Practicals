package com.example.madpracticals.Practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madpracticals.Practical10.Deep.Practical10;
import com.example.madpracticals.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class book_descrciption extends AppCompatActivity {
    
    int NA;
    TextView book_name,author_name;
    TextView book_desc;
    ImageView book_cover,more_btn,back_btn;
    Button rent_btn;
    helper h;
    String u_name,reg_date,due_date;
    double Amount_per_Day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_descrciption);

        book_name = findViewById(R.id.book_name);
        author_name = findViewById(R.id.author_name);
        book_desc = findViewById(R.id.book_desc);
        book_cover = findViewById(R.id.book_cover);
        more_btn= findViewById(R.id.more_btn);
        back_btn= findViewById(R.id.back_btn);
        rent_btn = findViewById(R.id.rent_btn);

        Intent intent = getIntent();
        NA = intent.getIntExtra("NA",0);

        u_name = getString(R.string.user_name);

        reg_date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",
                Locale.getDefault()).format(new Date());
        due_date = addHour(reg_date,2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gdark, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gdark));
        }

        h = new helper(book_descrciption.this);
        
        if (NA == 1)
        {
            book_name.setText("Hamlet");
            author_name.setText("William Shakespeare");
            book_desc.setText(getString(R.string.Hamlet_desc));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.cover_hamlet));
            rent_btn.setText("RENT |   ₹3.50 / D");
            Amount_per_Day = 3.50;
        }
        else if(NA == 2)
        {
            book_name.setText("Killing Hemingway");
            author_name.setText("Arthur Byrne");
            book_desc.setText(getString(R.string.killing_hemm));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.killing_hemingway));
            rent_btn.setText("RENT |   ₹1.00 / D");
            Amount_per_Day = 1;
        }
        else if(NA == 3)
        {
            book_name.setText("13 Reasons Why");
            author_name.setText("Jay Asher");
            book_desc.setText(getString(R.string.ThieteenReasonsWhy));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.thirteenreasonswhy));
            rent_btn.setText("RENT |   ₹1.50 / D");
            Amount_per_Day = 1.50;
        }
        else if(NA == 4)
        {
            book_name.setText("Terminal Rage");
            author_name.setText("A. M. Khalifa");
            book_desc.setText(getString(R.string.terminal_rage));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.terminal_rage));
            rent_btn.setText("RENT |   ₹1.00 / D");
            Amount_per_Day = 1;
        }else if(NA == 5) {
            book_name.setText("Philosophers Stone");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.philosophers_stone));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.philosopher_stone));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }else if(NA == 6) {
            book_name.setText("Chamber of Secret");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.chamber_of_secrets));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.chamber_of_secrets2));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }else if(NA == 7) {
            book_name.setText("Prisoner of Azkaban");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.prisoner_of_azkaban));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.prisoner_of_azkaban));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }else if(NA == 8) {
            book_name.setText("Goblet of Fire");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.goblet_of_fire));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.goblet_of_fire));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }else if(NA == 9) {
            book_name.setText("Order of Phoenix");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.order_of_phoenix));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.order_of_phoenix));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }else if(NA == 10) {
            book_name.setText("Half-Blood Prince");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.half_blood_prince));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.half_blood_prince));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }else if(NA == 11) {
            book_name.setText("Deathly Hallows");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.deathly_hallows));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.deathly_hallows));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }else if(NA == 12) {
            book_name.setText("Curse Child");
            author_name.setText("J.K. Rowling");
            book_desc.setText(getString(R.string.curse_child));
            book_cover.setImageDrawable(getResources().getDrawable(R.drawable.harry_potter_curse_child));
            rent_btn.setText("RENT |   ₹5.00 / D");
            Amount_per_Day = 5;
        }

        rent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(book_descrciption.this);
                builder.setTitle("Confirmation...")
                        .setMessage("Are you sure you want to rent this book?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                h.insert2(""+u_name,book_name.getText().toString()+" by "+author_name.getText().toString(),NA,""+Amount_per_Day,""+reg_date,""+due_date,1);
                                Toast.makeText(book_descrciption.this, "Rented Succesfully!", Toast.LENGTH_SHORT).show();

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        rent_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        more_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(book_descrciption.this, Practical10.class));
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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