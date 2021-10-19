package com.example.madpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madpracticals.Practical10.Practical10_Home;
import com.example.madpracticals.Practical11.Practical11;
import com.example.madpracticals.Practical12.Practical12;

public class List_view_for_swapping_pracs extends AppCompatActivity {

    ListView listview;

    String[] PracName = {
            "Practical 1", "Practical 2",
            "Practical 3", "Practical 4",
            "Practical 5", "Practical 6",
            "Practical 7", "Practical 8",
            "Practical 9", "Practical 10",
            "Practical 11", "Practical 12"
    };

    String[] PracInfo = {
            "Welcome to Android!", "Working of Colors, dimens & strings XML files ",
            "Activity Life-cycle", " Change the backgroun color/img",
            "Calculator", "Explicit Intents","onClick Listner","Music Player",
            "Currency Converter" , "Library Management Using SQLite Database",
            "Working with canvas..", "Implementation of Google Map Direction API"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practical6_activity_list_view_for_swapping_pracs);

        listview = findViewById(R.id.listview);

        CustomAdapter adapter = new CustomAdapter();
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position+1)
                {
                    case 1:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical1.class)); break;

                    case 2:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical2.class)); break;

                    case 3:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical3.class)); break;

                    case 4:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical4.class)); break;

                    case 5:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical5.class)); break;

                    case 6:  Toast.makeText(List_view_for_swapping_pracs.this, "This is practical 6 ", Toast.LENGTH_SHORT).show();break;

                    case 7:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical7.class)); break;

                    case 8:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical8.class)); break;

                    case 9:  startActivity(new Intent(List_view_for_swapping_pracs.this,Practical9.class)); break;

                    case 10:  startActivity(new Intent(List_view_for_swapping_pracs.this, Practical10_Home.class)); break;

                    case 11:  startActivity(new Intent(List_view_for_swapping_pracs.this, Practical11.class)); break;

                    case 12:  startActivity(new Intent(List_view_for_swapping_pracs.this, Practical12.class)); break;

                    default:
                        Toast.makeText(List_view_for_swapping_pracs.this, "Coming Soon!", Toast.LENGTH_SHORT).show(); break;
                }


            }
        });


    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return PracName.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.mylist,null);
            TextView Driver = convertView.findViewById(R.id.Driver);
            TextView Route = convertView.findViewById(R.id.Route);

            Driver.setText(PracName[position]);
            Route.setText(PracInfo[position]);

            return convertView;
        }
    }
}

