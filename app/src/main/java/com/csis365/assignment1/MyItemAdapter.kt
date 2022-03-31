package com.csis365.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MyItemAdapter(val data: List<Fruit>) : RecyclerView.Adapter<MyItemAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_simple_button, parent, false)



        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.button.text = data[position].name
        holder.button.setOnClickListener {
            var gson = Gson()
            var nutrition =  gson.fromJson(data[position].nutritions, Nutritions::class.java)
            var fruitbundle = bundleOf(
                "name" to data[position].name,
                "family" to data[position].family,
                "genus" to data[position].genus,
                "order" to data[position].order,
                "carbohydrates" to nutrition.carbohydrates,
                "protein" to nutrition.protein,
                "fat" to nutrition.fat,
                "calories" to nutrition.calories,
                "sugar" to nutrition.sugar
            )
            val context = holder.itemView.context
            val intent = Intent(context, FruitActivity::class.java).apply {
                putExtra("fruit", fruitbundle)
            }
            startActivity(context, intent, fruitbundle)
        }
    }

    override fun getItemCount() = data.size

    class MyViewHolder(view: View) :  RecyclerView.ViewHolder(view){
        val button: Button

        init{
            button = view.findViewById(R.id.bt_data)
        }
    }

}