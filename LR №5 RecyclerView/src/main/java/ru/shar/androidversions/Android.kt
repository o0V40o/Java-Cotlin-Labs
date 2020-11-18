package ru.shar.androidversions

import androidx.annotation.DrawableRes

data class Android(
    val title: String,
    @DrawableRes val image: Int,
    @DrawableRes val poster: Int,
    val description: String,
    val released: String,
    val reference: String
)