package com.example.cocheroom

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
    fun CocheListScreen(cocheViewModel: CocheViewModel = viewModel()) {
        // Observar los datos de la base de datos
        val coches by cocheViewModel.allCoches.collectAsState(initial = emptyList())

        Column(modifier = Modifier.padding(16.dp)) {
            Text("Lista de Coches", style = MaterialTheme.typography.h6)

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar la lista de coches
            LazyColumn {
                items(coches) { coche ->
                    CocheItem(coche)
                }
            }
        }
    }

    @Composable
    fun CocheItem(coche: Coche) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = 4.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Marca: ${coche.marca}")
                Text("Modelo: ${coche.modelo}")
            }
        }
    }

fun Card(modifier: Modifier, elevation: Dp, content: @Composable() (ColumnScope.() -> Unit)) {
    TODO("Not yet implemented")
}

class ListScreen(cocheViewModelFactory: CocheViewModelFactory) {

}
