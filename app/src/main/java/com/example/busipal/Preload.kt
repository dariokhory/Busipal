package com.example.busipal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_preload.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Preload : AppCompatActivity() {

    private var mhs = listOf(Data("A1","","",""),Data("A2","","",""),Data("A3","","","")
        ,Data("A4","","",""),Data("A5","","",""),Data("A6","","","")
        ,Data("A7","","",""),Data("A8","","",""),Data("A9","","","")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preload)

        btn_yes.setOnClickListener {executeLoadData()}
        btn_no.setOnClickListener {finishActivity()}


    }

    private fun finishActivity() {
        var myFirstRunSharePref = FirstRunSharePref(this)
        myFirstRunSharePref.firstRun = false
        this.finish()

    }

    private fun executeLoadData() {
        btn_no.isEnabled = false
        btn_yes.isEnabled = false
        myProgress.progress=0
        var database = DataTransaction(this)
        doAsync {
            for (userData in mhs) {
                database.addUser(userData)
                uiThread {
                    myProgress.progress += myProgress.max/mhs.size
                    Log.w("Progress","${myProgress.progress}")
                }
            }
            uiThread {
                finishActivity()
            }
        }
    }

}