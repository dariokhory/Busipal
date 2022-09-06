package com.example.busipal

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import java.lang.Exception

class SendMyService : Service() {

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this,"Service Dimulai",Toast.LENGTH_SHORT).show()
        Thread(Runnable {
            for(i in 0..10)
                try {
                    Thread.sleep(500L)
                }
                catch (e:Exception){

                }
            stopSelf()
        }).start()
        return START_STICKY
    }

    override fun onDestroy() {
        Toast.makeText(this, "Service Selesai", Toast.LENGTH_SHORT).show()
    }
}