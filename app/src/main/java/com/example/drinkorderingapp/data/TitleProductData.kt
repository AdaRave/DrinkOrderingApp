package com.example.drinkorderingapp.data

data class TitleProductState(
    val name: String,
    val type: String,
    val price: Int
)

val TitleProductData = TitleProductState(
    name = "Mocha",
    type = "Coffee",
    price = 25
)