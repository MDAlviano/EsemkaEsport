package com.alviano.esemkaesport.mainscreen.pemain

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alviano.esemkaesport.R
import com.alviano.esemkaesport.data.Pemain
import com.alviano.esemkaesport.databinding.PemainViewholderBinding
import org.w3c.dom.Text

class PemainAdapter(private val listPemain: ArrayList<Pemain>): RecyclerView.Adapter<PemainAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: PemainViewholderBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = PemainViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = listPemain.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (nama, role, foto) = listPemain[position]
        holder.binding.pemainNameTxt.text = nama
        holder.binding.rolePemainTxt.text = role
        holder.binding.imagePemainTxt.setImageResource(foto)
    }

//    private lateinit var context: Context
//    private lateinit var imgPemain: Array<Int>
//    private lateinit var pemainName: Array<String>
//    private lateinit var pemainRole: Array<String>
//    private lateinit var inflater: LayoutInflater
//
//    fun gridAdapter(context: Context, imgPemain: Array<Int>, pemainName: Array<String>, pemainRole: Array<String>) {
//        this.context = context
//        this.imgPemain = imgPemain
//        this.pemainName = pemainName
//        this.pemainRole = pemainRole
//        this.inflater = LayoutInflater.from(context) // Inisialisasi inflater
//    }
//
//    override fun getCount(): Int {
//        return pemainName.size
//    }
//
//    override fun getItem(p0: Int): Any? {
//        return null
//    }
//
//    override fun getItemId(p0: Int): Long {
//        return 0
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        // Gunakan var view untuk menampung convertView atau inflate jika null
//        val view = convertView ?: inflater.inflate(R.layout.pemain_viewholder, parent, false)
//
//        // Gunakan findViewById secara aman tanpa !! untuk menghindari NullPointerException
//        val imageView: ImageView = view.findViewById(R.id.imagePemainTxt)
//        val textView: TextView = view.findViewById(R.id.pemainNameTxt)
//        val roleText: TextView = view.findViewById(R.id.rolePemainTxt)
//
//        // Atur data ke imageView dan textView
//        imageView.setImageResource(imgPemain[position])
//        textView.text = pemainName[position]
//        roleText.text = pemainRole[position]
//
//        // Kembalikan view yang tidak null
//        return view
//    }

}