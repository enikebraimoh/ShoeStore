package com.udacity.shoestore.UI.ShoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListModel() : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoe : LiveData<MutableList<Shoe>> get() = _shoes

    init {
        Timber.i("ViewModel Created")
    }

    fun addShoe(newShoe : Shoe){
        _shoes.value?.add(newShoe)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ViewModel Destroyed")
    }

}