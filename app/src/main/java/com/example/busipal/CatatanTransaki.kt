package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CatatanTransaki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan_transaki)

        val pilihTanggal: Button = findViewById(R.id.tvPilihTanggal)
        val all: Button = findViewById(R.id.tvAll)
        val month: Button = findViewById(R.id.tvMonth)
        val week: Button = findViewById(R.id.tvWeek)
        val day: Button = findViewById(R.id.tvDay)

        pilihTanggal.setOnClickListener { pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        all.setOnClickListener { all.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        month.setOnClickListener { month.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        week.setOnClickListener { week.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        day.setOnClickListener { day.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))}



    }

    fun btnBack(view: View){

        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)

    }

    fun btnCreate(view: View){
        startActivity(Intent(this,CatatanTransaksiNew::class.java))
        overridePendingTransition(0,0)
    }
}