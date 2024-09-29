package com.example.cocheroom

import kotlinx.coroutines.flow.Flow

class CocheRepository(private val cocheDao: CocheDao) {

    val coches: Flow<List<Coche>> = cocheDao.getAllCoches()

    suspend fun insertar(coche: Coche) {
        cocheDao.insert(coche)
    }

    fun getAllCoches(): Flow<List<Coche>> {

    }

    fun insert(coche: Coche.Coche) {
        TODO("Not yet implemented")
    }
}