package com.example.pertemuan8

import android.content.Context
import android.content.SharedPreferences

class SharePrefHelper(context: Context,name: String){
    val USER_NAME = "NAMA"

    private var myPreferences : SharedPreferences

    init {
        myPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE)
    }
    inline fun SharedPreferences.editMe(opertion:(SharedPreferences.Editor)->Unit){
        val editMe = edit()
        opertion(editMe)
        editMe.apply()
    }

    var nama : String?
        get() = myPreferences.getString(USER_NAME,"Kosong")
        set(value) {
            myPreferences.edit().putString(USER_NAME,value).apply()
        }

    fun clearValues(){
        myPreferences.edit().clear().apply()

    }
}