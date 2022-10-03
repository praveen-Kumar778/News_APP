package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<Articles> articles ;
    private Context context;

    public NewsAdapter(ArrayList<Articles> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        Articles articles1 =  articles.get(position);
        holder.title.setText(articles1.getTitle());
        holder.subHead.setText(articles1.getDescription());
        Picasso.get().load(articles1.getUrlToImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NewsDetail.class);
                intent.putExtra("title",articles1.getTitle());
                intent.putExtra("content",articles1.getContent());
                intent.putExtra("desc",articles1.getDescription());
                intent.putExtra("image",articles1.getUrlToImage());
                intent.putExtra("url",articles1.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView subHead;
        ImageView imageView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.newstext);
            subHead = itemView.findViewById(R.id.subHeading);
            imageView = itemView.findViewById(R.id.newsimage);

        }
    }
}
