package com.gmstr.mycustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String,String>>  books;
    private static LayoutInflater inflater = null;


    public CustomListViewAdapter(Context context, ArrayList<HashMap<String,String>> data){
        mContext = context;
        books = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView = convertView;
        if(convertView==null){
            myView = inflater.inflate(R.layout.list_row,null);

            TextView title = myView.findViewById(R.id.title);
            TextView author = myView.findViewById(R.id.author);
            TextView pages = myView.findViewById(R.id.pages);
            ImageView image = myView.findViewById(R.id.list_image);

            HashMap<String,String> myBook = new HashMap<>();

            myBook = books.get(position);

            title.setText(myBook.get("title"));
            author.setText(myBook.get("author"));
            pages.setText(myBook.get("pages"));
            image.setImageDrawable(mContext.getDrawable(R.drawable.bookicon));



        }
        return myView;
    }
}
