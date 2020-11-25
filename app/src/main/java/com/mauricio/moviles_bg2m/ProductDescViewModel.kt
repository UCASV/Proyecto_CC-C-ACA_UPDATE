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