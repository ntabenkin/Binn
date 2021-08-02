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
    //fname + lName = fullName
    val fName:String,
    val lName:String,

    val userName:String,
    val email:String,
    val password:String,
    //should be Hex
    val id: Double,




   // val location:String,
    val binAmount: String,
   // val value: Int

):Parcelable{
    constructor() : this("first", "last","string","string","string",1.1,"string")

    fun getName(): String {
        return fName + lName
    }

    fun setName(fName: String,lName:String ) {
        this.fName.set(fName)
        this.fName.set(fName)
    }

    fun getUId(): Double {
        return id
    }

    fun setUId(id: Double) {
        this.id.set(id)
    }
}

private fun String.set(fName: String) {

}
private fun Double.set(id: Double) {

}


