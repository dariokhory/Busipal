package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CalenderJatuhTempo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender_jatuh_tempo)
    }

    fun btnBack(view: View) {
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }

}