package com.mauricio.moviles_bg2m.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.mauricio.moviles_bg2m.R
import com.mauricio.moviles_bg2m.databinding.FragmentCategoriesElSalvadorBinding
import kotlinx.android.synthetic.main.fragment_products.*

class CategoriesElSalvador : Fragment() {
    lateinit var binding : FragmentCategoriesElSalvadorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_categories_el_salvador,container
            ,false)

        navegacionCategorias()

        return binding.root
    }

    private fun navegacionCategorias(){
        binding.apply {
            ahuachapan.setOnClickListener { view : View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesAhuachapan)
            }
            sonsonate.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesSonsonate)
            }
            santana.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesSantaAna)
            }
            lalibertad.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesLaLibertad)
            }
            sansalvador.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesSanSalvador)
            }
            chalatenango.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesChalatenango)
            }
            cuscatlan.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesCuscatlan)
            }
            lapaz.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesLaPaz)
            }
            cabanas.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesCabanas)
            }
            morazan.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesMorazan)
            }
            sanmiguel.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesSanMiguel)
            }
            sanvicente.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesSanVicente)
            }
            launion.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesLaUnion)
            }
            usulutan.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_categoriesElSalvador_to_categoriesUsulutan)
            }

        }
    }
}
