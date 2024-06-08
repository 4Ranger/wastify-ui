package com.capstone.wastify.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.capstone.wastify.R
import com.capstone.wastify.databinding.ActivityPersonBinding

class PersonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}