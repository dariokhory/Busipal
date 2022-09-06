package com.example.busipal

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_contact.*

class Contact : AppCompatActivity() ,
    LoaderManager.LoaderCallbacks<Cursor> {

    var DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME
    var NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER
    var myList : MutableList<myContact> = ArrayList()

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        var myContent = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        var myProj = arrayOf(DISPLAY_NAME,NUMBER)
        return CursorLoader(this, myContent, myProj,null,null, DISPLAY_NAME + " ASC")
    }

    @SuppressLint("Range")
    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        myList.clear()
        if (data != null){
            data.moveToFirst()
                while (!data.isAfterLast){
                    myList.add(myContact(
                            nama = data.getString(data
                                .getColumnIndex(DISPLAY_NAME)),
                            nomor = data.getString(data
                                .getColumnIndex(NUMBER))))
                data.moveToNext()
            }
        }

        val contactAdapter = myAdapterRecyView(myList)
        myRecyView.apply {
            layoutManager = LinearLayoutManager(this@Contact)
            adapter = contactAdapter
        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        val contactAdapter = myAdapterRecyView(myList)
        myRecyView.apply {
            layoutManager = LinearLayoutManager(this@Contact)
            adapter = contactAdapter
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        LoaderManager.getInstance(this).initLoader(1,null,this)

        val contactAdapter = myAdapterRecyView(myList)
        myRecyView.apply {
            layoutManager = LinearLayoutManager(this@Contact)
            adapter = contactAdapter
        }


    }

    fun btnBack(view: View) {
        startActivity(Intent(this,CatatanHutangNew::class.java))
    }
}