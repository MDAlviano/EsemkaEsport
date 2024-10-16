package com.alviano.esemkaesport.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.databinding.ActivityMainScreenBinding
import com.alviano.esemkaesport.mainscreen.pemain.PemainFragment
import com.alviano.esemkaesport.mainscreen.tim.TimFragment

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val fragmentTim = TimFragment()
        val fragment = mFragmentManager.findFragmentByTag(TimFragment::class.java.simpleName)

        // Ambil username dari Intent
        val username = intent.getStringExtra("username_key")

        // Buat instance TimFragment dan kirim username melalui Bundle
        val timFragment = TimFragment()
//        val pemainFragment = PemainFragment()
        val bundle = Bundle()
        bundle.putString("username_key", username)
        timFragment.arguments = bundle
//        pemainFragment.arguments = bundle

        Log.d("MainScreenActivity", "Username sent: $username")

        if (fragment == null) {
            if (fragment !is TimFragment) {
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.main_fragment_container, fragmentTim, TimFragment::class.java.simpleName)
                    .commit()
            }
        }

    }
}