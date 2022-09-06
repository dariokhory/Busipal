package com.example.busipal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_con_view.view.*

class myAdapterRecyView(private val contact: List<myContact>):RecyclerView.Adapter<myHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        return myHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_con_view,parent,false))
    }

    override fun getItemCount(): Int = contact.size

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        holder.bindContact(contact[position])
    }
}

class myHolder(view: View): RecyclerView.ViewHolder(view) {
    private val contactName = view.tvNama
    private val contactNumber = view.tvNumber

    fun bindContact(tmp: myContact){
        contactName.text = "${contactName.text}: ${tmp.nama}"
        contactNumber.text = "${contactNumber.text}: ${tmp.nomor}"
    }

}
