//Esta pantalla muestra información detallada de la científica seleccionada.

package com.example.proyectoesencia.ui.screens.mainScreen.detalilScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoesencia.R
import com.example.proyectoesencia.data.CientificaSchedule
import com.example.proyectoesencia.ui.screens.mainScreen.PantallaPrincipalState
import com.example.proyectoesencia.ui.screens.mainScreen.PantallaPrincipalVM
import com.example.proyectoesencia.ui.screens.mainScreen.assets.bars.BackTopBar


/*

    Pantalla dedicada a mostrar los detalles de las científicas por pantalla una vez
    fueron clickeadas.

    La variable nombre, sirve para poder mostrar el título en la TopBar de la mujer que está siendo
    vista


 */

@Composable
fun DetalleCientificaScreen(navController: NavController, viewModel: PantallaPrincipalVM) {
    val estadoViewModel = viewModel.cientificasState.collectAsState()
    val tablaCompleta by viewModel.getScheduleFor(estadoViewModel.value.id).collectAsState(emptyList())
    Scaffold(
        topBar = { BackTopBar(navController) }
    ) { paddingValues ->
        ColumnaCientifica(paddingValues, estadoViewModel, tablaCompleta)
    }
}

@Composable
fun ColumnaCientifica(paddingValues: PaddingValues, cientificaState: State<PantallaPrincipalState>, tabla: List<CientificaSchedule>){
    LazyColumn(
        contentPadding = paddingValues
    ) {
        items(
            items = tabla,
            key = {schedule -> schedule.id}
        ){ schedule ->
            Card(modifier = Modifier.fillMaxWidth().height(300.dp).padding(15.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = schedule.nombre,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier.fillMaxWidth()
                    )
                    HorizontalDivider(Modifier.padding(bottom = 10.dp))
                    Text(
                        text = schedule.biografia,
                        textAlign = TextAlign.Justify,
                        style = MaterialTheme.typography.bodySmall
                    )

                }
            }
        }
    }

}