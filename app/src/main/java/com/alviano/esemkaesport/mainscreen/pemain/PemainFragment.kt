package com.alviano.esemkaesport.mainscreen.pemain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.databinding.FragmentPemainBinding
import com.alviano.esemkaesport.mainscreen.tim.TimAdapter
import com.alviano.esemkaesport.mainscreen.tim.TimFragment
import java.util.Date

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

        // Ambil username dari arguments dan set ke TextView nameTxt
        val username = arguments?.getString("username_key", "Guest")
        binding.nameTxt.text = "Halo $username 👋"


        val currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(Date())
        binding.dateTxt.text = currentDateTimeString.toString()

        val imgPemain: Array<Int> = arrayOf(R.drawable.alberttt, R.drawable.kairi)
        val namaPemain: Array<String> = arrayOf("Albertt", "Kairi")
        val rolePemain: Array<String> = arrayOf("Jungler", "Jungler")

        val gridAdapter: PemainAdapter = PemainAdapter()
        gridAdapter.gridAdapter(requireContext(), imgPemain, namaPemain, rolePemain)
        binding.dataPemain.adapter = gridAdapter

        binding.dataPemain.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(requireContext(), "You Clicked on ${namaPemain[position]}", Toast.LENGTH_SHORT).show()
        }

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