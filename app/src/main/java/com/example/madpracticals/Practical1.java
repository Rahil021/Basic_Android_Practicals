package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Practical1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical1);

        checkInternet();

    }

    void checkInternet()
    {
        Context context = Practical1.this;
        Button retry_button;
        NoInternet obj = new NoInternet();

        if(obj.isNetworkAvailable(context))
        {
            Toast.makeText(this, "You are connected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Not Connected", Toast.LENGTH_SHORT).show();
            LayoutInflater inflater = LayoutInflater.from(Practical1.this); // 1
            View theInflatedView = inflater.inflate(R.layout.retry_layout, null);// 2 and 3

            retry_button = theInflatedView.findViewById(R.id.retry_button);
            setContentView(theInflatedView);

            retry_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Practical1.this,Practical1.class);
                    finish();
                    startActivity(intent);
                    overridePendingTransition(R.anim.drop_down,R.anim.fade_out);
                }
            });

        }
    }

}