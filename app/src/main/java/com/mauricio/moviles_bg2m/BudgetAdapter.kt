package com.mauricio.moviles_bg2m

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.budget_list.view.*

class BudgetAdapter(private val products: MutableList<Products>) :
    RecyclerView.Adapter<BudgetAdapter.ViewHolder>() {

    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.budget_list, parent, false)
        context = view.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

            Picasso.with(context).load(product.imageUrl).into(holder.bImg2)
            var str : String = product.info_art.replace("|","")

             holder.pdesc.text = str

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pName: TextView = itemView.titulo_noticia
        val pdesc: TextView = itemView.desc_Noticia

        val bImg2: ImageView = itemView.img2
    }


}