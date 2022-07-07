package com.mauricio.moviles_bg2m.main_views


import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mauricio.moviles_bg2m.R
import com.mauricio.moviles_bg2m.databinding.FragmentMoreBinding


class MoreFragment : Fragment() {
    lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_more, container, false
        )

        binding.apply {
            objetivosTxt.setOnClickListener { view: View ->
                showWindow(0)
            }
            acercaDeTxt.setOnClickListener { view: View ->
                showWindow(1)
            }
            quienesSomosTxt.setOnClickListener { view: View ->
                showWindow(2)
            }

            emailTxt.setOnClickListener { view: View ->
                val cm: ClipboardManager =
                    context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                cm.setText(emailTxt.getText())
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show()
            }

            Facebook.setOnClickListener { view: View ->
                startActivity(getOpenFacebookIntent())
            }

            Instagram.setOnClickListener { view: View ->
                startActivity(getOpenInstagramIntent())
            }
        }

        return binding.root
    }

    fun getOpenFacebookIntent(): Intent? {
        return try {
            activity?.packageManager?.getPackageInfo("com.facebook.katana", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/105336697870652"))
        } catch (e: Exception) {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/RoverRetirado")
            )
        }
    }

    fun getOpenInstagramIntent(): Intent? {
        val appIs = "http://instagram.com/{rover_retirado}"
        val urlIs = "http://instagram.com/_u/{rover_retirado}"

        return try {
            activity?.packageManager?.getPackageInfo("com.instagram.android", 0)
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.instagram.com/rover_retirado/?igshid=7l4ougvttp6")
            );
        } catch (e: ActivityNotFoundException) {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.instagram.com/rover_retirado/")
            )
        }
    }

    private fun showWindow(tipo: Int) {
        var text =
            "Brindar información de carácter general sobre los diversos temas vistos en la materia (calentamiento global, reciclaje, manejo de residuos, efecto invernadero, etc...), con la finalidad de llegar a mas personas y concientizar sobre los beneficios de cuidar nuestro medio ambiente."
        var titulo = "Objetivo:"

        if (tipo == 1) {
            text =
                "La aplicación consiste en mostrar articulos sobre algunos temas vistos en clase de una manera organizada por categorias y mostrando algunos articulos destacados. Tratando de cubrir algunos temas en nuestra aplicación, dando consejos, publicando información básica y de ayuda que las personas  pueden tomar de ejemplo para proyectos a futuro" +
                        "\n\n" +
                        "El método que utilizaremos para promocionar la aplicación será por medio de una pagina scout llamada: Un Rover retirado, la cual cuenta con mas de 1000 seguidores, con muchas personas entusiasmadas por crear proyectos de medio ambiente y desarrollo sostenible, así que se pretende que con esta aplicación, sirva de herramienta para todos aquellos que quieran aprender sobre lo que es la materia , y personas que están enfocadas a crear proyectos de medio ambiente puedan informarse correctamente sobre problemas que se viven actualmente, consejos para mejorar su ecosistema, o simplemente tener información a la mano para reportes o informacion propia"
            titulo = "Acerca de:"
        }

        if (tipo == 2) {
            text = "===================================\n\n" +
                    "Ultima Actualizacion por:\n\n" +
                    "Bryan Alexis Orellana Cabrera #00049318\n\n" +
                    "Miguel Ernesto Rivas Serrano #00087518\n\n" +
                    "Jesus Antonio Alvarado Gonzalez #00144318\n\n" +
                    "Gabriel Enrique Gonzalez Rodriguez #00199518\n\n" +
                    "Oscar Isai Aldana Cruz #00153818\n\n\n" +
                    "===================================\n\n" +
                    "Creditos a los creadores de la primer versión:\n\n" +
                    "Bryan Alexis Orellana Cabrera #00049318\n\n" +
                    "Miguel Ernesto Rivas Serrano #00087518\n\n" +
                    "Luis Gustavo Escobar Hernandez #00091318\n\n" +
                    "Jesus Antonio Alvarado Gonzalez #00144318\n\n" +
                    "Gabriel Enrique Gonzalez Rodriguez #00199518\n\n" +
                    "Guillermo Andres Salazar Barreda #00217218\n\n" +
                    "==================================="
            titulo = "¿Quienes Somos?"
        }
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle(titulo)
        builder.setMessage(text)
        builder.setPositiveButton("Aceptar", null)
        val dialogue: AlertDialog = builder.create()
        dialogue.show()
    }
}

/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
