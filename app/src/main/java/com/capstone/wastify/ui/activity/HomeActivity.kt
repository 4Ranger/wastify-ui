package com.capstone.wastify.ui.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.capstone.wastify.R
import com.capstone.wastify.databinding.ActivityHomeBinding
import com.capstone.wastify.ui.fragment.classification.PanduanActivity

class HomeActivity : AppCompatActivity() {

private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = ActivityHomeBinding.inflate(layoutInflater)
         setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        navView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_list,
            R.id.navigation_classification,
            R.id.navigation_database,
            R.id.navigation_location))


        navView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_classification -> {
                    // Launch ClassificationActivity
                    val intent = Intent(this, PanduanActivity::class.java)
                    startActivity(intent)
                    true // Consumed the event
                }
                R.id.navigation_home,
                R.id.navigation_list,
                R.id.navigation_database,
                R.id.navigation_location -> {
                    navController.navigate(item.itemId)
                    true
                }
                else -> false
            }
        }

    }
}