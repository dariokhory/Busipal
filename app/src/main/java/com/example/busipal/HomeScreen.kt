package com.example.busipal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import com.example.busipal.databinding.FragmentHomeBinding
import com.example.busipal.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val pilihTanggal:Button = findViewById(R.id.tvPilihTanggal)
        val all:Button = findViewById(R.id.tvAll)
        val month:Button = findViewById(R.id.tvMonth)
        val week:Button = findViewById(R.id.tvWeek)
        val day:Button = findViewById(R.id.tvDay)

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


        val navbot = findViewById<BottomNavigationView>(R.id.navbot)

        navbot.setSelectedItemId(R.id.btnHome)

        navbot.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.btnProfile -> {
                    startActivity(Intent(this,ProfilePage::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.btnCalender -> {
                    startActivity(Intent(this,Calender::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.btnStaffManagement -> {
                    startActivity(Intent(this,StaffManagement::class.java))
                    overridePendingTransition(0,0)
                }
            }
            true
        }

    }

    fun btnCatatanHutang(view: View){
        startActivity(Intent(this,CatatanHutang::class.java))
        overridePendingTransition(0,0)
    }

    fun btnStokBarang(view: View){
        startActivity(Intent(this,StokBarang::class.java))
        overridePendingTransition(0,0)
    }
    fun btnProfile(view: View) {
        startActivity(Intent(this,ProfilePage::class.java))
        overridePendingTransition(0,0)
    }


    fun btnDetails(view: View){
        startActivity(Intent(this,AnalisisKeuangan::class.java))
        overridePendingTransition(0,0)
    }

    fun btnCatatanTransaksi(view: View){
        startActivity(Intent(this,CatatanTransaki::class.java))
        overridePendingTransition(0,0)
    }
}






