package com.example.cocheroom

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch


@Composable
fun EntryScreen(
    navController: NavHostController,
    cocheViewModelFactory: CocheViewModelFactory
) {
    // Crear el ViewModel con el ViewModelFactory
    val cocheViewModel: CocheViewModel = viewModel(factory = cocheViewModelFactory)

    // Variables para las propiedades
    var propiedadUno by remember { mutableStateOf("") }
    var propiedadDos by remember { mutableStateOf("") }
    var propiedadTres by remember { mutableStateOf("") }
    var propiedadCuatro by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Mostrar tu nombre y apellido (estático)
        Text(text = "Nombre: Xavier H. Arroyo Ferrin", style = TextStyle.Default)

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el nombre de la entidad
        Text(text = "Entidad: Coche", style = TextStyle.Default)

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el nivel y paralelo
        Text(text = "Nivel y Paralelo: 7 B", style = TextStyle.Default)

        Spacer(modifier = Modifier.height(16.dp))

        // Campos de propiedades del libro
        TextField(
            value = propiedadUno,
            onValueChange = { propiedadUno = it },
            label = { Text("Propiedad Uno") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = propiedadDos,
            onValueChange = { propiedadDos = it },
            label = { Text("Propiedad Dos") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = propiedadTres,
            onValueChange = { propiedadTres = it },
            label = { Text("Propiedad Tres") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = propiedadCuatro,
            onValueChange = { propiedadCuatro = it },
            label = { Text("Propiedad Cuatro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para crear la entrada del libro
        Button(onClick = {
            scope.launch {
                cocheViewModel.insertarCoche(
                    Coche(
                        propiedadUno = propiedadUno,
                        propiedadDos = propiedadDos,
                        propiedadTres = propiedadTres,
                        propiedadCuatro = propiedadCuatro
                    )
                )
            }
        }) {
            Text("CREAR")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para navegar a la pantalla de consulta
        Button(onClick = {
            navController.navigate("pantalla_consulta")
        }) {
            Text("Ver el listado de registros")
        }
    }
}
