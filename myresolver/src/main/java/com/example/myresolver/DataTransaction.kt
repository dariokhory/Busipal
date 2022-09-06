package com.example.myresolver

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import com.example.myresolver.dataDB.dataTable.Companion.COLUMN_ID
import com.example.myresolver.dataDB.dataTable.Companion.COLUMN_KETERANGAN
import com.example.myresolver.dataDB.dataTable.Companion.COLUMN_NAME
import com.example.myresolver.dataDB.dataTable.Companion.COLUMN_NOMINAL
import com.example.myresolver.dataDB.dataTable.Companion.COLUMN_TANGGAL

class DataTransaction(context: Context)  {

    private val myContentResolver : ContentResolver
    init {
        myContentResolver = context.contentResolver
    }
    @SuppressLint("Range")
    fun viewAllName() : List<String>{
        val nameList : ArrayList<String> = ArrayList()
        val mProjection: Array<String> = arrayOf(
            COLUMN_NAME, COLUMN_NOMINAL, COLUMN_TANGGAL, COLUMN_KETERANGAN, COLUMN_ID
        )
        var cursor1 : Cursor? = null
        cursor1 = myContentResolver.query(
            myContentProviderURI.CONTENT_URI,
            mProjection,null, null,null)
        if(cursor1!=null) {
            var userName: String
            if (cursor1.moveToFirst()) {
                do {
                    userName = cursor1.getString(cursor1
                        .getColumnIndex(COLUMN_NAME))
                    nameList.add(userName)
                } while (cursor1.moveToNext())
            }
        }
        return nameList
    }

}