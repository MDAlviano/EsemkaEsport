package com.alviano.esemkaesport

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alviano.esemkaesport.data.Pemain
import com.alviano.esemkaesport.databinding.ActivityDetailPemainBinding

class DetailPemainActivity : AppCompatActivity() {

    companion object {
        const val DATA_PEMAIN = "data_pemain"
    }

    private lateinit var binding: ActivityDetailPemainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Pemain>(DATA_PEMAIN)

        binding.fotoPemain.setImageResource(data?.foto!!)
        binding.tvName.text = data.nama
        binding.tvRole.text = data.role

        binding.btnBackFromDetailPemain.setOnClickListener {
            finish()
        }

    }
}