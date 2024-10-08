package com.alviano.esemkaesport.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alviano.esemkaesport.data.Team
import com.alviano.esemkaesport.databinding.TeamViewholderBinding

class MainScreenAdapter(private val teamList: List<Team>) :
    RecyclerView.Adapter<MainScreenAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: TeamViewholderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val binding = TeamViewholderBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = teamList[position]
        holder.binding.teamTxt.text = currentItem.name.toString()
    }
}