package com.csis365.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "Login Page"
        val loginButton = findViewById<Button>(R.id.login_btn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        fun validateLogin(username: EditText, password: EditText) {
            loginButton.setOnClickListener {
                if (username.text.length >= (4) && password.text.toString() == "password") {
                    startActivity(Intent(this, List::class.java))
                }
                else {
                    val loginError = findViewById<TextView>(R.id.error_message)
                    loginError.visibility = View.VISIBLE
                }
            }
        }
        validateLogin(username, password)
    }

}
