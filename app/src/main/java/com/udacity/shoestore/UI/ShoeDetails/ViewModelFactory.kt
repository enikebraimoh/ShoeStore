package com.udacity.shoestore.UI.ShoeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.UI.ShoeList.ShoeListModel
import com.udacity.shoestore.models.Shoe

class ViewModelFactory(shoe : Shoe) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListModel::class.java)){
            return modelClass as T
        }
        throw IllegalArgumentException("invalid viewModel Class")
    }
}