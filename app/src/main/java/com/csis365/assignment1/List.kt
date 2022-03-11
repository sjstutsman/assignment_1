package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class List : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Fruits>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title ="Fruit List"

        heading = arrayOf(
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
        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager= LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Fruits>()
        getUserData()
    }

    private fun getUserData(){
        for(i in heading.indices){
            val cat = Fruits(heading[i])
            newArrayList.add(cat)
        }
        newRecyclerView.adapter = Adapter(newArrayList)
    }
}