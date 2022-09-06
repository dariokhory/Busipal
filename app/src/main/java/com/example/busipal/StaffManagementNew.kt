package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class StaffManagementNew : AppCompatActivity() {

    val per = arrayOf("Year","Month","Week","Day")
    val bagian = arrayOf("Akuntansi","Logistik","Manager","Office Boy/Girl")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_management_new)
        val spPer = findViewById<Spinner>(R.id.spPer)
        val perAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,per)
        spPer.adapter = perAdapter
        spPer.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        val spBagian = findViewById<Spinner>(R.id.spBagian)
        val bagianAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,bagian)
        spBagian.adapter = bagianAdapter
        spBagian.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }



    }

    fun CreateStaff(view:View) {
        startActivity(Intent(this, StaffManagement::class.java))
        overridePendingTransition(0, 0)
    }


    fun btnBack(view:View){
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }
}