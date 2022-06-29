package com.mauricio.moviles_bg2m.categories

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mauricio.moviles_bg2m.ApiService
import com.mauricio.moviles_bg2m.Products
import com.mauricio.moviles_bg2m.R
import com.mauricio.moviles_bg2m.databinding.FragmentPosterBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CategoriesGabinetes : Fragment() {
    private lateinit var binding: FragmentPosterBinding
    private val mCasesIds = listOf<String>(
        "-MBME9ZgjszNPOuCJyNQ"
    )
    val fReference = "case"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_poster,container,false)

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pc-budget.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)
        var productsList: MutableList<Products> = ArrayList()

        mCasesIds.forEach() {
            service.getProducts(it).enqueue(object : Callback<Products> {
                override fun onResponse(
                    call: Call<Products>?, response: Response<Products>?
                ) {
                    val productsData = response?.body()
                    productsList.add(productsData!!)
                    //d("products", "GetAllProducts " + productsData)

                    Picasso.with(context).load(productsList[0].imageUrl).into(binding.imgArt)
                }

                override fun onFailure(call: Call<Products>, t: Throwable?) {
                    t?.printStackTrace()
                }

            })
        }

        binding.imgArt.setOnClickListener{view: View->
            val intent = Intent(Intent.ACTION_VIEW, productsList[0].imageUrl.toUri()    )
            startActivity(intent)
        }

        return binding.root
    }
}

/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
