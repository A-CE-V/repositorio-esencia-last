package com.example.proyectoesencia.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoesencia.Screens.ScreensAssets.Recuadros
import com.example.proyectoesencia.Screens.entity.model.Datos
import androidx.compose.material3.*
/*
class PantallaPrincipalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoESENCIATheme {
                AppManagerPP()
            }
        }
    }
}
*/


@Composable
fun AppManagerPP(navController: NavController) {
    Scaffold(
        topBar = { AppToolbar(navController) }
    ) { paddingValues ->
        AppMainScreenManager(modifier = Modifier.padding(paddingValues))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(navController: NavController) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Sprint 1") },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            }
            IconButton(onClick = {
                navController.navigate("settings")
            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Configuración"
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
fun AppMainScreenManager(modifier: Modifier) {
    MostrarCuadriculaReCuadros(modifier = modifier)
}



@Composable
fun MostrarCuadriculaReCuadros(modifier: Modifier){
    val listaMujeres = Datos().listaData
    Surface(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.fillMaxSize()) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.fillMaxHeight()) {
                items(listaMujeres){ item ->
                    Recuadros().CrearReCuadro(item.imagenPortada,item.nombre,item.apellido,item.profesion,modifier)
                }
        }

    }
}
// La idea es que esta función
// Sólo funcionará cuando se gire el dispositivo móvil
@Composable
fun MostrarColumnaRectangulos(modifier: Modifier){
    val listaMujeres = Datos().listaData
    Surface(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxHeight().fillMaxWidth()) {
            items(listaMujeres){ item ->
                Recuadros().CrearRectangulo(item.imagenPortada,item.nombre,item.apellido,item.profesion,modifier)
            }
        }

    }
}

/*

    PREVIEWS DE LA PANTALLA PRINCIPAL DE LA APLICACIÓN:


 */

// Esta preview hace que se muestre la cuadricula / tabla de cuadraddos

@Preview(showBackground = false)
@Composable
fun RecuadrosPreview(){
    MostrarCuadriculaReCuadros(modifier = Modifier)
}

// Esta preview hace que se muestre la columna de cuadros
@Preview(showBackground = false)
@Composable
fun ColumnaPreview(){
    MostrarColumnaRectangulos(modifier = Modifier)
}

// Esta preview muestra toda la app
@Preview
@Composable
fun AppManagerPreview(){
    AppMainScreenManager(
        modifier = TODO()
    )
}
