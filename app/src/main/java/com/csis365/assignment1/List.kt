package com.csis365.assignment1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.Services.Adapter
import com.csis365.assignment1.Services.Fruits

class List : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Fruits>
    lateinit var fruitList : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title ="Fruit List"

        fruitList = arrayOf(
            "Banana",
            "Avocado",
            "Orange",
            "Apple",
            "Grape",
            "Banana",
            "Avocado",
            "Orange",
            "Apple",
            "Grape",
            "Banana",
            "Avocado",
            "Orange",
            "Apple",
            "Grape",
        )
        fun getData(){
            for(i in fruitList.indices){
                val fruits = Fruits(fruitList[i], "genus", "order")
                newArrayList.add(fruits)
            }

            val adapter = Adapter(newArrayList)
            newRecyclerView.adapter = adapter

            adapter.setOnItemClickListener(object : Adapter.onItemClickListener{
                override fun onItemClick(position: Int) {
                    val myIntent = Intent(this@List, Details::class.java)
                    myIntent.putExtra("id", position+1)
                    startActivity(myIntent)
                }
            })
        }
        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager= LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Fruits>()
        getData()
    }


}