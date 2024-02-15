package com.andravitestes.appcardapioonline

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andravitestes.appcardapioonline.adapter.AdapterPlate
import com.andravitestes.appcardapioonline.model.Plate

class PlateRecycleView(
    context: Context,
    recyclerView: RecyclerView,
    plateList: MutableList<Plate>,
    spacerBetween: Int,
    columnNumber: Int = 2,
    onCheckboxChanged: (number: Float) -> Unit
) {

    init {
        recyclerView.layoutManager =
            CustomGridLayoutManager(context, columnNumber, GridLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(RecycleViewSpacer(spacerBetween))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = AdapterPlate(context, plateList, onCheckboxChanged)
    }

}