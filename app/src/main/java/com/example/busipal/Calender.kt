package com.example.busipal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Calender : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)


        val calender = findViewById<CalendarView>(R.id.cvCalender)
        val tanggal = findViewById<TextView>(R.id.tvTanggal)
        val event = findViewById<TextView>(R.id.tvTodayEvent)
        val month = arrayOf("Januari","Februari","Maret","April","Mei","Juni",
            "Juli","Agustus","September","Oktober","November","Desember")


        calender.setOnDateChangeListener {calender,i1,i2,i3 ->
            val bulan : String = month[i2]

            tanggal.setText("$i3 $bulan $i1")
            event.setText("$i3 $bulan $i1 Event")

        }

        val navbot = findViewById<BottomNavigationView>(R.id.navbot)

        navbot.setSelectedItemId(R.id.btnCalender)

        navbot.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.btnHome -> {
                    startActivity(Intent(this,HomeScreen::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.btnProfile -> {
                    startActivity(Intent(this,ProfilePage::class.java))
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


    fun btnBackCalender(view: View){
        startActivity(Intent(this, HomeScreen::class.java))
        overridePendingTransition(0,0)
    }

    fun btnCreate(view: View) {
        startActivity(Intent(this,CalenderNew::class.java))
        overridePendingTransition(0,0)
    }

    fun btnJatuhTempo(view: View) {
        startActivity(Intent(this, CalenderJatuhTempo::class.java))
        overridePendingTransition(0,0)
    }
}

