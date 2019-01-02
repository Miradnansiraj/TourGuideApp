package com.example.android.tourguideapp;

import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthPageTransformer implements ViewPager.PageTransformer {
    /*
    --- This code has been referenced from
    --- https://developer.android.com/training/animation/screen-slide#depth-page
    --- The code was not copied but understood and written by myself
     */
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0f);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);

        } else if (position <= 1) { // (0,1]
            //Fade the page out.
            view.setAlpha(1 - position);

            //Counteract the default slide transition
            view.setTranslationX(pageWidth * -position);

            // Scale the page down
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else {
            // This page is way off-screen to the right.
            view.setAlpha(0f);
        }
    }
}