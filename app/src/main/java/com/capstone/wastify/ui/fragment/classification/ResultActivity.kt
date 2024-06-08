package com.capstone.wastify.ui.fragment.classification

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.capstone.wastify.databinding.ActivityResultBinding
import com.capstone.wastify.ui.activity.HomeActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exitButton.setOnClickListener {
            val intentHome = Intent(this@ResultActivity, HomeActivity::class.java)
            startActivity(intentHome)
        }

    }
}