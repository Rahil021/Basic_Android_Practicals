package com.example.madpracticals;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hanks.htextview.typer.TyperTextView;

import java.text.DecimalFormat;

public class Practical9 extends AppCompatActivity {

    Spinner sp;
    EditText amount;
    String[] select = {"₹ INR (\uD83C\uDDEE\uD83C\uDDF3 ) to $ USD (\uD83C\uDDFA\uD83C\uDDF8)","$ USD (\uD83C\uDDFA\uD83C\uDDF8) to ₹ INR (\uD83C\uDDEE\uD83C\uDDF3)"};
    String selected;
    Button Convert_btn;
    TyperTextView converted_currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical9);

        amount = findViewById(R.id.amount);
        converted_currency = findViewById(R.id.converted_currency);
        sp = findViewById(R.id.spinner_1);
        Convert_btn = findViewById(R.id.Convert_btn);


        if (converted_currency.getVisibility() == View.VISIBLE)
        {
            converted_currency.setVisibility(View.INVISIBLE);
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list,R.id.list_tv,select);
        sp.setAdapter(adapter);


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selected = sp.getSelectedItem().toString();
                //Toast.makeText(Practical9.this, ""+selected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Convert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected == select[0])
                {
                    //Toast.makeText(Practical9.this, "selected 1", Toast.LENGTH_SHORT).show();
                    Double i = Double.valueOf(amount.getText().toString());

                    Double ans = i * 0.014;
                    DecimalFormat df = new DecimalFormat("#.##");

                    if (converted_currency.getVisibility() == View.INVISIBLE) {
                        converted_currency.setVisibility(View.VISIBLE);
                    }

                    converted_currency.animateText("$ "+df.format(ans).toString()+" ");

                }
                else{
                    //Toast.makeText(Practical9.this, "selected 2", Toast.LENGTH_SHORT).show();

                    Double i = Double.valueOf(amount.getText().toString());

                    Double ans = i * 75.05;
                    DecimalFormat df = new DecimalFormat("#.##");


                    if (converted_currency.getVisibility() == View.INVISIBLE) {
                        converted_currency.setVisibility(View.VISIBLE);
                    }
                    converted_currency.animateText("₹ "+df.format(ans).toString()+" ");
                }
            }
        });

    }
}