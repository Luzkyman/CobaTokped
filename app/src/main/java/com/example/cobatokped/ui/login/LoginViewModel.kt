package com.example.cobatokped.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cobatokped.core.data.repository.AppRepository

class LoginViewModel(val repo:AppRepository):ViewModel (){
    private val _text = MutableLiveData<String>().apply {
        value = "Hi, Im Developer"
    }
    val text: LiveData<String> = _text

    fun ubahData(){
        _text.postValue("Ini aku jadi koki")
    }

}