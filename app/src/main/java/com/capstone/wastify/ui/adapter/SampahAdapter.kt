package com.capstone.wastify.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.wastify.R
import com.capstone.wastify.data.Sampah

class SampahAdapter(private val listSampah: ArrayList<Sampah>) : RecyclerView.Adapter<SampahAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_sampah)
        val tvName: TextView = itemView.findViewById(R.id.tv_sampah)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_deskripsi_sampah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_database, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int  = listSampah.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name, description, photo) = listSampah[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
    }
}