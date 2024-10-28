package com.alviano.esemkaesport

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alviano.esemkaesport.databinding.ActivityDetailTeamBinding

class DetailTeamActivity : AppCompatActivity() {

    companion object {
        const val DATA_TIM = "data_tim"
    }

    private lateinit var binding: ActivityDetailTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}