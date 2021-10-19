package com.example.madpracticals.Practical10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.madpracticals.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context c;
    ArrayList<pojo> list;

    public Adapter(Context c, ArrayList<pojo> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.custom_listview_for_prac10,null);

        TextView name = (TextView) v.findViewById(R.id.user_name_data);
        TextView book_name =(TextView) v.findViewById(R.id.book_name);
        TextView reg_date = (TextView) v.findViewById(R.id.reg_date);
        TextView due_date = (TextView) v.findViewById(R.id.due_date_data);
        pojo p = (pojo) list.get(position);
        name.setText(p.getName());
        book_name.setText(p.getBook());
        reg_date.setText(p.getReg_date());
        due_date.setText(p.getDue_date());

        return v;
    }
}
