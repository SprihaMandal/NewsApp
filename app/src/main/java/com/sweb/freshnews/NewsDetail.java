package com.sweb.freshnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsDetail extends AppCompatActivity {
    String passedDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        TextView newsDetailsView = findViewById(R.id.newsDetailView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            passedDetails=extras.getString("details");
        }else{
            passedDetails="Subscribe to see more";
        }
        newsDetailsView.setText(passedDetails);

        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}