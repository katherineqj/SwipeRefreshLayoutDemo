package com.example.katherine_qj.swiperefreshlayout;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView swipe_textview;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_layout);
        swipe_textview = (TextView)findViewById(R.id.swipe_textview);
        swipeRefreshLayout.setColorSchemeResources
                (android.R.color.holo_blue_bright,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        i++;
                        swipeRefreshLayout.setRefreshing(false);
                        swipe_textview.setText("刷新了"+i+"次");
                    }
                }, 5000);
            }
        });


    }


}
