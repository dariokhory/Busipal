package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class StaffManagement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_management)

        val navbot = findViewById<BottomNavigationView>(R.id.navbot)

        navbot.setSelectedItemId(R.id.btnStaffManagement)

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
                R.id.btnProfile -> {
                    startActivity(Intent(this,ProfilePage::class.java))
                    overridePendingTransition(0,0)
                }

            }
            true
        }
    }

    fun btnBackStaffManagement(view: View){
        startActivity(Intent(this, HomeScreen::class.java))
        overridePendingTransition(0,0)
    }

    fun btnCreate(view: View){
        startActivity(Intent(this, StaffManagementNew::class.java))
        overridePendingTransition(0,0)
    }


    fun btnStaffList(view: View){
        startActivity(Intent(this, StaffManagementList::class.java))
        overridePendingTransition(0,0)
    }
}