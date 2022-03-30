package com.csis365.assignment1.Services

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.R
import org.w3c.dom.Text

class Adapter(private val fruitList : List<Fruits>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {


    // Recyclerview onclick listener related code
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    // Adapter related code
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_list, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = fruitList[position]
        holder.name.text = currentItem.name
        holder.genus.text = "Genus: ${currentItem.genus}"
        holder.order.text = "Order: ${currentItem.order}"
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.name)
        val genus : TextView = itemView.findViewById(R.id.genus)
        val order : TextView = itemView.findViewById(R.id.order)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}