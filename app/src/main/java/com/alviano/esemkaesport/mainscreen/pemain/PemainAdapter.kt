package com.alviano.esemkaesport.mainscreen.pemain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.alviano.esemkaesport.R
import org.w3c.dom.Text

class PemainAdapter: BaseAdapter() {

    private lateinit var context: Context
    private lateinit var imgPemain: Array<Int>
    private lateinit var pemainName: Array<String>
    private lateinit var pemainRole: Array<String>
    private lateinit var inflater: LayoutInflater

    fun gridAdapter(context: Context, imgPemain: Array<Int>, pemainName: Array<String>, pemainRole: Array<String>) {
        this.context = context
        this.imgPemain = imgPemain
        this.pemainName = pemainName
        this.pemainRole = pemainRole
        this.inflater = LayoutInflater.from(context) // Inisialisasi inflater
    }

    override fun getCount(): Int {
        return pemainName.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Gunakan var view untuk menampung convertView atau inflate jika null
        val view = convertView ?: inflater.inflate(R.layout.pemain_viewholder, parent, false)

        // Gunakan findViewById secara aman tanpa !! untuk menghindari NullPointerException
        val imageView: ImageView = view.findViewById(R.id.imagePemainTxt)
        val textView: TextView = view.findViewById(R.id.pemainNameTxt)
        val roleText: TextView = view.findViewById(R.id.rolePemainTxt)

        // Atur data ke imageView dan textView
        imageView.setImageResource(imgPemain[position])
        textView.text = pemainName[position]
        roleText.text = pemainRole[position]

        // Kembalikan view yang tidak null
        return view
    }

}