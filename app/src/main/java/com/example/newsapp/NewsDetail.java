package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetail extends AppCompatActivity {

    String title,description,url,content,imageUrl;
    private TextView titleView , subTitleView , contentView ;
    private ImageView imageView ;
    private ScrollView scrollView;
    private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        title = getIntent().getStringExtra("title");
        imageUrl = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        description = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");

        titleView = findViewById(R.id.title2);
        subTitleView = findViewById(R.id.title3);
        contentView = findViewById(R.id.title4);
        button = findViewById(R.id.btnReadNews);
        imageView = findViewById(R.id.image2);

        titleView.setText(title);
        subTitleView.setText(description);
        contentView.setText(content);
        Picasso.get().load(imageUrl).into(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}