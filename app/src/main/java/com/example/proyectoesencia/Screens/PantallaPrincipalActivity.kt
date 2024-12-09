package com.example.proyectoesencia.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
import com.example.compose.surfaceLight
import com.example.proyectoesencia.Screens.ScreensAssets.Toolbar


@Composable
fun AppManagerPP(navController: NavController) {
    Scaffold(
        topBar = { Toolbar().AppToolbar(navController) }
    ) { paddingValues ->
        AppMainScreenManager(paddingValues)
    }
}


@Composable
fun AppMainScreenManager(paddingValues: PaddingValues) {
    val colorDelFondo = surfaceLight
    Surface(
        color = colorDelFondo,
        modifier = Modifier
            .fillMaxSize()
    ) {
        MostrarCuadriculaReCuadros(paddingValues)
    }

}

@Composable
fun MostrarCuadriculaReCuadros(paddingValues: PaddingValues) {
    val listaMujeres = Datos().listaData
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(paddingValues)
    ) {
        items(listaMujeres){ lista ->
            Recuadros().RectanguloPortrait(lista.imagenPortada,lista.nombre,lista.apellido,lista.profesion)
        }
    }

}


// La idea es que esta función
// Sólo funcionará cuando se gire el dispositivo móvil
@Composable
fun MostrarColumnaRectangulos(modifier: Modifier){
    val listaMujeres = Datos().listaData
    Surface(modifier = Modifier.fillMaxSize()) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.fillMaxHeight()) {
            items(listaMujeres){ lista ->
                Recuadros().RectanguloLandscape(lista.imagenPortada,lista.nombre,lista.apellido,lista.profesion)
            }
        }

    }
}

/*



                     PREVIEWS DE LA PANTALLA PRINCIPAL DE LA APLICACIÓN:





 */

// Esta preview hace que se muestre la columna de cuadros
@Preview(showBackground = false)
@Composable
fun ColumnaPreview(){
    MostrarColumnaRectangulos(modifier = Modifier)
}
