package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class AnalisisKeuangan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analisis_keuangan)

        btnFilter()
        btnFilterGraph()



    }

    private fun btnFilterGraph() {
        val penjualan: Button = findViewById(R.id.tvPenjualan)
        val pengeluaran: Button = findViewById(R.id.tvPengeluaran)
        val profit: Button = findViewById(R.id.tvProfitFilter)

        penjualan.setOnClickListener { penjualan.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            pengeluaran.setBackground(this.getDrawable(R.drawable.btn_filter))
            profit.setBackground(this.getDrawable(R.drawable.btn_filter))}
        pengeluaran.setOnClickListener { pengeluaran.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            penjualan.setBackground(this.getDrawable(R.drawable.btn_filter))
            profit.setBackground(this.getDrawable(R.drawable.btn_filter)) }
        profit.setOnClickListener { profit.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            penjualan.setBackground(this.getDrawable(R.drawable.btn_filter))
            pengeluaran.setBackground(this.getDrawable(R.drawable.btn_filter))}
    }

    private fun btnFilter() {
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

    fun btnBackProfile(view: View) {
        startActivity(Intent(this, Navbar::class.java))
        overridePendingTransition(0,0)
    }



}
