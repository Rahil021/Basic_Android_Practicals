package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Practical3 extends AppCompatActivity {

    TextView mthd_invoked;
    String invoked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical3);
        mthd_invoked = findViewById(R.id.mthd_invoked);
        Toast.makeText(Practical3.this, "onCreate()", Toast.LENGTH_SHORT).show();
        invoked = "onCreate()";
        mthd_invoked.setText(invoked);
        Log.v("Lifecycyle",""+invoked);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Practical3.this, "onStart()", Toast.LENGTH_SHORT).show();
        invoked = "onStart()";
        mthd_invoked.setText(invoked);
        Log.v("Lifecycyle",""+invoked);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Practical3.this, "onResume()", Toast.LENGTH_SHORT).show();
        invoked = "onResume()";
        mthd_invoked.setText(invoked);
        Log.v("Lifecycyle",""+invoked);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Practical3.this, "onPause()", Toast.LENGTH_SHORT).show();
        invoked = "onPause()";
        mthd_invoked.setText(invoked);
        Log.v("Lifecycyle",""+invoked);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(Practical3.this, "onStop()", Toast.LENGTH_SHORT).show();
        invoked = "onStop()";
        mthd_invoked.setText(invoked);
        Log.v("Lifecycyle",""+invoked);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(Practical3.this, "onRestart()", Toast.LENGTH_SHORT).show();
        invoked = "onRestart()";
        mthd_invoked.setText(invoked);
        Log.v("Lifecycyle",""+invoked);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Practical3.this, "onDestroy()", Toast.LENGTH_SHORT).show();
        invoked = "onDestroy()";
        mthd_invoked.setText(invoked);
        Log.v("Lifecycyle",""+invoked);
    }
}