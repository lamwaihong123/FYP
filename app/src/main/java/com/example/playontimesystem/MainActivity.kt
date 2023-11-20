package com.example.playontimesystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.playontimesystem.databinding.ActivityMainBinding
import com.example.playontimesystem.databinding.ActivitySignInBinding
import com.example.playontimesystem.login.SignInActivity
import com.example.playontimesystem.login.SignUpActivity
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val back : Button = findViewById(R.id.backButton)

        back.setOnClickListener {
            val back1 = Intent(this, SignInActivity::class.java)
            startActivity(back1)
            finish()
        }
    }


}