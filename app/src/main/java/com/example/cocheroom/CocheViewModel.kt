package com.example.cocheroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class CocheViewModel(private val cocheDao: CocheRepository) : ViewModel() {

    val allCoches: Flow<List<Coche>> = cocheDao.getAllCoches()

    fun insertCoche(coche: Coche.Coche) {
        viewModelScope.launch {
            cocheDao.insert(coche)
        }
    }
}