package com.andravitestes.appcardapioonline.view_holder

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andravitestes.appcardapioonline.R

abstract class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    abstract val name: TextView
    abstract val price: TextView
    abstract val checkbox: CheckBox
    open val description: TextView? = null
    open val waitWite: TextView? = null
    open val image: ImageView? = null


    // Inserir depois
    // val image = itemView.findViewById<ImageView>(R.id.image_appetize)
    // val description = itemView.findViewById<TextView>(R.id.image_appetize)
    // val waitTime = itemView.findViewById<TextView>(R.id.image_appetize)

}