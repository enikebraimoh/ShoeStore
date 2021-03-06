package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(val name: String = "",
                var size: String,
                var company: String,
                var description: String,
                val images: List<String> = mutableListOf()) : Parcelable