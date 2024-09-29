package com.example.cocheroom

import androidx.room.Entity
import androidx.room.PrimaryKey

class Coche {
    val modelo: String = ""
    val marca: String = ""

    @Entity(tableName = "coche_table")
    data class Coche(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val modelo: String,
        val marca: String,
        val tipoCoche: String, //Tipo de coche (ej. "SUV", "Sedán", etc.)
        val anio: Int
    )

    companion object {
        fun Coche(marca: String, modelo: String): Coche.Coche {

        }
    }
}