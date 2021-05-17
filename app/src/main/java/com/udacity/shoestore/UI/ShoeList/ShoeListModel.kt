package com.udacity.shoestore.UI.ShoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListModel() : ViewModel() {

    val shoes = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoe : LiveData<MutableList<Shoe>> get() = _shoes

    init {
        Timber.i("ViewModel Created")
    }

    fun addShoe(newShoe : Shoe){
        shoes.add(newShoe)
        _shoes.value = shoes
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ViewModel Destroyed")
    }

}