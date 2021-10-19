package com.example.madpracticals.Practical10;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madpracticals.Practical10.Swipe.SwipeController;
import com.example.madpracticals.Practical10.Swipe.SwipeControllerActions;
import com.example.madpracticals.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class rAdapter extends RecyclerView.Adapter<rAdapter.MyViewHolder2> {

    Context con;
    ArrayList<pojo> list;
    SwipeController swipeController;
    RecyclerView recyclerView;

    public rAdapter(){}

    public rAdapter(Context c, ArrayList<pojo> list) {
        this.con = c;
        this.list = list;

        Log.v("Arraylist_size","Constructor call "+list.size());
    }

    public rAdapter(Context c, ArrayList<pojo> list,RecyclerView recyclerView) {
        this.con = c;
        this.list = list;
        this.recyclerView = recyclerView;

        Log.v("Arraylist_size","Constructor call "+list.size());
    }

    @Override
    public @NotNull MyViewHolder2 onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(con).inflate(R.layout.your_books_cv, parent, false);
        Log.v("Arraylist_size","onCreateViewHolder");

        return new MyViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

        String book_name="";
        String author = null;
        Integer book_id;
        String[] reg_date;
        Drawable img_id = null;

        Log.v("Arraylist_size","onBindViewHolder");
        pojo p = (pojo) list.get(position);

        reg_date = p.getReg_date().split(" ");
        holder.reg_date.setText(reg_date[0]);

        Log.v("Arraylist_size","BS "+p.getBook_status());

        book_id = p.getBook_id();
        Log.v("Arraylist_size",""+list.size());

        if(book_id == 1) {
            author = "by William Shakespeare";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.cover_hamlet));
        } else if(book_id == 2) {
            author = "by Arthur Byrne";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.killing_hemingway));
        } else if(book_id == 3) {
            author = "by Jay Asher";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.thirteenreasonswhy));
        } else if(book_id == 4) {
            author = "by A. M. Khalifa";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.terminal_rage));
        }else if(book_id == 5) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.philosopher_stone));
            img_id = con.getResources().getDrawable(R.drawable.philosopher_stone);
        }else if(book_id == 6) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.chamber_of_secrets2));
        }else if(book_id == 7) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.prisoner_of_azkaban));
        }else if(book_id == 8) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.goblet_of_fire));
        }else if(book_id == 9) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.order_of_phoenix));
        }else if(book_id == 10) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.half_blood_prince));
        }else if(book_id == 11) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.deathly_hallows));
        }else if(book_id == 12) {
            author = "by J.K. Rowling";
            book_name = p.getBook().replace(author,"");
            holder.book_name.setText(book_name);
            holder.author_name.setText(author);
            holder.your_books_cover.setImageDrawable(con.getResources().getDrawable(R.drawable.harry_potter_curse_child));
        }

        String finalBook_name = book_name;
        String finalAuthor = author;
        Drawable finalImg_id = img_id;

        if( p.getBook_status() == 1) {

            holder.book_status.setText("Active");
            holder.book_status.setTextColor(con.getResources().getColor(R.color.tree_green));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(con, book_return.class);
                    intent.putExtra("id", p.getId());
                    intent.putExtra("book_name", finalBook_name);
                    intent.putExtra("author_name",finalAuthor);
                    intent.putExtra("reg_date",p.getReg_date());
                    intent.putExtra("amt_pday",p.getAmt_pday());
                    intent.putExtra("book_id",Integer.valueOf(p.getBook_id()));
                    con.startActivity(intent);

                }
            });

        }else if(p.getBook_status() == 0) {

            holder.book_status.setText("Returned & Paid");
            holder.book_status.setTextColor(con.getResources().getColor(R.color.white));

            holder.itemView.setClickable(false);

        }

    }

    @Override
    public int getItemCount() {

        Log.v("Arraylist_size",""+list.size());

        return list.size();

    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView book_name,author_name,reg_date,book_status;
        ImageView your_books_cover;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            Log.v("Arraylist_size","MyViewHolder2");

            book_name = (TextView) itemView.findViewById(R.id.book_name);
            author_name = (TextView) itemView.findViewById(R.id.author_name);
            reg_date = (TextView) itemView.findViewById(R.id.reg_date);
            book_status =(TextView) itemView.findViewById(R.id.book_status);
            your_books_cover = itemView.findViewById(R.id.your_books_cover);

        }
    }

}
