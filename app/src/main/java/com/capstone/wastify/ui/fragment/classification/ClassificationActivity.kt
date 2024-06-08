package com.capstone.wastify.ui.fragment.classification

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.capstone.wastify.databinding.ActivityClassificationBinding

class ClassificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityClassificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cameraOption.setOnClickListener {
            val intentPreview = Intent(this@ClassificationActivity, PreviewActivity::class.java)
            startActivity(intentPreview)
        }

        binding.galleryOption.setOnClickListener {
            val intentPreview = Intent(this@ClassificationActivity, PreviewActivity::class.java)
            startActivity(intentPreview)
        }
    }
}