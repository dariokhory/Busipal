package com.example.busipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CatatanTransaksiNew : AppCompatActivity() {

    val kategoriPengeluaran = arrayOf("Transportasi","Makanan","Dan Lainnya")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan_transaksi_new)

        val btnPenjualan = findViewById<TextView>(R.id.btnPenjualan)
        val btnPengeluaran = findViewById<TextView>(R.id.btnPengeluaran)
        val btnModeKasir = findViewById<TextView>(R.id.btnModeKasir)

        btnPenjualan.setOnClickListener {
            val llPenjualan = findViewById<LinearLayout>(R.id.llPenjualan)
            val llPengeluaran = findViewById<LinearLayout>(R.id.llPengeluaran)
            val llIOPenjualan = findViewById<LinearLayout>(R.id.llIOPenjualan)
            val llIOPengeluaran = findViewById<LinearLayout>(R.id.llIOPengeluaran)
            val etKeterangan = findViewById<EditText>(R.id.etKeterangan)
            val llSwitchLunas = findViewById<LinearLayout>(R.id.llSwitchLunas)
            val llSearchBar = findViewById<LinearLayout>(R.id.llSearchBar)
            val llModeKasirItem = findViewById<LinearLayout>(R.id.llModeKasirItem)
            val btnSimpanTransaksi = findViewById<Button>(R.id.btnSimpanTransaksi)

            btnPenjualan.setBackground(this.getDrawable(R.drawable.btn_metode_active))
            btnPengeluaran.setBackground(this.getDrawable(R.drawable.btn_metode))
            btnModeKasir.setBackground(this.getDrawable(R.drawable.btn_metode))


            llPenjualan.setVisibility(View.VISIBLE)
            llPengeluaran.setVisibility(View.GONE)
            llIOPenjualan.setVisibility(View.VISIBLE)
            llIOPengeluaran.setVisibility(View.GONE)
            etKeterangan.setVisibility(View.VISIBLE)
            llSwitchLunas.setVisibility(View.VISIBLE)
            llSearchBar.setVisibility(View.GONE)
            llModeKasirItem.setVisibility(View.GONE)
            btnSimpanTransaksi.setVisibility(View.VISIBLE)

        }
        btnPengeluaran.setOnClickListener {
            val llPenjualan = findViewById<LinearLayout>(R.id.llPenjualan)
            val llPengeluaran = findViewById<LinearLayout>(R.id.llPengeluaran)
            val llIOPenjualan = findViewById<LinearLayout>(R.id.llIOPenjualan)
            val llIOPengeluaran = findViewById<LinearLayout>(R.id.llIOPengeluaran)
            val etKeterangan = findViewById<EditText>(R.id.etKeterangan)
            val llSwitchLunas = findViewById<LinearLayout>(R.id.llSwitchLunas)
            val llSearchBar = findViewById<LinearLayout>(R.id.llSearchBar)
            val llModeKasirItem = findViewById<LinearLayout>(R.id.llModeKasirItem)
            val btnSimpanTransaksi = findViewById<Button>(R.id.btnSimpanTransaksi)

            btnPenjualan.setBackground(this.getDrawable(R.drawable.btn_metode))
            btnPengeluaran.setBackground(this.getDrawable(R.drawable.btn_metode_active))
            btnModeKasir.setBackground(this.getDrawable(R.drawable.btn_metode))


            llPenjualan.setVisibility(View.GONE)
            llPengeluaran.setVisibility(View.VISIBLE)
            llIOPenjualan.setVisibility(View.GONE)
            llIOPengeluaran.setVisibility(View.VISIBLE)
            etKeterangan.setVisibility(View.VISIBLE)
            llSwitchLunas.setVisibility(View.VISIBLE)
            llSearchBar.setVisibility(View.GONE)
            llModeKasirItem.setVisibility(View.GONE)
            btnSimpanTransaksi.setVisibility(View.VISIBLE)

        }
        btnModeKasir.setOnClickListener {
            val llPenjualan = findViewById<LinearLayout>(R.id.llPenjualan)
            val llPengeluaran = findViewById<LinearLayout>(R.id.llPengeluaran)
            val llIOPenjualan = findViewById<LinearLayout>(R.id.llIOPenjualan)
            val llIOPengeluaran = findViewById<LinearLayout>(R.id.llIOPengeluaran)
            val etKeterangan = findViewById<EditText>(R.id.etKeterangan)
            val llSwitchLunas = findViewById<LinearLayout>(R.id.llSwitchLunas)
            val llSearchBar = findViewById<LinearLayout>(R.id.llSearchBar)
            val llModeKasirItem = findViewById<LinearLayout>(R.id.llModeKasirItem)
            val btnSimpanTransaksi = findViewById<Button>(R.id.btnSimpanTransaksi)

            btnModeKasir.setBackground(this.getDrawable(R.drawable.btn_metode_active))
            btnPenjualan.setBackground(this.getDrawable(R.drawable.btn_metode))
            btnPengeluaran.setBackground(this.getDrawable(R.drawable.btn_metode))


            llPenjualan.setVisibility(View.GONE)
            llPengeluaran.setVisibility(View.GONE)
            llIOPenjualan.setVisibility(View.GONE)
            llIOPengeluaran.setVisibility(View.GONE)
            etKeterangan.setVisibility(View.GONE)
            llSwitchLunas.setVisibility(View.GONE)
            llSearchBar.setVisibility(View.VISIBLE)
            llModeKasirItem.setVisibility(View.VISIBLE)
            btnSimpanTransaksi.setVisibility(View.GONE)
        }

        val btnLunas = findViewById<TextView>(R.id.btnLunas)
        val btnBelumLunas = findViewById<TextView>(R.id.btnBelumLunas)

        btnLunas.setOnClickListener {
            btnLunas.setBackground(this.getDrawable(R.drawable.btn_metode_active))
            btnBelumLunas.setBackground(this.getDrawable(R.drawable.btn_metode))
        }

        btnBelumLunas.setOnClickListener {
            btnLunas.setBackground(this.getDrawable(R.drawable.btn_metode))
            btnBelumLunas.setBackground(this.getDrawable(R.drawable.btn_metode_active))
        }

        val spKategori = findViewById<Spinner>(R.id.spKategori)
        val kategoriAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,kategoriPengeluaran)
        spKategori.adapter = kategoriAdapter
        spKategori.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    fun CreateTransaksi(view: View){
        startActivity(Intent(this,CatatanTransaki::class.java))
    }

    fun btnBack(view: View) {
        startActivity(Intent(this,CatatanTransaki::class.java))
    }
}