package com.example.cocheroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CocheViewModelFactory(private val repository: CocheRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocheViewModel::class.java)) {
            return CocheViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}