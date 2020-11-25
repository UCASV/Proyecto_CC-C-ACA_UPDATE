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
