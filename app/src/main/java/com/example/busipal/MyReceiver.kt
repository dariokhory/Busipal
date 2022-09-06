package com.example.busipal

import android.app.Activity
import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.busipal.NetworkUtil.getConnectivityStatusString


class MyReceiver : BroadcastReceiver() {
    var dialog: Dialog? = null
    var nettext: TextView? = null
    override fun onReceive(context: Context, intent: Intent) {
        var status = getConnectivityStatusString(context)
        dialog = Dialog(context, android.R.style.Theme_NoTitleBar_Fullscreen)
        dialog!!.setContentView(R.layout.db_noconnection)
        val restartapp = dialog!!.findViewById<View>(R.id.restartapp) as Button
        nettext = dialog!!.findViewById<View>(R.id.nettext) as TextView
        restartapp.setOnClickListener {
            (context as Activity).finish()
            Log.d("clickedbutton", "yes")
            val i = Intent(context, MainActivity::class.java)
            context.startActivity(i)
        }
        Log.d("network", status!!)
        if (status.isEmpty() || status == "No internet is available" || status == "No Internet Connection") {
            status = "No Internet Connection"
            dialog!!.show()
        }
        Toast.makeText(context, status, Toast.LENGTH_LONG).show()
    }
}