package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.hanks.htextview.typer.TyperTextView;

public class Practical7 extends AppCompatActivity {

    Button button1;
    TyperTextView typerTextView;
    LottieAnimationView animation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical7);

        button1 = findViewById(R.id.button1);
        typerTextView = findViewById(R.id.typerTextView);
        animation_view = findViewById(R.id.animation_view);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                typerTextView.setVisibility(View.VISIBLE);
                typerTextView.animateText("Button 1 clicked");
                animation_view.setVisibility(View.VISIBLE);
                animation_view.playAnimation();

            }
        });


    }
}