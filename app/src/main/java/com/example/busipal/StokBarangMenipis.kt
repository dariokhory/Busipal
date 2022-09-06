package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StokBarangMenipis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stok_barang_menipis)
    }

    fun btnBackStokBarang(view: View){
        startActivity(Intent(this,StokBarang::class.java))
        overridePendingTransition(0,0)
    }
}