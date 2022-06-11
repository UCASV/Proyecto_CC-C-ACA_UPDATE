package com.mauricio.moviles_bg2m.main_views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mauricio.moviles_bg2m.*
import com.mauricio.moviles_bg2m.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {
    private lateinit var viewModel: ProductDescViewModel
    private lateinit var binding: FragmentHomeBinding
    private val mDestArtIds = listOf<String>(
        "-MB7-TQlWk3CP7jJTn3B",
        "-MB72m40Fv4I9d_-44vP",
        "-MBIrKv5h3Tbsdb1uzlG",
        "-MBIsLhX3pyk3k_lOJR0",
        "-MBJ0mVmJYqchMYpnev1",
        "-MBJ2wmmS6TTY50ppI0L",
        "-MBMA2Sqx18qmQTn85Uz",
        "-MBMJ_PqKRrsRNAjpvgO",
        "-MBMB1M_q744LKJrTojy",
        "-MB72IPG_-ZgD7FZFAEl"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false)

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pc-budget.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)
        var productsList : MutableList<Products> = ArrayList()

        mDestArtIds.forEach() {
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
        recycler_view_budgets.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = BudgetAdapter(products)
        }
    }
}

/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
