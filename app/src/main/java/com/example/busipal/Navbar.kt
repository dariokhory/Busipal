package com.example.busipal

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.busipal.databinding.ActivityNavbarBinding

class Navbar : AppCompatActivity() {

    private lateinit var binding: ActivityNavbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_navbar)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        navView.setupWithNavController(navController)
    }
}