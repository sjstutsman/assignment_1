package com.csis365.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call

class FruitDetailAdapter(val data: Fruit) : RecyclerView.Adapter<FruitDetailAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_fruit_detail, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitDetailAdapter.MyViewHolder, position: Int) {
        holder.textView.text = data.toString()
    }

    override fun getItemCount(): Int {
        //return data.size
        return 0;
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.tv_fruit_detail)
        }
    }
}

