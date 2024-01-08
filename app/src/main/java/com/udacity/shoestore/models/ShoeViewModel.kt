package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {


    private var _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val newShoe = MutableLiveData<Shoe>()

    init {
        newShoe.value = Shoe()
    }


    // navigate back to list
    private val _navigateBack = MutableLiveData<Boolean>()
    val navigateBack: LiveData<Boolean>
        get() = _navigateBack

    fun navigateBackComplete() {
        _navigateBack.value = false
    }

    // Navigate to Detail View
    private val _navigateDetail = MutableLiveData<Boolean>()
    val navigateDetail: LiveData<Boolean>
        get() = _navigateDetail

    fun navigateDetailComplete() {
        _navigateDetail.value = false
    }

    fun detailSaveShoe() {
        _shoeList.value?.add(newShoe.value!!)
        newShoe.value = Shoe()
        _navigateBack.value = true
    }

    fun cancelNewShoe() {
        newShoe.value = Shoe()
        _navigateBack.value = true
    }

    fun addNewShoe() {
        // switch to detail view
        _navigateDetail.value = true
    }


}