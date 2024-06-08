package com.capstone.wastify.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsLocal(
    val title: String,
    val publisher: String,
    val photo: Int
) : Parcelable