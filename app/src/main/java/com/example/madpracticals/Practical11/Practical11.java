package com.example.madpracticals.Practical11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import org.jetbrains.annotations.NotNull;

public class Practical11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));

    }

    public class MyView extends View{

        MyView(Context context){
            super(context);
        }

        Paint redPaintBrush = new Paint();
        Paint bluePaintBrush = new Paint();
        Paint greenPaintBrush = new Paint();
        Paint whitePaintBrush = new Paint();

        int x = 500;         //Start X Coordinate
        int y = 500;         //Start Y Coordinate
        int x_dir =5;        //X dir anim Speed
        int y_dir =5;       //y dir anim Speed
        int round = 0;       //number of rotation
        int radius = 100;    //Initial Circle Radius

        TimerThread timer = new TimerThread();
        {
            timer.start();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //Initialize all brush
            initBrush();

            //Draw White Canvas (Background)
            drawCanvas(canvas);

            //get Animation Coordinates
            Pair<Integer,Integer> pair = getCoordinates();

            switch (timer.getCount()){
                case 0:
                    drawCircle(pair.first,pair.second,radius+10,canvas,redPaintBrush);
                    break;
                case 1:
                    drawCircle(pair.first,pair.second,radius+30,canvas,bluePaintBrush);
                    break;
                case 2:
                    drawCircle(pair.first,pair.second,radius+60,canvas,greenPaintBrush);
                    break;
            }

            invalidate();
        }

        public void initBrush(){
            whitePaintBrush.setStyle(Paint.Style.FILL);
            whitePaintBrush.setColor(Color.WHITE);

            redPaintBrush.setStyle(Paint.Style.FILL);
            redPaintBrush.setColor(Color.RED);

            bluePaintBrush.setStyle(Paint.Style.FILL);
            bluePaintBrush.setColor(Color.BLUE);

            greenPaintBrush.setStyle(Paint.Style.FILL);
            greenPaintBrush.setColor(Color.GREEN);

        }

        public void drawCanvas(@NotNull Canvas canvas) {
            canvas.drawPaint(whitePaintBrush);
        }

        public void drawCircle(int x,int y,int radius,@NotNull Canvas canvas,Paint brush) {
            canvas.drawCircle(x, y, radius, brush);
        }

        public Pair<Integer,Integer> getCoordinates(){

            if(y>= 500 && x>=500 && y<700 && x<700){
                x = x + x_dir;
                y = y + y_dir;
            }
            else if(x<=700 && y>=700 && x>500 && y<900){
                x = x - x_dir;
                y = y + y_dir;
            }
            else if(x<=500 && y<=900 && x>300 && y>700){
                x = x - x_dir;
                y = y - y_dir;
            }
            else if(x>=300 && y<=700 && x<500 && y>500){
                x = x + x_dir;
                y = y - y_dir;
                if(x==500 && y==500){
                    round++;
                }
            }
            return new Pair(x,y);
        }
    }
}