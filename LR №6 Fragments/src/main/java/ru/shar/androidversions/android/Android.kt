package ru.shar.androidversions.android

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Android(
    val title: String,
    @DrawableRes val image: Int,
    @DrawableRes val poster: Int,
    val description: String,
    val released: String,
    val reference: String
): Parcelable