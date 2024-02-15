package com.andravitestes.appcardapioonline.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andravitestes.appcardapioonline.R
import com.andravitestes.appcardapioonline.model.Plate
import com.andravitestes.appcardapioonline.plate_enum.PlateEnum
import com.andravitestes.appcardapioonline.view_holder.AppertizeHolder
import com.andravitestes.appcardapioonline.view_holder.DrinkHolder
import com.andravitestes.appcardapioonline.view_holder.MainPlateHolder
import com.andravitestes.appcardapioonline.view_holder.PlateViewHolder

class AdapterPlate(
    private val context: Context,
    private val plates: MutableList<Plate>,
    val onCheckChanged: (number: Float) -> Unit
) :


    RecyclerView.Adapter<PlateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {

        when (plates[0].type) {
            PlateEnum.APPETIZER -> {
                val itemPlateList =
                    LayoutInflater.from(context).inflate(R.layout.appetize_card, parent, false)
                return AppertizeHolder(itemPlateList)
            }

            PlateEnum.MAIN_PLATE -> {
                val itemPlateList =
                    LayoutInflater.from(context).inflate(R.layout.main_plate_card, parent, false)
                return MainPlateHolder(itemPlateList)
            }

            PlateEnum.DRINKS -> {
                val itemPlateList =
                    LayoutInflater.from(context).inflate(R.layout.drink_card, parent, false)
                return DrinkHolder(itemPlateList)
            }

            else -> {
                val itemPlateList =
                    LayoutInflater.from(context).inflate(R.layout.appetize_card, parent, false)
                return AppertizeHolder(itemPlateList)
            }

        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        val plate = plates[position]
        // Onde fazer modificações dependendo do tipo de plato?

        Log.d("Degub", plate.name)
        holder.price.text = realFormat(plate.price)
        holder.name.text = plate.name
        if (plate.image != null) {
            holder.image!!.setImageResource(plate.image)

        }


        when (plates[0].type) {
            PlateEnum.MAIN_PLATE -> {
                holder.description!!.text = plate.description
                holder.waitWite!!.text = "Méd. ${plate.waitTime ?: "Não informada"}"
            }

            PlateEnum.DRINKS -> {
                holder.description!!.text = plate.description

            }
        }

        holder.checkbox.setOnClickListener {
            if (holder.checkbox.isChecked) {
                onCheckChanged(plate.price)
            } else {
                onCheckChanged(-plate.price)
            }
        }
        /*
        * holder.image.setImageResource()
        * holder.description ....
        * */
    }

    override fun getItemCount(): Int = plates.size

    private fun realFormat(value: Float): String {
        return "R$ ${String.format("%.2f", value)}".replace('.', ',')
    }

}