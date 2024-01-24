package com.rivskyinc.bebetter.presentation

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.rivskyinc.bebetter.R
import com.rivskyinc.bebetter.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {


private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivitySplashScreenBinding.inflate(layoutInflater)
     setContentView(binding.root)
        startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        finish()

    }

}