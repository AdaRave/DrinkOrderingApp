package com.example.drinkorderingapp.data

import androidx.annotation.DrawableRes
import com.example.drinkorderingapp.R

data class DescriptionProductState(
    @DrawableRes val imgRes: Int,
    val name: String,
    val description: String,
    val stars: Int
)

val DescriptionProductData = DescriptionProductState(
    imgRes = R.drawable.big_mocha,
    name = "Mocha",
    description = "Espresso with chocolate and steamed milk, often topped with whipped \n" +
            "cream.",
    stars = 4
)