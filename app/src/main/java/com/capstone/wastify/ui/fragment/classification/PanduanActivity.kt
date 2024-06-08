package com.capstone.wastify.ui.fragment.classification

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.capstone.wastify.databinding.ActivityPandunBinding

class PanduanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPandunBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPandunBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mulaiButton.setOnClickListener {
            val intentClassification = Intent(this@PanduanActivity, ClassificationActivity::class.java)
            startActivity(intentClassification)
        }
    }
}