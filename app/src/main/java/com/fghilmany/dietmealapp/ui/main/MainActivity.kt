package com.fghilmany.dietmealapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.ActivityHomeBinding
import com.fghilmany.dietmealapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}