package com.csis365.assignment1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable


class FruitiesAdapter(private val fruity: List<Fruity>) : RecyclerView.Adapter<FruitiesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.fruity_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruity[position]
        holder.fruitName.text = fruit.name
        holder.fruitFamily.text = "Family: " + fruit.family
        holder.fruitGenus.text = "Genus: " + fruit.genus
        holder.itemView.setOnClickListener {
            val i = Intent(it.context, FruitDetailActivity::class.java)
            i.putExtra("fruit", fruit)
            holder.itemView.context.startActivity(i)
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitName: TextView = itemView.findViewById(R.id.fruit_name)
        val fruitGenus: TextView = itemView.findViewById(R.id.fruit_genus)
        val fruitFamily: TextView = itemView.findViewById(R.id.fruit_family)
    }
    override fun getItemCount() = fruity.size

}
