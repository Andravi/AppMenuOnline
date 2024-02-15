package com.andravitestes.appcardapioonline.model

import com.andravitestes.appcardapioonline.plate_enum.PlateEnum


data class Plate(
    val name: String,
    val price: Float,
    val image: Int? = null,
    val description: String? = null,
    val waitTime: String? = null,
    val type: Enum<PlateEnum>? = null
    )