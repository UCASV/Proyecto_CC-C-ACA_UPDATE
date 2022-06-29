package com.mauricio.moviles_bg2m.main_views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mauricio.moviles_bg2m.R
import com.mauricio.moviles_bg2m.databinding.FragmentProductsBinding

/**
 * A simple [Fragment] subclass.
 */
class ProductsFragment : Fragment() {
    lateinit var binding : FragmentProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_products,container
            ,false)

        navegacionCategorias()

        return binding.root
    }



    private fun navegacionCategorias(){
        binding.apply {
            builtPcButton.setOnClickListener { view : View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_laptop)
            }
            buttonProcessor.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_Procesadores)
            }
            buttnVideocard.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_Tarj_video)
            }
            buttonMemories.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_Memorias)
            }
            buttonMotherboard.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_Tarj_Madre)
            }
            buttonStorage.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_almacenamiento)
            }
            buttonPowerSupply.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_Fuentes_Poder)
            }
            buttonCase.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categories_Gabinetes)
            }
            buttonElsalvador.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_productsFragment_to_categoriesElSalvador)
            }

        }
    }

}


/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
