package com.csis365.assignment1.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.R
import com.csis365.assignment1.service.dto.Fruit

class FruitAdapter(private val data: List<Fruit>, private val context:Context) : RecyclerView.Adapter<FruitAdapter.MyViewHolder>() {
    private lateinit var mListener: FruitDetailListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.activity_fruit_list, parent, false)
        return  MyViewHolder(view, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.aName.text = data[position].name
        holder.aGen.text = "Genus: " + data[position].genus
        holder.anOrder.text = "Order: " + data[position].order
        holder.itemView.setOnClickListener {
            val genus: String? = data[position].genus
            val name: String? = data[position].name
            val id: Int? = data[position].id
            val family: String? = data[position].family
            val order: String? = data[position].order

            val carbohydrates: Double? = data[position].nutritions!!.carbohydrates
            val protein: Double? = data[position].nutritions!!.protein
            val fat: Double? = data[position].nutritions!!.fat
            val calories: Int? = data[position].nutritions!!.calories
            val sugar: Double? = data[position].nutritions!!.sugar

            val intent = Intent(context, FruitDetail::class.java)
            Toast.makeText(context, "Fruit no. $position", Toast.LENGTH_SHORT).show()
            intent.putExtra("Name", name)
            intent.putExtra("Genus", genus)
            intent.putExtra("Order", order)
            intent.putExtra("Id", id)
            intent.putExtra("Family", family)

            intent.putExtra("Carbohydrates", carbohydrates)
            intent.putExtra("Protein", protein)
            intent.putExtra("Fat", fat)
            intent.putExtra("Calories", calories)
            intent.putExtra("Sugar", sugar)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder (view: View, listener: FruitDetailListener): RecyclerView.ViewHolder(view){

        val aName: TextView
        val aGen: TextView
        val anOrder: TextView


        init{
            aName = view.findViewById(R.id.tv_name)
            aGen = view.findViewById(R.id.tv_genus)
            anOrder = view.findViewById(R.id.tv_order)

            view.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    interface FruitDetailListener{
        fun onItemClick(position: Int)
    }

    fun setFruitDetailListener(listener: FruitDetailListener) {
        mListener = listener
    }

}
