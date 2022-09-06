package com.example.busipal

import android.app.*
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar.getInstance
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.busipal.databinding.ActivityCalenderNewBinding
import kotlinx.android.synthetic.main.activity_calender_new.*
import java.security.Policy.getInstance
import java.util.*
import java.util.Calendar.getInstance
import java.util.Currency.getInstance


class CalenderNew : AppCompatActivity() {

    private lateinit var binding : ActivityCalenderNewBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalenderNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        binding.addcalenderbtn.setOnClickListener{ scheduleNotification() }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun scheduleNotification() {
        var intent = Intent(applicationContext, Notification::class.java)
        var tittle = binding.etTittle.text.toString()
        val message = binding.etKeterangan.text.toString()
        intent.putExtra(tittleExtra, tittle)
        intent.putExtra(messageExtra, message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )
        showAlert(time, tittle, message)

    }

    private fun showAlert(time: Long, tittle: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)

        AlertDialog.Builder(this)
            .setTitle("Notification Schedeuled")
            .setMessage(
                "Tittle :" + tittle +
                        "\nMessage :" + message +
                        "\nAt :" +dateFormat.format(date)+ " " + timeFormat.format(date))
            .setPositiveButton("Okay"){_,_->}
            .show()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getTime(): Long {
        val minute = binding.timePicker.minute
        val hour = binding.timePicker.hour
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calender = Calendar.getInstance()
        calender.set(year, month, day, hour, minute)
        return calender.timeInMillis
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val name = "Notif Channel"
        val desc = "A Description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = desc
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    fun CreateCalender(view: View) {
        startActivity(Intent(this,Calender::class.java))
        overridePendingTransition(0,0)
    }

    fun btnBack(view: View) {
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }
}