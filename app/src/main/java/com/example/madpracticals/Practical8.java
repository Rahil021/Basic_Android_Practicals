package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.airbnb.lottie.LottieAnimationView;

public class Practical8 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    int i = 1;
    Spinner song_spinner;
    Button start,stop;
    boolean f=false;
    ArrayAdapter adapter;
    Boolean bella = true;

    LottieAnimationView gurenge,memories,togoodatgoodbyes,bella_ciao;

    String[] songs = {
            "Gurenge",
            "To Good at Goodbyes",
            "Memories",
            "Bella Ciao"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical8);

        gurenge = findViewById(R.id.anim_f_gurenge);
        memories = findViewById(R.id.anim_f_memories);
        togoodatgoodbyes = findViewById(R.id.anim_f_to_good_at_goodbyes);
        bella_ciao = findViewById(R.id.anim_f_bella_ciao);

        song_spinner = findViewById(R.id.spinner);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,songs);
        song_spinner.setAdapter(adapter);

        song_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position+1){

                    case 1 : i = 1;

                        gurenge.setVisibility(View.VISIBLE);
                        memories.setVisibility(View.INVISIBLE);
                        togoodatgoodbyes.setVisibility(View.INVISIBLE);
                        bella_ciao.setVisibility(View.INVISIBLE);
                        f=true;
                        break;

                    case 2 : i =2;

                        gurenge.setVisibility(View.INVISIBLE);
                        memories.setVisibility(View.INVISIBLE);
                        togoodatgoodbyes.setVisibility(View.VISIBLE);
                        bella_ciao.setVisibility(View.INVISIBLE);
                        f=true;
                        break;

                    case 3 : i = 3;

                        gurenge.setVisibility(View.INVISIBLE);
                        memories.setVisibility(View.VISIBLE);
                        togoodatgoodbyes.setVisibility(View.INVISIBLE);
                        bella_ciao.setVisibility(View.INVISIBLE);
                        f=true;
                        break;

                    case 4 : i = 4;

                        gurenge.setVisibility(View.INVISIBLE);
                        memories.setVisibility(View.INVISIBLE);
                        togoodatgoodbyes.setVisibility(View.INVISIBLE);
                        bella_ciao.setVisibility(View.VISIBLE);
                        f=true;
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (i) {

                    case 1 :
                        mediaPlayer = MediaPlayer.create(Practical8.this, R.raw.gurenge);

                    /*    gurenge.setVisibility(View.VISIBLE);
                        memories.setVisibility(View.INVISIBLE);
                        togoodatgoodbyes.setVisibility(View.INVISIBLE);
                        bella_ciao.setVisibility(View.INVISIBLE);*/

                        gurenge.playAnimation();


                        break;

                    case 2 :
                        mediaPlayer = MediaPlayer.create(Practical8.this, R.raw.to_good_at_goodbyes);

                      /*  gurenge.setVisibility(View.INVISIBLE);
                        memories.setVisibility(View.INVISIBLE);
                        togoodatgoodbyes.setVisibility(View.VISIBLE);
                        bella_ciao.setVisibility(View.INVISIBLE);*/

                        togoodatgoodbyes.playAnimation();

                        break;

                    case 3 :
                        mediaPlayer = MediaPlayer.create(Practical8.this, R.raw.memories);

                     /*   gurenge.setVisibility(View.INVISIBLE);
                        memories.setVisibility(View.INVISIBLE);
                        togoodatgoodbyes.setVisibility(View.INVISIBLE);
                        bella_ciao.setVisibility(View.VISIBLE);*/

                        memories.playAnimation();

                        break;

                    case 4 :
                        mediaPlayer = MediaPlayer.create(Practical8.this, R.raw.bellaciao);

                   /*     gurenge.setVisibility(View.INVISIBLE);
                        memories.setVisibility(View.VISIBLE);
                        togoodatgoodbyes.setVisibility(View.INVISIBLE);
                        bella_ciao.setVisibility(View.INVISIBLE);*/

                        bella_ciao.playAnimation();

                        break;
                }

                mediaPlayer.start();


                stop.setVisibility(View.VISIBLE);
                start.setVisibility(View.INVISIBLE);

                f=false;

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.pause();

                stop.setVisibility(View.INVISIBLE);
                start.setVisibility(View.VISIBLE);
                bella_ciao.cancelAnimation();
                gurenge.cancelAnimation();
                memories.cancelAnimation();
                togoodatgoodbyes.cancelAnimation();
            }
        });


    }

}
