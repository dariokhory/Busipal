package com.example.busipal

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hutang_data.view.*

class DataHutangAdapter(
    private val DataHutangList:MutableList<DataHutang>) :
    RecyclerView.Adapter<DataHutangAdapter.DataHutangViewHolder>()
{
    class DataHutangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHutangViewHolder {
        return DataHutangViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.hutang_data,
                parent,
                false
            )
        )
    }

    fun addData(data : DataHutang){
        DataHutangList.add(data)
        notifyItemInserted(DataHutangList.size-1)
    }


    override fun onBindViewHolder(holder: DataHutangViewHolder, position: Int) {
        val curData = DataHutangList[position]
        holder.itemView.apply {
            tvNama.text = curData.nama
            tvKeterangan.text = curData.keterangan
            tvTanggal.text = curData.tanggal
            tvNilai.text = curData.nilai
        }
    }

    override fun getItemCount(): Int {
        return DataHutangList.size
    }
}