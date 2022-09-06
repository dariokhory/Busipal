package com.example.busipal

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException

class DataTransaction(context: Context) {
    private val myDBHelper = myDataDBHelper(context)
    private val dbwirte = myDBHelper.writableDatabase
    fun viewAllName():List<String>{
        val nameList:ArrayList<String> = ArrayList<String>()
        val selectQuery = "SELECT ${dataDB.dataTable.COLUMN_NAME}" +
                " FROM ${dataDB.dataTable.TABLE_DATA}"
        val db = myDBHelper.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userName: String
        if (cursor.moveToFirst()) {
            do {
                16
                userName = cursor.getString(cursor
                    .getColumnIndex(dataDB.dataTable.COLUMN_NAME))
                nameList.add(userName)
            } while (cursor.moveToNext())
        }
        return nameList
    }
    fun addUser(data: Data):Long{
        val db = myDBHelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(dataDB.dataTable.COLUMN_NAME, data.nama)
        contentValues.put(dataDB.dataTable.COLUMN_NOMINAL, data.nominal)
        contentValues.put(dataDB.dataTable.COLUMN_TANGGAL,data.tanggal )
        contentValues.put(dataDB.dataTable.COLUMN_KETERANGAN,data.keterangan )
        val success = db.insert(dataDB.dataTable.TABLE_DATA,
            null, contentValues)
        db.close()
        return success
    }

    fun beginUserTransaction()
    {
        dbwirte.beginTransaction()
    }
    fun successUserTransaction()
    {
        dbwirte.setTransactionSuccessful()
    }
    fun endUserTransaction()
    {
        dbwirte.endTransaction()
    }
    fun addUserTransaction(data: Data):Unit{
        val sqlString = "INSERT INTO ${dataDB.dataTable.TABLE_DATA} " +
                "(${dataDB.dataTable.COLUMN_NAME}" +
                ",${dataDB.dataTable.COLUMN_NOMINAL}" +
                ",${dataDB.dataTable.COLUMN_TANGGAL}" +
                ",${dataDB.dataTable.COLUMN_KETERANGAN}) VALUES (?,?,?,?)"
        val myStatement = dbwirte.compileStatement(sqlString)
        myStatement.bindString(1,data.nama)
        myStatement.bindString(2,data.nominal)
        myStatement.bindString(3,data.tanggal)
        myStatement.bindString(4,data.keterangan)
        myStatement.execute()
        myStatement.clearBindings()
    }

    fun deleteAll():Int{
        val db = myDBHelper.writableDatabase
        val success = db.delete(dataDB.dataTable.TABLE_DATA,"",null)
        db.close()
        return success
    }
}
