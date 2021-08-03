package com.ntabenkin.binn

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
//import kotlinx.parcelize.Parcelize



//User has
//email
//userName
//password
//

@Parcelize
data class User(
    val name: String,
    val hex: String,
    val value: Int
):Parcelable


