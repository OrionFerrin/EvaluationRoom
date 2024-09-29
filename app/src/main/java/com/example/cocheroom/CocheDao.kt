package com.example.cocheroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface CocheDao {
    abstract fun insert(coche: Coche)
    abstract fun getAllCoches(): Flow<List<Coche>>

    @Dao
    interface CocheDao {
        @Insert
        suspend fun insert(coche: Coche)

        @Query("SELECT * FROM coche_table")
        fun getAllCoches(): Flow<List<Coche>>
    }
}