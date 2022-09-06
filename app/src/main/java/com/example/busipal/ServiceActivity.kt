package com.example.busipal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        var myService = Intent(this, SendMyService::class.java)
        startMyService.setOnClickListener {
            startService(myService)
        }
        stopMyService.setOnClickListener {
            stopService(myService)
        }
    }
}