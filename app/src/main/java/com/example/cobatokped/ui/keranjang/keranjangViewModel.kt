package com.example.cobatokped.ui.keranjang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class keranjangViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ini keranjang"
    }
    val text: LiveData<String> = _text
}