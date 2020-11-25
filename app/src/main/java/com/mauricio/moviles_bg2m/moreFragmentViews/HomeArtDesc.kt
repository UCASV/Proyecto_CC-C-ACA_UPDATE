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
