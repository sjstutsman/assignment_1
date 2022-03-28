package com.csis365.assignment1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.service.dto.Fruit

class FruitListAdapter(private val fruitList: List<Fruit>?) :
    RecyclerView.Adapter<FruitListAdapter.FruitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_fruitlist_textview, parent, false)

        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.textView.text = fruitList!![position].name
        holder.textView.setOnClickListener {

            val fruitDetailIntent = Intent(holder.textView.context,FruitDetailActivity::class.java)
            fruitDetailIntent.putExtra("fruitName",holder.textView.text.toString())
            startActivity(holder.textView.context, fruitDetailIntent,Bundle())

        }

    }

    override fun getItemCount(): Int {
        return fruitList?.size ?: 0
    }

    class FruitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.tv_fruitData)
        }
    }

}
