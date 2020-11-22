package com.mauricio.moviles_bg2m.moreFragmentViews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mauricio.moviles_bg2m.ApiService
import com.mauricio.moviles_bg2m.Products
import com.mauricio.moviles_bg2m.R
import com.mauricio.moviles_bg2m.databinding.FragmentProductDescriptionBinding
import com.mauricio.moviles_bg2m.observable
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.ImageListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class DescriptionProductFragment() : Fragment() {
    private lateinit var binding: FragmentProductDescriptionBinding
    private lateinit var viewModel: observable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_product_description, container, false
        )

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(observable::class.java)
        } ?: throw Exception("Invalid Fragment")

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pc-budget.firebaseio.com").addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(ApiService::class.java)
        var productsList: MutableList<Products> = ArrayList()
        val code = arguments?.getString("product")
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

        //carousel()

        return binding.root
    }

    /*fun carousel(){
        val sampleImages: IntArray = intArrayOf(R.drawable.ic_cpu, R.drawable.ic_ram, R.drawable.ic_laptops)

        binding.carouselView.pageCount = sampleImages.size

        var imageListener = ImageListener { position, imageView -> imageView.setImageResource(sampleImages.get(position)) }

        binding.carouselView.setImageListener(imageListener)

    }*/


}
