package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StaffManagementList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_management_list)
    }

    fun btnBack(view: View){
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }
}