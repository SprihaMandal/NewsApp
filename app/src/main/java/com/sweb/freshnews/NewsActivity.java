package com.sweb.freshnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    Toolbar toolbar;
    public ArrayList<String>newsContent;
    private ArrayList<NewsModel> frNewsList;
    NewsAdaptor nAdaptor;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//            new MenuInflater(this).inflate(R.menu.opt_menu, menu);
//            return super.onCreateOptionsMenu(menu);
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        toolbar=findViewById(R.id.newsToolbar);
        setSupportActionBar(toolbar);
        frNewsList=new ArrayList<>();
        newsContent=new ArrayList<>();
        String url= "https://saurav.tech/NewsAPI/everything/cnn.json";
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("myapp", "Response:: " + response.toString());
                    JSONArray jsonArray = response.getJSONArray("articles");
                    Log.d("myapp",jsonArray.toString());
                    for(int i=0;i<=20;i++){
                        JSONObject item =jsonArray.getJSONObject(i);
                        String title=item.getString("title");
                        String description=item.getString("description");
                        String urlToImage=item.getString("urlToImage");
                        String author=item.getString("author");
                        String published=item.getString("publishedAt");
                        String contentDetail=item.getString("content");
                        published=published.substring(0, 10);
                        newsContent.add(contentDetail);
                        frNewsList.add(new NewsModel(title,description,urlToImage,published,author));
                    }
                }catch (Exception e){
                    Log.d("myapp",e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "Error:::" + error.toString());
            }

        });
        requestQueue.add(jsonObjectRequest);

        try {
            Thread.sleep(3000);
            nAdaptor=new NewsAdaptor(getApplicationContext(),R.layout.list_item,frNewsList);
            ListView nListview = findViewById(R.id.newsList);
            nListview.setAdapter(nAdaptor);

            Log.d("myapp","Clicking");
            nListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(i>=0&&i<20){
                        Log.d("myapp","Item Clicked");

                        Intent detailIntent=new Intent(view.getContext(), NewsDetail.class);
                        Log.d("myapp","News Details"+newsContent.get(i));
                        detailIntent.putExtra("details",newsContent.get(i));
                        startActivity(detailIntent);
                    }
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}