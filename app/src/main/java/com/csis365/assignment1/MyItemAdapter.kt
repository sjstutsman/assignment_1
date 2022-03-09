package com.csis365.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyItemAdapter(val data: List<String>) : RecyclerView.Adapter<MyItemAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_simple_button, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.button.text = data[position]
    }

    override fun getItemCount() = data.size

    class MyViewHolder(view: View) :  RecyclerView.ViewHolder(view){
        val button: Button

        init{
            button = view.findViewById(R.id.bt_data)
        }
    }

}