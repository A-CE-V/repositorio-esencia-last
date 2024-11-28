package com.example.proyectoesencia

import MainScreen.Recuadros
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ProyectoESENCIATheme
import com.example.proyectoesencia.entity.Datos

class PantallaPrincipal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoESENCIATheme {
                AppManager()
            }
        }
    }
}


@Composable
fun MostrarCuadriculaReCuadros(modifier: Modifier){
    val listaMujeres = Datos().listaData
    Surface(modifier = Modifier.fillMaxSize()) {

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

@Preview(showBackground = false)
@Composable
fun RecuadrosPreview(){
    MostrarCuadriculaReCuadros(modifier = Modifier)
}

@Preview(showBackground = false)
@Composable
fun ColumnaPreview(){
    MostrarColumnaRectangulos(modifier = Modifier)
}
@Composable
fun AppManager(){
    MostrarCuadriculaReCuadros(modifier = Modifier)
}

@Preview
@Composable
fun AppManagerPreview(){
    AppManager()
}
