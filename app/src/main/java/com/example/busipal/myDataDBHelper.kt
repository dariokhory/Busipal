package com.example.busipal

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.busipal.provider.myContentProvider

class myDataDBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME,
        null,
        DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USER_TABLE = ("CREATE TABLE " +
                "${dataDB.dataTable.TABLE_DATA}" + "(" +
                "${dataDB.dataTable.COLUMN_ID}" + " INTEGER PRIMARY KEY," +
                "${dataDB.dataTable.COLUMN_NAME}" + " TEXT," +
                "${dataDB.dataTable.COLUMN_NOMINAL}" + " TEXT," +
                "${dataDB.dataTable.COLUMN_TANGGAL}" + " TEXT," +
                "${dataDB.dataTable.COLUMN_KETERANGAN}" + " TEXT" + ")")
        db?.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " +
                "${dataDB.dataTable.TABLE_DATA}")
        onCreate(db)
    }
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "mypreloadcontent.db"
    }
}