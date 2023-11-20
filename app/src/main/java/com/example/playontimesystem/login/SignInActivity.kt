package com.example.playontimesystem.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.playontimesystem.MainActivity
import com.example.playontimesystem.R
import com.example.playontimesystem.databinding.ActivitySignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignInBinding
    private lateinit var auth: FirebaseAuth

    private lateinit var signInEmail : TextInputEditText
    private lateinit var signInPassword : TextInputEditText

    //Data Variables
    private lateinit var email : String
    private lateinit var password : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_sign_in)

        val registerButton : TextView = findViewById(R.id.register)
        val signInButton : Button = findViewById(R.id.signIn)

        auth = FirebaseAuth.getInstance()

        registerButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
    }

        signInEmail = findViewById(R.id.email)
        signInPassword = findViewById(R.id.password)

        signInButton.setOnClickListener {
            email = signInEmail.text.toString()
            password = signInPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this,"Sign In Successful",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    /*override fun onStart() {
        super.onStart()

        if(auth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }*/
}