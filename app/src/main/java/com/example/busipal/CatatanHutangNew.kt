package com.example.busipal

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import com.example.pertemuan8.SharePrefHelper
import database.dataCatatanHutangDB
import kotlinx.android.synthetic.main.activity_catatan_hutang_new.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import org.w3c.dom.NameList
import java.util.ArrayList

class CatatanHutangNew : AppCompatActivity(), View.OnClickListener {

    var mysqlitedb : databaseHelper? = null
    var myFirstRun: FirstRunSharePref? = null

    private val PrefFileName = "MYFILEPREF01"

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan_hutang_new)

        myFirstRun = FirstRunSharePref(this)
        DataTransaction(this).deleteAll()
        if(myFirstRun!!.firstRun){
            val secondIntent = Intent(this, Preload::class.java)
            startActivity(secondIntent)
        }
        updateAdapter()

        tvClearData.setOnClickListener(this)
        tvrefresh.setOnClickListener(this)
        btnSimpanTransaksi.setOnClickListener(this)

        val btnDiberi = findViewById<Button>(R.id.btnDiberi)
        val btnDiterima = findViewById<Button>(R.id.btnDiterima)

        mysqlitedb = databaseHelper(this)

        btnDiberi.setOnClickListener{
            btnDiberi.setBackground(this.getDrawable(R.drawable.btn_metode_active))
            btnDiterima.setBackground(this.getDrawable(R.drawable.btn_metode))
        }

        btnDiterima.setOnClickListener{
            btnDiterima.setBackground(this.getDrawable(R.drawable.btn_metode_active))
            btnDiberi.setBackground(this.getDrawable(R.drawable.btn_metode))
        }

    }

    override fun onResume() {
        super.onResume()
        updateAdapter()
    }

    override fun onClick(p0: View?) {
        var mySharedHelper = SharePrefHelper(this,PrefFileName)
        when(p0?.id){
            R.id.btnSimpanTransaksi -> {


                val dataTemp : dataCatatanHutang = dataCatatanHutang()
                dataTemp.nama = etContactPerson.text.toString()
                dataTemp.nominalUang = etNilai.text.toString()
                dataTemp.tanggal = etTanggal.text.toString()
                dataTemp.keterangan = etKeterangan.text.toString()

                var result = mysqlitedb?.addData(dataTemp)
                if(result != -1L){
                    mySharedHelper.nama = etContactPerson.text.toString()
                    Toast.makeText(this,"Simpan berhasil", Toast.LENGTH_SHORT).show()
                    clearEditText()
                }else{
                    Toast.makeText(this,"error", Toast.LENGTH_SHORT).show()
                    clearEditText()
                }
                updateAdapter()



            }
            R.id.tvClearData -> {
                mySharedHelper.clearValues()
                clearEditText()
            }
            R.id.tvrefresh -> {
                etContactPerson.setText(mySharedHelper.nama)
            }
        }
        val activity = Intent(this,CatatanHutang::class.java)
        val tvNama: String = etContactPerson.text.toString()
        val tvTanggal: String = etTanggal.text.toString()
        val tvKeterangan: String = etKeterangan.text.toString()
        val tvNilai: String = etNilai.text.toString()
        activity.putExtra(EXTRA_NAMA,tvNama)
        activity.putExtra(EXTRA_TANGGAL,tvTanggal)
        activity.putExtra(EXTRA_NILAI,tvNilai)
        activity.putExtra(EXTRA_KETERANGAN,tvKeterangan)
        startActivity(activity)
    }

    private fun updateAdapter() {
        doAsync {
            var nameList = DataTransaction(this@CatatanHutangNew)
                .viewAllName().toTypedArray()
            uiThread {
                if (spinner1 != null && nameList.size != 0) {
                    val arrayAdapter = ArrayAdapter(applicationContext,
                        android.R.layout.simple_spinner_item, nameList)
                    spinner1.adapter = arrayAdapter
                }
            }

        }
    }


    private fun clearEditText(){
        etContactPerson.text.clear()
    }




    fun btnBack(view: View){
        startActivity(Intent(this,CatatanHutang::class.java))
        overridePendingTransition(0,0)
    }

    fun contact(view: View) {
        startActivity(Intent(this,Contact::class.java))
    }


}