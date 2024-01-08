package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String, private var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable, BaseObservable() {
    constructor() : this("", 0.0, "", "")
    

    @Bindable
    fun getSize(): String {
        return size.toString()
    }

    fun setSize(value: String) {
        size = value.toDouble()
    }
}