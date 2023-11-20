package com.example.playontimesystem.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.playontimesystem.R
import com.example.playontimesystem.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth

    private lateinit var email : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var conPassword : TextInputEditText

    //Data Variables
    private lateinit var userEmail : String
    private lateinit var userPassword : String
    private lateinit var userConPassword : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding = ActivitySignupBinding.inflate(layoutInflater)

        val signIn : TextView = findViewById(R.id.login)
        val registerButton : Button = findViewById(R.id.regButton)

        auth = FirebaseAuth.getInstance()

        signIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        email = findViewById(R.id.newEmail)
        password = findViewById(R.id.newPassword)
        conPassword = findViewById(R.id.confirmPass)


        registerButton.setOnClickListener {
            userEmail = email.text.toString()
            userPassword = password.text.toString()
            userConPassword = conPassword.text.toString()

            if (userEmail.isNotEmpty() && userPassword.isNotEmpty() && userConPassword.isNotEmpty()) {
                if (userPassword == userConPassword) {

                    auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this,"Register Successful",Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}