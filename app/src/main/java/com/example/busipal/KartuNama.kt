package com.example.busipal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kartu_nama.*
import kotlinx.android.synthetic.main.activity_registration_page.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class KartuNama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kartu_nama)

        btnSimpanKartuNama.setOnClickListener{
            writeFileInternal()
        }
        btnRead.setOnClickListener{
            readFileInternal()
        }
        btnDelete.setOnClickListener{
            delFile()
        }
    }

    private fun delFile() {
        if(fileList().size!=0) {
            for (i in fileList())
                deleteFile(i)
            etNamaBisnis.setText("All File Deteled")
        }
        else
            etNamaBisnis.setText("File Empty")
    }

    private fun writeFileInternal() {
        var output = openFileOutput("${etSimpan.text}.txt", Context.MODE_PRIVATE).apply {
            write(etNamaBisnis.text.toString().toByteArray())
            close()
        }
        var myFile  = File(this.filesDir,"${etSimpan.text}.txt")
        Log.w("OK",myFile.absolutePath)
        etNamaBisnis.text.clear()
        Toast.makeText(this,"File Save", Toast.LENGTH_SHORT).show()
    }

    private fun readFileInternal() {
        etNamaBisnis.text.clear()
        try{
            var input = openFileInput("${etRead.text.toString()}.txt").apply {
                bufferedReader().useLines {
                    for(text in it.toList()){
                        etNamaBisnis.setText("${etNamaBisnis.text}\n$text")
                    }
                }
            }
        }catch (e : FileNotFoundException){
            etNamaBisnis.setText("File Not Found")
        }catch (e : IOException){
            etNamaBisnis.setText("File Can't be Read")

        }
        etRead.text.clear()
    }

/*    private fun readDir() {
        etNamaBisnis.text.clear()
        if(fileList().size!=0){
            for(i in fileList()){
                etNamaBisnis.setText("${etNamaBisnis.text}\n$i")
            }

        }
        else{
            etNamaBisnis.setText("File Empty")
        }
    }*/

    fun btnBack(view: View) {
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }
}