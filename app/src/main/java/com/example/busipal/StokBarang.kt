package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StokBarang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stok_barang)
    }

    fun btnBackStokBarang(view: View){
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }

    fun btnCreate(view: View){
        startActivity(Intent(this,StokBarangNew::class.java))
        overridePendingTransition(0,0)
    }

    fun btnStokMenipis(view: View) {
        startActivity(Intent(this,StokBarangMenipis::class.java))
        overridePendingTransition(0,0)
    }

    fun btnStokBarangData(view: View) {
        startActivity(Intent(this,StokBarangData::class.java))
        overridePendingTransition(0,0)
    }

}