package com.andravitestes.appcardapioonline.view_holder

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.andravitestes.appcardapioonline.R

class DrinkHolder(itemView: View) : PlateViewHolder(itemView){

    override val name: CheckBox = itemView.findViewById(R.id.checkbox_drink)
    override val price: TextView = itemView.findViewById(R.id.text_drink_price)
    override val checkbox: CheckBox = itemView.findViewById(R.id.checkbox_drink)
    override val description: TextView = itemView.findViewById(R.id.text_drink_description)
    override val image: ImageView? = itemView.findViewById(R.id.image_drink)

}