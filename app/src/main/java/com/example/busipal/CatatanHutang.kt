package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_catatan_hutang.*
import kotlinx.android.synthetic.main.activity_catatan_hutang_new.*
import java.lang.reflect.Array

const val EXTRA_NAMA= "EXTRA_NAMA"
const val  EXTRA_TANGGAL= "EXTRA_TANGGAL"
const val  EXTRA_KETERANGAN= "EXTRA_KETERANGAN"
const val  EXTRA_NILAI= "EXTRA_NILAI"
var mutList: MutableList<DataHutang> = mutableListOf()

class CatatanHutang : AppCompatActivity() {


    private lateinit var dataHutangAdapter: DataHutangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan_hutang)



        dataHutangAdapter = DataHutangAdapter(mutList)

        rvDataHutangList.adapter = dataHutangAdapter
        rvDataHutangList.layoutManager = LinearLayoutManager(this)
        var nama = intent.getStringExtra(EXTRA_NAMA).toString()
        var tanggal = intent.getStringExtra(EXTRA_TANGGAL).toString()
        var keterangan = intent.getStringExtra(EXTRA_KETERANGAN).toString()
        var nilai = intent.getStringExtra(EXTRA_NILAI).toString()


        if(nama != "null"){
            mutList.add(DataHutang(nama, tanggal, keterangan, nilai))
        }


        val pilihTanggal: Button = findViewById(R.id.tvPilihTanggal)
        val all: Button = findViewById(R.id.tvAll)
        val month: Button = findViewById(R.id.tvMonth)
        val week: Button = findViewById(R.id.tvWeek)
        val day: Button = findViewById(R.id.tvDay)

        pilihTanggal.setOnClickListener { pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        all.setOnClickListener { all.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        month.setOnClickListener { month.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        week.setOnClickListener { week.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))
            day.setBackground(this.getDrawable(R.drawable.btn_filter))}
        day.setOnClickListener { day.setBackground(this.getDrawable(R.drawable.btn_filter_active))
            all.setBackground(this.getDrawable(R.drawable.btn_filter))
            month.setBackground(this.getDrawable(R.drawable.btn_filter))
            week.setBackground(this.getDrawable(R.drawable.btn_filter))
            pilihTanggal.setBackground(this.getDrawable(R.drawable.btn_filter))}
    }


    fun btnBackCatatanHutang(view: View){
        startActivity(Intent(this,Navbar::class.java))
        overridePendingTransition(0,0)
    }

    fun btnCreate(view: View){
        val intent = Intent(this, CatatanHutangNew::class.java)
        startActivity(intent)
        overridePendingTransition(0,0)
    }

    fun btnCatatanHutangData(view: View) {
        startActivity(Intent(this,CatatanHutangData::class.java))
        overridePendingTransition(0,0)
    }


}

