package com.example.busipal

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import database.dataCatatanHutangDB
import java.util.ArrayList

class databaseHelper (context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_DATA_CATATAN_HUTANG_TABLE = ("CREATE TABLE " +
                "${dataCatatanHutangDB.dataCatatanHutangTable.TABLE_DATA_CATATAN_HUTANG} (" +
                "${dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_ID} INTERGER PRIMARY KEY," +
                "${dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_NAME} TEXT," +
                "${dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_NOMINAL} TEXT," +
                "${dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_TANGGAL} TEXT," +
                "${dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_KETERANGAN} TEXT" + ")")
        db?.execSQL(CREATE_DATA_CATATAN_HUTANG_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, old: Int, new: Int) {
        db?.execSQL("DROP TABLE IF EXIXTS " +
        "${dataCatatanHutangDB.dataCatatanHutangTable.TABLE_DATA_CATATAN_HUTANG}")
        onCreate(db)
    }

    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "mysqlitedbex.db"
    }

    fun addData(dataCatatanHutang: dataCatatanHutang): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_NAME, dataCatatanHutang.nama)
        contentValues.put(dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_NOMINAL, dataCatatanHutang.nominalUang)
        contentValues.put(dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_TANGGAL, dataCatatanHutang.tanggal)
        contentValues.put(dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_KETERANGAN, dataCatatanHutang.keterangan)

        val success = db.insert(dataCatatanHutangDB.dataCatatanHutangTable.TABLE_DATA_CATATAN_HUTANG,null,contentValues)
        db.close()

        return success
    }

    @SuppressLint("Range")
    fun viewDataCatatanHutang(): List<String>{
        val nameList = ArrayList<String>()
        val SELECT_NAME = "SELECT ${dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_NAME}" + "FROM ${dataCatatanHutangDB.dataCatatanHutangTable.TABLE_DATA_CATATAN_HUTANG}"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(SELECT_NAME,null)
        }catch (e:SQLException){
            return ArrayList()
        }

        var dataNama: String = ""
        if(cursor.moveToFirst()){
            do{
                dataNama = cursor.getString(
                    cursor.getColumnIndex(dataCatatanHutangDB.dataCatatanHutangTable.COLUMN_NAME)
                )
                nameList.add(dataNama)
            }while (cursor.moveToNext())
        }

        return nameList

    }
}