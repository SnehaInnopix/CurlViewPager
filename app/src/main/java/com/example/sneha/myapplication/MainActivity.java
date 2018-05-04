package com.example.sneha.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageView;

import com.example.sneha.myapplication.curlPaheLib.PageCurlPageTransformer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ButtonClickActionInterface {

    ViewPager viewPager;
    ImageView btnShowHideIndicator;
    RecyclerView recyclerViewIndicator;

    CustomPagerAdapter customPagerAdapter;
    IndicatorAdapter indicatorAdapter;

    ArrayList<Model> arr = new ArrayList<>();

    boolean isIndicatorShows=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        btnShowHideIndicator = (ImageView) findViewById(R.id.btnShowHideIndicator);
        recyclerViewIndicator = (RecyclerView) findViewById(R.id.recyclerviewImageIndicator);

        arr.add(new Model(false, R.drawable.img1));
        arr.add(new Model(true, R.drawable.img2));
        arr.add(new Model(true, R.drawable.img3));
        arr.add(new Model(true, R.drawable.img4));
        arr.add(new Model(false, R.drawable.img5));
        arr.add(new Model(true, R.drawable.img6));
        arr.add(new Model(false, R.drawable.img7));

        customPagerAdapter = new CustomPagerAdapter(MainActivity.this, arr, this);
        viewPager.setAdapter(customPagerAdapter);
        viewPager.setPageTransformer(false, new PageCurlPageTransformer());
        viewPager.setCurrentItem(0);

        indicatorAdapter = new IndicatorAdapter(arr);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewIndicator.setLayoutManager(mLayoutManager);
        recyclerViewIndicator.setItemAnimator(new DefaultItemAnimator());
        recyclerViewIndicator.setAdapter(indicatorAdapter);

        btnShowHideIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIndicatorShows){
                    isIndicatorShows=false;
                    recyclerViewIndicator.setVisibility(View.GONE);
                }else{
                    isIndicatorShows=true;
                    recyclerViewIndicator.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void nextButtonClick(int pos) {
        viewPager.setCurrentItem(pos + 1);
    }
}
