package com.example.cocheroom

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
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
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var tipoCoche by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }

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

        // Campos de atributos de los coches
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

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para ingresar un coche
        Button(onClick = {
            scope.launch {
                cocheViewModel.insertarCoche(
                    Coche(
                        modelo = modelo,
                        marca = marca,
                        tipoCoche = tipoCoche,
                        anio = anio
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
