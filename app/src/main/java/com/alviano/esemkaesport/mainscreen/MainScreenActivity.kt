package com.alviano.esemkaesport.mainscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alviano.esemkaesport.databinding.ActivityMainScreenBinding

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}