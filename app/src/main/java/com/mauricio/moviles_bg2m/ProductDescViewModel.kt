package com.mauricio.moviles_bg2m

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductDescViewModel : ViewModel() {

    val art_Name = MutableLiveData<String>()
    val art_Image = MutableLiveData<String>()
    val art_Desc = MutableLiveData<String>()

    fun setInfo(Image: String, name: String, desc: String) {
        art_Image.value = Image
        art_Desc.value = desc
        art_Name.value = name
    }
}

/*Foobar is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see https://www.gnu.org/licenses/.
Este programa está publicado bajo la licencia XYZ*/
