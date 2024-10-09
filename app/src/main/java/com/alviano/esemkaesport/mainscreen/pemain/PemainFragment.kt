package com.alviano.esemkaesport.mainscreen.pemain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.databinding.FragmentPemainBinding
import com.alviano.esemkaesport.mainscreen.tim.TimFragment

class PemainFragment : Fragment() {

    private lateinit var binding: FragmentPemainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPemainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pemainBtn.setOnClickListener {
            val pemainFragment = PemainFragment()
            val mFragmentManage = parentFragmentManager
            mFragmentManage.beginTransaction().apply {
                replace(R.id.main_fragment_container, pemainFragment, PemainFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        binding.timBtn.setOnClickListener {
            val timFragment = TimFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.main_fragment_container, timFragment, TimFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

}