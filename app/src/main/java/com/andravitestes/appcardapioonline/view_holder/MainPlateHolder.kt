package com.andravitestes.appcardapioonline.view_holder

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.andravitestes.appcardapioonline.R

class MainPlateHolder(itemView: View) : PlateViewHolder(itemView) {

    override val name: TextView = itemView.findViewById(R.id.text_main_plate)
    override val price: TextView = itemView.findViewById(R.id.text_main_plate_price)
    override val checkbox: CheckBox = itemView.findViewById(R.id.checkbox_main_plate)
    override val description: TextView = itemView.findViewById(R.id.text_main_plate_description)
    override val image: ImageView? = itemView.findViewById(R.id.image_main_plate)
    override val waitWite: TextView = itemView.findViewById(R.id.text_main_plate_wait_time)
}