package com.andravitestes.appcardapioonline;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;


public class CustomGridLayoutManager extends GridLayoutManager {
    private boolean isScrollEnabled = false;

    public CustomGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}
