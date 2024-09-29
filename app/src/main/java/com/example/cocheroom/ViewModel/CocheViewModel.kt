package com.example.cocheroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class CocheViewModel(private val repository: CocheRepository) : ViewModel() {
    val coches: StateFlow<List<Coche>> = repository.coches
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    fun insertarCoche(coche: Coche) {
        viewModelScope.launch {
            repository.insertar(coche)
        }
    }
}