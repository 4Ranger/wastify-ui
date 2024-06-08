package com.capstone.wastify.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sampah(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable