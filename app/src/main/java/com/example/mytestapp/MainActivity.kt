package com.example.mytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytestapp.databinding.ActivityMainBinding
import com.example.mytestapp.network.MetService
import com.example.mytestapp.network.RetrofitInitializer

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var service: MetService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service = RetrofitInitializer().metService()

    }
}