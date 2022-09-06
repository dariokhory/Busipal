package com.example.myresolver

import android.net.Uri
import android.provider.BaseColumns

object dataDB {
    class dataTable: BaseColumns {
        companion object {
            val TABLE_DATA = "data"
            val COLUMN_ID: String = "_id"
            val COLUMN_NAME: String = "nama"
            val COLUMN_NOMINAL: String = "nominal"
            val COLUMN_TANGGAL: String = "tanggal"
            val COLUMN_KETERANGAN: String = "keterangan"
        }
    }
}

class myContentProviderURI{
    companion object{
        val AUTHORITY = ("com.example.busipal.provider" +
                ".myContentProvider")
        val DATA_TABLE = dataDB.dataTable.TABLE_DATA
        val CONTENT_URI = Uri.parse("content://$AUTHORITY/$DATA_TABLE")

    }
}