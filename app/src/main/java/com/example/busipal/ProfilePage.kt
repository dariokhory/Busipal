package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val navbot = findViewById<BottomNavigationView>(R.id.navbot)

        navbot.setSelectedItemId(R.id.btnProfile)

        navbot.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.btnHome -> {
                    startActivity(Intent(this,HomeScreen::class.java))
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
    fun btnSimulasiPajak(view: View) {
        startActivity(Intent(this,SimulasiPajak::class.java))
        overridePendingTransition(0,0)
    }
    fun btnUnduhLaporan(view: View) {
        startActivity(Intent(this,UnduhLaporan::class.java))
        overridePendingTransition(0,0)
    }
    fun btnKartuNama(view: View) {
        startActivity(Intent(this,KartuNama::class.java))
        overridePendingTransition(0,0)
    }

    fun btnAnalisaKeuangan(view: View) {
        startActivity(Intent(this,AnalisisKeuangan::class.java))
        overridePendingTransition(0,0)}

    fun btnExit(view: View){

        startActivity(Intent(this,MainActivity::class.java))
        overridePendingTransition(0,0)
    }

    fun btnBagikan(view: View){
        startActivity(Intent(this,ServiceActivity::class.java))
        overridePendingTransition(0,0)
    }




}