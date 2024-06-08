package com.capstone.wastify.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@kotlinx.parcelize.Parcelize
data class Location(
    val location: String,
    val description: String
) : Parcelable