package com.capstone.wastify.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.capstone.wastify.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val intentHome = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intentHome)
        }

        binding.registerButton.setOnClickListener {
            val intentRegister = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intentRegister)
        }
    }
}