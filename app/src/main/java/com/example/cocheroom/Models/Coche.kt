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
        val marca: String
    )
}