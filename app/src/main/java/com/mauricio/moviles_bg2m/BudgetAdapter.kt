package com.mauricio.moviles_bg2m

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mauricio.moviles_bg2m.main_views.HomeFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.budget_list.view.*

class BudgetAdapter(private val products: MutableList<Products>) :
    RecyclerView.Adapter<BudgetAdapter.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var args: Bundle


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

            holder.pName.text = product.title_art
            holder.pdesc.text = str


            holder.itemView.setOnClickListener { view: View ->
                args = bundleOf("codeArt" to products.get(position).code)
                view.findNavController().navigate(R.id.action_homeFragment_to_homeArtDesc, args)
            }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pName: TextView = itemView.titulo_noticia
        val pdesc: TextView = itemView.desc_Noticia

        val bImg2: ImageView = itemView.img2
    }


}
    
/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
