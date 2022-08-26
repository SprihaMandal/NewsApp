package com.sweb.freshnews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdaptor extends ArrayAdapter<NewsModel> {

    private ArrayList<NewsModel> newsList;

    public ArrayList<NewsModel> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<NewsModel> newsList) {
        this.newsList = newsList;
    }

    Context context;
    int resource;
    public NewsAdaptor(@NonNull Context context, int resource, ArrayList<NewsModel> newsList) {
        super(context, resource,newsList);
        this.context=context;
        this.resource=resource;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        int newsIndex=position;
        Log.d("MYAPP","newsIndex::"+position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent, false);
        }
        TextView headingView = convertView.findViewById(R.id.heading_textview);
        TextView descView=convertView.findViewById(R.id.desc_textview);
        ImageView imgView=convertView.findViewById(R.id.news_imageview);
        TextView authorView=convertView.findViewById(R.id.authorView);
        TextView dateTimeView=convertView.findViewById(R.id.dateView);
        headingView.setText(newsList.get(newsIndex).getHeading());
        descView.setText(newsList.get(newsIndex).getDesc());
        Picasso.get().load(newsList.get(newsIndex).getImageUrl()).into(imgView);
        authorView.setText(newsList.get(newsIndex).getAuthor());
        dateTimeView.setText(newsList.get(newsIndex).getDateTime());
        return convertView;
    }
}