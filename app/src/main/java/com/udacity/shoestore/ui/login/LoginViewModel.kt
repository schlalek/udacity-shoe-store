package com.udacity.shoestore.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _eventLogin = MutableLiveData<Boolean>(false)
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    fun onLoginClicked() {
        _eventLogin.value = true
    }

    fun onLoginClickedComplete() {
        _eventLogin.value = false
    }


}