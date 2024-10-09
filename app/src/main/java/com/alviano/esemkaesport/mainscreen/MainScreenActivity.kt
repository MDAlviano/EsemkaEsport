package com.alviano.esemkaesport.mainscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.databinding.ActivityMainScreenBinding
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

        if (fragment !is TimFragment) {
            mFragmentManager
                .beginTransaction()
                .add(R.id.main_fragment_container, fragmentTim, TimFragment::class.java.simpleName)
                .commit()
        }
    }
}