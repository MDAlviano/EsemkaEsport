package com.alviano.esemkaesport.mainscreen.tim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.data.Team
import com.alviano.esemkaesport.databinding.TeamViewholderBinding

class TimAdapter(private val listTim: ArrayList<Team>): RecyclerView.Adapter<TimAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: TeamViewholderBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = TeamViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = listTim.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (name, logo) = listTim[position]
        holder.binding.teamNameTxt.text = name
        holder.binding.imageTeamTxt.setImageResource(logo)
    }

}