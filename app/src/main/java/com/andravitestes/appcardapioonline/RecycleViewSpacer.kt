package com.andravitestes.appcardapioonline

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecycleViewSpacer(private val space:Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = 0
        } else {
            outRect.top = 0
        }
//        super.getItemOffsets(outRect, view, parent, state)
    }
}