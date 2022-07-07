package com.mauricio.moviles_bg2m.categories.departamentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mauricio.moviles_bg2m.ApiService
import com.mauricio.moviles_bg2m.ProductAdapter
import com.mauricio.moviles_bg2m.Products
import com.mauricio.moviles_bg2m.R
import com.mauricio.moviles_bg2m.databinding.FragmentCategoriesInsideBinding
import kotlinx.android.synthetic.main.fragment_categories_inside.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CategoriesLaPaz : Fragment() {
    lateinit var binding: FragmentCategoriesInsideBinding
    private val mStoragesIds = listOf<String>(
        "-DeptoSV-PA01",
        "-DeptoSV-PA02",
        "-DeptoSV-PA03",
        "-DeptoSV-PA04",
        "-DeptoSV-PA05"
    )
    val fReference = "lapaz"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_categories_inside, container, false
        )

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pc-budget.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)
        var productsList: MutableList<Products> = ArrayList()

        mStoragesIds.forEach() {
            service.getProducts(it).enqueue(object : Callback<Products> {
                override fun onResponse(
                    call: Call<Products>?, response: Response<Products>?
                ) {
                    val productsData = response?.body()
                    productsList.add(productsData!!)
                    showData(productsList)
                    //d("products", "GetAllProducts " + productsData)

                }

                override fun onFailure(call: Call<Products>, t: Throwable?) {
                    t?.printStackTrace()
                }

            })
        }

        return binding.root
    }

    private fun showData(products: MutableList<Products>) {
        recycler_view_laptops.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductAdapter(products, fReference)
        }
    }

}

/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
