package com.example.service_study

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.service_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() = with(binding) {
        startButton.setOnClickListener {
            startForegroundService(Intent(this@MainActivity, ForegroundService::class.java))
        }

        stopButton.setOnClickListener {
            stopService(Intent(this@MainActivity, ForegroundService::class.java))
        }
    }
}