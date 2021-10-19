package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

public class No_Internet extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Button retry_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        constraintLayout = findViewById(R.id.noInt_check);

            checkInternet();
    }

    public boolean isNetworkAvailable()
    {
        try
        {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;

            if(manager != null)
            {
                networkInfo = manager.getActiveNetworkInfo();
            }

            return networkInfo!=null && networkInfo.isConnected();

        }
        catch (Exception e)
        {
            return false;
        }
    }

    void checkInternet()
    {
        if(isNetworkAvailable())
        {
            Toast.makeText(this, "You are connected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Not Connected", Toast.LENGTH_SHORT).show();
            LayoutInflater inflater = LayoutInflater.from(No_Internet.this); // 1
            View theInflatedView = inflater.inflate(R.layout.retry_layout, null);// 2 and 3

            retry_button = theInflatedView.findViewById(R.id.retry_button);
            setContentView(theInflatedView);

            retry_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(No_Internet.this,No_Internet.class);
                    finish();
                    startActivity(intent);
                    overridePendingTransition(R.anim.drop_down,R.anim.fade_out);
                }
            });

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkInternet();

    }
}