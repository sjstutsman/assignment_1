package com.csis365.assignment1

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class FruitListAdapter(private val fruits: List<Fruit>) :
    RecyclerView.Adapter<FruitListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitname: TextView = itemView.findViewById(R.id.fruitname)
        val genusname: TextView = itemView.findViewById(R.id.genusname)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitListAdapter.ViewHolder, position: Int) {

        val fruit = fruits[position]
        holder.fruitname.text = fruit.name
        holder.genusname.text = fruit.genus



        holder.cardView.setOnClickListener {

            var intent = Intent(it.context, DetailsPage::class.java)
            intent.putExtra("fruit",fruit)
            it.context.startActivity(intent)
            Log.d("click", "clicked")
        }

    }

    override fun getItemCount() = fruits.size

}
