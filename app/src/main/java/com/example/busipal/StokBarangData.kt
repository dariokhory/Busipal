package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StokBarangData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stok_barang_data)
    }

    fun btnBack(view: View){
        startActivity(Intent(this,StokBarang::class.java))
    }
}