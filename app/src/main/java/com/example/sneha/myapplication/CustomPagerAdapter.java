package com.example.sneha.myapplication;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.sneha.myapplication.curlPaheLib.PageCurlFrameLayout;

import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    ButtonClickActionInterface buttonClickActionInterface;

    ArrayList<Model> arr;


    public CustomPagerAdapter(Context context, ArrayList<Model> arr, ButtonClickActionInterface buttonClickActionInterface) {
        mContext = context;
        this.arr = arr;
        this.buttonClickActionInterface = buttonClickActionInterface;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((PageCurlFrameLayout) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.view_pager_item, container, false);

        final boolean isOpen = false;

        final ScrollView scrollView = (ScrollView) itemView.findViewById(R.id.scrollview);
        ImageView img = (ImageView) itemView.findViewById(R.id.imageView);
        ImageView btnNext = (ImageView) itemView.findViewById(R.id.btnNext);
       // ImageView btnOpenClose = (ImageView) itemView.findViewById(R.id.btnOpenClose);

        if (arr.get(position).isTextShow()) {
            scrollView.setVisibility(View.VISIBLE);
        } else {
            scrollView.setVisibility(View.GONE);
        }

        img.setImageResource(arr.get(position).getImg());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickActionInterface.nextButtonClick(position);
            }
        });

        /*btnOpenClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arr.get(position).isTextShow()) {
                    if (isOpen) {
                        scrollView.setVisibility(View.GONE);
                    } else {
                        scrollView.setVisibility(View.VISIBLE);
                    }
                }

            }
        });*/


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((PageCurlFrameLayout) object);
    }


}