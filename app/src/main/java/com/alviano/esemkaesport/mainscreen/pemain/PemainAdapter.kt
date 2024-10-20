package com.alviano.esemkaesport.mainscreen.pemain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alviano.esemkaesport.data.Pemain
import com.alviano.esemkaesport.databinding.PemainViewholderBinding

class PemainAdapter(private val listPemain: ArrayList<Pemain>) :
    RecyclerView.Adapter<PemainAdapter.MyViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class MyViewHolder(var binding: PemainViewholderBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            PemainViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = listPemain.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (nama, role, foto) = listPemain[position]
        holder.binding.pemainNameTxt.text = nama
        holder.binding.rolePemainTxt.text = role
        holder.binding.imagePemainTxt.setImageResource(foto)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPemain[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pemain)
    }

}