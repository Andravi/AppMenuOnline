package com.andravitestes.appcardapioonline.view_holder

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.andravitestes.appcardapioonline.R

class AppertizeHolder(itemView: View) : PlateViewHolder(itemView){

    override val name: TextView = itemView.findViewById(R.id.text_appetizer)
    override val price: TextView = itemView.findViewById(R.id.text_appetizer_price)
    override val checkbox: CheckBox = itemView.findViewById(R.id.checkbox_appetizer)
    override val image: ImageView = itemView.findViewById(R.id.image_appetize)
}