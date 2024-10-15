package com.alviano.esemkaesport.mainscreen.pemain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.alviano.esemkaesport.R

class PemainAdapter: BaseAdapter() {

    private lateinit var context: Context
    private lateinit var imgTim: Array<Int>
    private lateinit var timName: Array<String>
    private lateinit var inflater: LayoutInflater

    fun gridAdapter(context: Context, imgTim: Array<Int>, timName: Array<String>) {
        this.context = context
        this.imgTim = imgTim
        this.timName = timName
        this.inflater = LayoutInflater.from(context) // Inisialisasi inflater
    }

    override fun getCount(): Int {
        return timName.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Gunakan var view untuk menampung convertView atau inflate jika null
        val view = convertView ?: inflater.inflate(R.layout.team_viewholder, parent, false)

        // Gunakan findViewById secara aman tanpa !! untuk menghindari NullPointerException
        val imageView: ImageView = view.findViewById(R.id.imageTeamTxt)
        val textView: TextView = view.findViewById(R.id.teamNameTxt)

        // Atur data ke imageView dan textView
        imageView.setImageResource(imgTim[position])
        textView.text = timName[position]

        // Kembalikan view yang tidak null
        return view
    }

}