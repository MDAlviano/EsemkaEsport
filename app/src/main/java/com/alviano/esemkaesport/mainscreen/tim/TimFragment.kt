package com.alviano.esemkaesport.mainscreen.tim

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.alviano.esemkaesport.DetailTeamActivity
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.data.Team
import com.alviano.esemkaesport.databinding.FragmentTimBinding
import com.alviano.esemkaesport.mainscreen.pemain.PemainFragment
import java.util.Date

class TimFragment : Fragment() {

    private lateinit var binding: FragmentTimBinding

    private val listTim = ArrayList<Team>()

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

        onClickListenerAction()

        // Ambil username dari arguments
        val username = arguments?.getString("username_key") ?: "Guest"
        Log.d("TimFragment", "Received username: $username")
        // Tampilkan username di TextView dengan ID nameTxt
        binding.nameTxt.text = "Halo $username 👋"

        val currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(Date())

        binding.dateTxt.text = currentDateTimeString.toString()

        listTim.addAll(getListPlace())
        showRecyclerView()

    }

    private fun onClickListenerAction() {

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

    private fun getListPlace(): ArrayList<Team> {
        val dataName = resources.getStringArray(R.array.data_tim)
        val logoTim = resources.obtainTypedArray(R.array.logo_tim)
        val listTim = ArrayList<Team>()
        for (i in dataName.indices) {
            val place = Team(dataName[i], logoTim.getResourceId(i, -1))
            listTim.add(place)
        }
        return listTim
    }

    private fun showRecyclerView() {
        binding.dataTim.layoutManager = GridLayoutManager(requireContext(), 2)
        val timAdapter = TimAdapter(listTim)
        binding.dataTim.adapter = timAdapter

        timAdapter.setOnTeamClickCallback(object : TimAdapter.OnTeamClickCallback {
            override fun onTeamCLicked(data: Team) {
                Toast.makeText(requireContext(), "Kamu nge-click tim : ${data.name}", Toast.LENGTH_SHORT).show()
                sendDataToDetailTim(data)
            }
        })
    }

    private fun sendDataToDetailTim(data: Team) {
        val intentDetail = Intent(requireContext(), DetailTeamActivity::class.java)
        intentDetail.putExtra("data_tim", data)
        startActivity(intentDetail)
    }

}