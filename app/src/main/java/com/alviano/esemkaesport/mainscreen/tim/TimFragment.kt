package com.alviano.esemkaesport.mainscreen.tim

import android.icu.text.DateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.databinding.FragmentTimBinding
import com.alviano.esemkaesport.mainscreen.pemain.PemainAdapter
import com.alviano.esemkaesport.mainscreen.pemain.PemainFragment
import java.util.Date

class TimFragment : Fragment() {

    private lateinit var binding: FragmentTimBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTimBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(Date())

        binding.dateTxt.text = currentDateTimeString.toString()

        val imgTim: Array<Int> = arrayOf(R.drawable.onic_logo, R.drawable.alter_ego, R.drawable.rrq_svg)
        val dataTim: Array<String> = arrayOf("Onic", "AE", "RRQ")

        val gridAdapter: TimAdapter = TimAdapter()
        gridAdapter.gridAdapter(requireContext(), imgTim, dataTim)
        binding.dataTim.adapter = gridAdapter

        binding.dataTim.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(requireContext(), "You Clicked on ${dataTim[position]}", Toast.LENGTH_SHORT).show()
        }

        binding.timBtn.setOnClickListener {
            val timFragment = TimFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager
                .beginTransaction().apply {
                    replace(
                        R.id.main_fragment_container,
                        timFragment,
                        TimFragment::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()
                }
        }

        binding.pemainBtn.setOnClickListener {
            val pemainFragment = PemainFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager
                .beginTransaction().apply {
                    replace(
                        R.id.main_fragment_container,
                        pemainFragment,
                        PemainFragment::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()
                }
        }
    }

}