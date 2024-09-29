package com.example.cocheroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos la base de datos y el repositorio
        val database = CocheDatabase.getDatabase(this)
        val repository = CocheRepository(database.cocheDao())

        // Creamos el ViewModelFactory
        val cocheViewModelFactory = CocheViewModel(repository)

        setContent {
            CocheAppTheme {
                // Pasamos el ViewModelFactory a MyApp
                MyApp(cocheViewModelFactory)
            }
        }
    }
}
@Composable
fun MyApp(cocheViewModelFactory: CocheViewModel) {
    val navController: NavHostController = rememberNavController()

    // Pasamos el ViewModelFactory a las composables
    NavHost(navController = navController, startDestination = "pantalla_ingreso") {
        composable("pantalla_ingreso") {
            EntryScreen(navController = navController, cocheViewModelFactory = CocheViewModelFactory)
        }
        composable("pantalla_consulta") {
            ListScreen(cocheViewModelFactory = cocheViewModelFactory)
        }
    }
}

