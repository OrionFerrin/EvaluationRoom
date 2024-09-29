package com.example.cocheroom

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CocheEntryScreen(viewModel: CocheViewModel) {
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var tipoCoche by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") }
        )
        TextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("Modelo") }
        )
        TextField(
            value = tipoCoche,
            onValueChange = { tipoCoche = it },
            label = { Text("Tipo de Coche") } // Nuevo campo
        )
        TextField(
            value = anio,
            onValueChange = { anio = it },
            label = { Text("Año") }, // Nuevo campo
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            if (marca.isNotBlank() && modelo.isNotBlank()) {
                viewModel.insertarCoche(Coche.Coche(marca = marca, modelo = modelo))
            }
        }) {
            Text("Guardar")
        }
    }
}

class EntryScreen(navController: NavHostController, cocheViewModelFactory: Any) {

}
