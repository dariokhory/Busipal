package com.example.myresolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tmp = DataTransaction(this)
        var result = ""
        for (str in tmp.viewAllName()){
            result += str + System.getProperty("line.separator")
        }

        textName.text = result

    }
}