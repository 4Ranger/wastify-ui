package com.capstone.wastify.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.wastify.R
import com.capstone.wastify.data.Location

class LocationAdapter(private val listLocation: ArrayList<Location>) : RecyclerView.Adapter<LocationAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name_location)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description_location)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_location,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listLocation.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (location, description) = listLocation[position]
        holder.tvName.text = location
        holder.tvDescription.text = description
    }
}