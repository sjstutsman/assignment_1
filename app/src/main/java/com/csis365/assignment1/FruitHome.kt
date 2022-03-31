package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitHome : AppCompatActivity() {
    private val BASE_URL = "https://www.fruityvice.com/api/fruit/"
    private var loggedIn = false
    private lateinit var SharedPreferences: SharedPreferences
    private lateinit var recyclerView: RecyclerView
    private lateinit var welcomeText: TextView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var nav_view : NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_home)
        drawerLayout = findViewById(R.id.drawerLayout)
        nav_view = findViewById(R.id.nav_view)


        toggle = ActionBarDrawerToggle(this@FruitHome, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fun logout()
        {
            val edit: SharedPreferences.Editor = SharedPreferences.edit()
            edit.clear()
            edit.apply()
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
            finish()

        }

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ContactDev -> Toast.makeText(applicationContext, "github.com/abenezermario", Toast.LENGTH_SHORT).show()
                R.id.Logout -> logout()
            }

            true
        }




        SharedPreferences = getSharedPreferences("SHARED", Context.MODE_PRIVATE)
        loggedIn = SharedPreferences.getBoolean("LOGGEDIN", false)
        welcomeText = findViewById(R.id.welcome)

        var username = SharedPreferences.getString("USERNAME", "")

        val retro = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        recyclerView = findViewById(R.id.recycler_view)


        val api = retro.create(RetroService::class.java)
        api.getAllFruit().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {

                Log.d("response", "response succesfull")
                recyclerView.layoutManager = LinearLayoutManager(this@FruitHome)

                recyclerView.adapter = FruitListAdapter(response.body()!!)
                welcomeText.setText("Hello, " + username.toString())

                Log.d("username", username.toString())


            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.d("fail", "Error")
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}