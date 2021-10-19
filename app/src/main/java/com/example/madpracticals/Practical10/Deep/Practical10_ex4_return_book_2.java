package com.example.madpracticals.Practical10.Deep;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madpracticals.Practical10.helper;
import com.example.madpracticals.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Practical10_ex4_return_book_2 extends AppCompatActivity {

    TextView name, book_name, reg_date, return_date, charges, charge_tv;
    Button return_book_btn;
    String sId, sname, sbook, sRegDate, sDueDate;
    String hr, day;
    int time;
    //ArrayList<pojoReturn> list1, list2;
    helper h;
    String return_time, charge1, charge2;
    ProgressDialog pd;

    /*class logicTask extends AsyncTask<Void,Void,Void>
    {
    @Override
    protected void onPreExecute() {
    super.onPreExecute();
    }
    @Override
    protected Void doInBackground(Void... voids) {
    return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
    super.onPostExecute(aVoid);
    }
    }*/
    static String findDifference(String dueTime, String returnTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String diffHrs = "";
        try {
        // parse method is used to parse
        // the text from a string to
        // produce the date
            Date d1 = sdf.parse(dueTime);
            Date d2 = sdf.parse(returnTime);
        // Calucalte time difference
        // in milliseconds
            long difference_In_Time
                    = d2.getTime() - d1.getTime();
        // Calucalte time difference in
        // seconds, minutes, hours, years,
        // and days
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
           // diffHrs = String.valueOf(difference_In_Hours);

            diffHrs = String.valueOf(difference_In_Hours)+","+String.valueOf(difference_In_Days);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return diffHrs;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical10_ex4);

        name = findViewById(R.id.name_data_5);
        book_name = findViewById(R.id.book_data_5);
        reg_date = findViewById(R.id.reg_date_data_5);
        return_date = findViewById(R.id.due_date_data_5);
        charges = findViewById(R.id.charge_data_5);
        charge_tv = findViewById(R.id.charge_tv_5);
        return_book_btn = findViewById(R.id.return_btn_data_5);

        pd = new ProgressDialog(Practical10_ex4_return_book_2.this);
        pd.setTitle("Loading");
        pd.show();

        charges.setVisibility(View.INVISIBLE);
        charge_tv.setVisibility(View.INVISIBLE);
        return_book_btn.setVisibility(View.INVISIBLE);

        Intent i = getIntent();
        sId = i.getStringExtra("id");
        sname = i.getStringExtra("name");
        sbook = i.getStringExtra("book");
        sRegDate = i.getStringExtra("reg_date");
        sDueDate = i.getStringExtra("return_date");
        return_time = i.getStringExtra("return_time");

        name.setText(sname);
        book_name.setText(sbook);
        reg_date.setText(sRegDate);
        return_date.setText(sDueDate);


        charge1 = findDifference(sDueDate,return_time);
        String[] array = charge1.split(",");

        hr = array[0];
        day = array[1];

        time = (Integer.valueOf(day) *24) + Integer.valueOf(hr);
        //charge1 = "50";

        //Toast.makeText(this, "click time:"+return_time+"\n"+"c1 :"+charge1+"\nhr"+array[0]+"\nday :"+array[1]+"\n time:"+String.valueOf(time), Toast.LENGTH_LONG).show();

        //charge1 = findDifference(sDueDate, return_time);
        // Toast.makeText(this, "c1 :"+charge1+"\nc2 :"+charge2,Toast.LENGTH_SHORT).show();

        if (time <= 2) {
            return_book_btn.setVisibility(View.VISIBLE);
            return_book_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    h.delete(sId);
                    Toast.makeText(Practical10_ex4_return_book_2.this, "Your book successfully returned !!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Practical10_ex4_return_book_2.this, Practical10.class));
                    finish();
                }
            });
        } else if (time <= 24 && time > 2) {
            charges.setVisibility(View.VISIBLE);
            charge_tv.setVisibility(View.VISIBLE);
            double num = (double) (time * 10) / 24;
            int num2 = (int) Math.round(num);
            String text = Integer.toString(num2) + " Rs. (" + String.valueOf(time) + " Hours late)";
            charges.setText(text);
        } else {
            charges.setVisibility(View.VISIBLE);
            charge_tv.setVisibility(View.VISIBLE);
            double day = (double) (time) / 24;
            int days = (int) Math.floor(day);
            double num = (double) (time * 10) / 24;
            int num2 = (int) Math.round(num);
            String text = Integer.toString(num2) + " Rs. (" + Integer.toString(days) + " Days late)";
            charges.setText(text);
        }
        //Toast.makeText(getApplicationContext(),"ID :"+sId+",\nName:"+sname,Toast.LENGTH_SHORT).show();
        h = new helper(Practical10_ex4_return_book_2.this);
        pd.dismiss();
    }
}