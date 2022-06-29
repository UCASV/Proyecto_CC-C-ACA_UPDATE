package com.mauricio.moviles_bg2m.moreFragmentViews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mauricio.moviles_bg2m.*

import com.mauricio.moviles_bg2m.databinding.FragmentHomeArtDescBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class HomeArtDesc : Fragment() {
    private lateinit var binding: FragmentHomeArtDescBinding
    private lateinit var viewModel: ProductDescViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_art_desc,container,false)


        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pc-budget.firebaseio.com").addConverterFactory(
            GsonConverterFactory.create()).build()

        val service = retrofit.create(ApiService::class.java)
        var productsList: MutableList<Products> = ArrayList()
        val code = arguments?.getString("codeArt")
        service.getProducts(code!!).enqueue(object : Callback<Products> {
            override fun onResponse(
                call: Call<Products>?, response: Response<Products>?
            ) {
                val productsData = response?.body()
                productsList.add(productsData!!)
                //var url = productsList[0]!!.URL

                Picasso.with(context).load(productsList[0].imageUrl).into(binding.imgArt)
                //viewModel.image.value = binding.imgProductoDesc

                var str : String = productsList[0].info_art.replace("|","\n\n")

                binding.tituloArtPd.text = productsList[0].title_art
                binding.infoArticulo.text = str

            }

            override fun onFailure(call: Call<Products>, t: Throwable?) {
                t?.printStackTrace()
            }
        })

        return binding.root
    }

}

/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
