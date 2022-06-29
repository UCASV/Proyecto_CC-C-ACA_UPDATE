package com.mauricio.moviles_bg2m

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_list.view.*

class ProductAdapter(
    private val products: MutableList<Products>,
    private val fReference: String) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var context: Context
    private lateinit var args: Bundle


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list, parent, false)
        context = view.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        Picasso.with(context).load(product.imageUrl).into(holder.pImage)
        holder.pName.text = product.title_art

        var str : String = product.info_art.replace("|","")

        holder.pdesc.text = str

        holder.itemView.setOnClickListener { view: View ->
            when {
                fReference == "laptops" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController().navigate(
                        R.id.action_categories_laptops_to_descriptionProductFragment,
                        args
                    )
                }

                fReference == "processor" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categories_Procesadores_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "storage" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categories_almacenamiento_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "memories" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categories_Memorias_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "powersource" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categories_Fuentes_Poder_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "case" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categories_Gabinetes_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "motherboard" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categories_Tarj_Madre_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "videocard" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categories_Tarj_video_to_descriptionProductFragment,
                            args
                        )
                }
                //Adapter de cada departamento
                fReference == "ahuachapan" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesAhuachapan_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "sonsonate" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesSonsonate_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "santana" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesSantaAna_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "sansalvador" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesSanSalvador_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "lalibertad" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesLaLibertad_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "chalatenango" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesChalatenango_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "cuscatlan" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesCuscatlan_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "lapaz" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesLaPaz_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "cabanas" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesCabanas_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "morazan" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesMorazan_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "sanmiguel" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesSanMiguel_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "sanvicente" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesSanVicente_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "launion" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesLaUnion_to_descriptionProductFragment,
                            args
                        )
                }
                fReference == "usulutan" -> {
                    args = bundleOf("product" to products[position].code)
                    view.findNavController()
                        .navigate(
                            R.id.action_categoriesUsulutan_to_descriptionProductFragment,
                            args
                        )
                }
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pImage: ImageView = itemView.img2
        val pName: TextView = itemView.titulo_noticia
        val pdesc: TextView = itemView.desc_Noticia
    }

}
    
/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
