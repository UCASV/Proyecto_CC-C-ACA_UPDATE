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

    private lateinit var binding: FragmentHomeBinding
    private val mDestArtIds = listOf<String>(
        "-MBM9ZrgNCv08p_r0_Ly",
        "-MBMA2Sqx18qmQTn85Uz",
        "-MBMAVEkaVuxvRlC3vko",
        "-MBMB1M_q744LKJrTojy",
        "-MBMBGLNzUA3RpadNR79",
        "-MBMBUdHmW4ucUx-tuR9",
        "-MBMBnwyzzmqzsw6UuRD",
        "-MBMCABQi5-LBs8Yo05c",
        "-MBMCKN7FjRYSje5FhQZ",
        "-MBMCYTzaWhCPpvg4PMi"
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
        var BudgetList : MutableList<Products> = ArrayList()

        var i = 0
        var n= (0..4).random()
        var code = mDestArtIds[n]

        while (i < 5){
            service.getBudgets(code).enqueue(object : Callback<Products> {
                override fun onResponse(
                    call: Call<Products>?, response: Response<Products>?
                ) {
                    val BudgetData = response?.body()
                    BudgetList.add(BudgetData!!)
                    showData(BudgetList)
                    //d("BUDGETS", "" + BudgetData)

                }

                override fun onFailure(call: Call<Products>, t: Throwable?) {
                    t?.printStackTrace()
                }
            })
            i++
        }

        return binding.root
    }

    private fun showData(Budgets: MutableList<Products>) {
        recycler_view_budgets.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = BudgetAdapter(Budgets)
        }
    }
}
