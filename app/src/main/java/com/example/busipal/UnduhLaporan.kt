package com.example.busipal

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_unduh_laporan.*

private var sp: SoundPool? = null
private var sound = 0

class UnduhLaporan : AppCompatActivity() {

        private val CHANNEL_ID = "Notifikasi_exp1"
        private val notificationId = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unduh_laporan)

        createDownloadNotification()

        llLaporanLabaRugi.setOnClickListener{
            threadLabaRugi()
        }

        val btnPdf = findViewById<TextView>(R.id.btnPdf)
        val btnWord = findViewById<TextView>(R.id.btnWord)

        btnPdf.setOnClickListener {
            btnPdf.setBackground(this.getDrawable(R.drawable.btn_metode_active))
            btnWord.setBackground(this.getDrawable(R.drawable.btn_metode))
        }

        btnWord.setOnClickListener {
            btnPdf.setBackground(this.getDrawable(R.drawable.btn_metode))
            btnWord.setBackground(this.getDrawable(R.drawable.btn_metode_active))
        }

    }

    private fun threadLabaRugi() {
            Thread(Runnable {
                for(i in 1..10){
                    val pros: String = i.toString() + "0 %"
                    Thread.sleep(1000)
                    tvLabaRugi.post {
                        tvLabaRugi.setText(pros)
                    }
                    if(i == 10){
                        playSP()
                        sendNotification()
                        tvLabaRugi.post {
                            tvLabaRugi.setText("Laporan Laba Rugi")
                        }
                        break
                    }
                }
            }).start()
    }

    private fun createDownloadNotification(){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val name = "Laporan Laba Rugi"
                val descriptionText = "Download telah selesai"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(CHANNEL_ID,name,importance).apply{
                    description = descriptionText
                }
                val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
        }

    private fun sendNotification(){
            val intent = Intent(this, MainActivity::class.java).apply{
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this,0,intent, 0)

            val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.unduh)
//            val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.unduh)


            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.unduh)
                .setContentTitle("Laporan Laba Rugi")
                .setContentText("Unduhan telah selesai")
//                .setLargeIcon(bitmapLargeIcon)
//                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(this)){this
                notify(notificationId,builder.build())
            }
        }

    private fun playSP(){
        if(sound != 0){
            sp?.play(sound,1.00f,1.00f,1,0,1.00f)
        }
    }

    override fun onStart() {
        super.onStart()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            sp = SoundPool.Builder().setMaxStreams(32).build()

        }else{
            sp = SoundPool(32,AudioManager.STREAM_MUSIC,0)
        }
        sound = sp?.load(this,R.raw.success,1) ?: 0
    }

    override fun onStop() {
        super.onStop()
        sp?.release()
        sp = null
    }

    fun btnBack(view: View){
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }
}