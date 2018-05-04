package com.example.sneha.myapplication.curlPaheLib;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.sneha.myapplication.R;
import com.example.sneha.myapplication.curlPaheLib.PageCurl;

public class PageCurlPageTransformer implements ViewPager.PageTransformer {

    String TAG="PageCurlPageTransformer";

    @Override
    public void transformPage(View page, float position) {

        Log.d(TAG, "transformPage, position = " + position + ", page = " + page.getTag(R.id.viewpager));
        if (page instanceof PageCurl) {
            if (position > -1.0F && position < 1.0F) {
                // hold the page steady and let the views do the work
                page.setTranslationX(-position * page.getWidth());
            } else {
                page.setTranslationX(0.0F);
            }
            if (position <= 1.0F && position >= -1.0F) {
                ((PageCurl) page).setCurlFactor(position);
            }
        }
    }
}
