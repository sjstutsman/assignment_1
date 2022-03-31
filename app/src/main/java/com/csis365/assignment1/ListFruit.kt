package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.Services.Fruits
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListFruit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = "Fruit List"
        val pref = getSharedPreferences("loginState", Context.MODE_PRIVATE)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(FruitService::class.java)

        api.getFruit().enqueue(object : Callback<List<Fruits>> {
            override fun onResponse(call: Call<List<Fruits>>, response: Response<List<Fruits>>) {
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<Fruits>>, t: Throwable) {
                Log.d("asdf", "onFailure")
            }
        })
    }

    // Wanted a way to logout, decided to use overflow menu. Used Youtube to figure out how to do this. (My work uses overflow menus on their app to logout!)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val pref = getSharedPreferences("loginState", Context.MODE_PRIVATE)
        when(item.itemId){
            R.id.logout_button -> with(pref.edit()){
                putBoolean("loginState", false)
                commit()
            }
        }
        startActivity(Intent(this, Login::class.java))
        return super.onOptionsItemSelected(item)
    }

    private fun showData(fruits: List<Fruits>) {
        val rv: RecyclerView= findViewById(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(fruits)
        rv.adapter = adapter
        rv.apply{
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

        adapter.setOnItemClickListener(object : Adapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                // Realized after I finished this that I should've just send the ID and used the api to get
                // the info, but instead I sent everything through the intent. Hopefully that is okay.

                val intent = Intent(this@ListFruit, Details::class.java)
                intent.putExtra("name","${fruits[position].name}")
                intent.putExtra("genus", "${fruits[position].genus}")
                intent.putExtra("family", "${fruits[position].family}")
                intent.putExtra("order", "${fruits[position].order}")

                intent.putExtra("carb","${fruits[position].nutritions.carbohydrates}")
                intent.putExtra("protein","${fruits[position].nutritions.protein}")
                intent.putExtra("fat","${fruits[position].nutritions.fat}")
                intent.putExtra("cal","${fruits[position].nutritions.calories}")
                intent.putExtra("sugar","${fruits[position].nutritions.sugar}")
                startActivity(intent)
            }
        })
    }
}