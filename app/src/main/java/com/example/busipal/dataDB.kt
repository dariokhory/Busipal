package com.example.busipal

import android.provider.BaseColumns

class dataDB {
    class dataTable : BaseColumns{
        companion object{
            val TABLE_DATA = "data"
            val COLUMN_ID: String = "_id"
            val COLUMN_NAME: String = "nama"
            val COLUMN_NOMINAL: String = "nominal"
            val COLUMN_TANGGAL: String = "tanggal"
            val COLUMN_KETERANGAN: String = "keterangan"

        }
    }
}