package com.ntabenkin.binn

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Binn (
    val id: Int,
    val location: String,
    //val Route: Route,



): Parcelable
