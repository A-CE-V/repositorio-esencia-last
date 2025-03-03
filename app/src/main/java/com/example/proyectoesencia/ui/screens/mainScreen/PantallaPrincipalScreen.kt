package com.example.proyectoesencia.ui.screens.mainScreen

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.surfaceLight
import com.example.proyectoesencia.data.CientificaSchedule
import com.example.proyectoesencia.navigationManagers.RutasSealed
import com.example.proyectoesencia.ui.screens.mainScreen.assets.MiniRectanguloFiltro
import com.example.proyectoesencia.ui.screens.mainScreen.assets.NoneFilter
import com.example.proyectoesencia.ui.screens.mainScreen.assets.RectanguloPortrait
import com.example.proyectoesencia.ui.screens.mainScreen.assets.ShowLoader
import com.example.proyectoesencia.ui.screens.mainScreen.assets.bars.TopBar
import com.example.proyectoesencia.zzzdeprecated.aStaticAppData.listaTodosLosFiltros
import com.example.pruebasesencia.BottomBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppManagerPP(navController: NavController, viewModel: PantallaPrincipalVM) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(); val tablaCompleta by viewModel.getFullSchedule().collectAsState(emptyList())
    val estado = viewModel.cientificasState.collectAsState()


    if (tablaCompleta.isEmpty()){
        ShowLoader()
    }else{
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = { TopBar(navController, scrollBehavior = scrollBehavior) },
            bottomBar = { BottomBar(navController)}
        ) { paddingValues ->
            AppMainScreenManager(paddingValues, navController, tablaCompleta, viewModel::updateState, viewModel::updateSelectedFilter, estado.value.filter)
        }
    }

}


@Composable
fun AppMainScreenManager(paddingValues: PaddingValues, navController: NavController, schedule: List<CientificaSchedule>, updateID: (Int) -> Unit, updateFilter: (String) -> Unit, currentFilter: String) {
    Column(
        Modifier.fillMaxSize().padding(paddingValues)
    ){
        MostrarRowFiltros(currentFilter, updateFilter)
        MostrarColumnaMain(paddingValues, navController, schedule, updateID, currentFilter)
    }
}


@Composable
fun MostrarColumnaMain(paddingValues: PaddingValues, navController: NavController, schedule: List<CientificaSchedule>, updateID: (Int) -> Unit, currentFilter: String){
    Column(Modifier.verticalScroll(rememberScrollState())) {
        schedule.forEach{ item->
            if (item.profesiones.lowercase().contains(currentFilter.lowercase())) {
                RectanguloPortrait(item.nombre, item.apellidos, item.profesiones) {
                    updateID(item.id)
                    navController.navigate(RutasSealed.DetailScreen.ruta)
                }
            }
        }
    }
}

@Composable
fun MostrarRowFiltros(currentFilter: String, updateFilter: (String) -> Unit){
    Row(Modifier.horizontalScroll(rememberScrollState()).padding(vertical = 2.dp, horizontal = 4.dp)){
        NoneFilter(currentFilter) { updateFilter("") }
        listaTodosLosFiltros.forEach { item ->
           // val itemToText = stringResource(item.filtro)
            MiniRectanguloFiltro(item,currentFilter){updateFilter(item)}
        }
    }
}



// La idea es que esta función
// Sólo funcionará cuando se gire el dispositivo móvil
/*

@Composable
fun MostrarColumnaRectangulos(modifier: Modifier){
    val listaMujeres = listaData
    Surface(modifier = Modifier.fillMaxSize()) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.fillMaxHeight()) {
            items(listaMujeres){ lista ->
                RectanguloLandscape(lista.imagenPortada,lista.nombre,lista.apellido,lista.profesion)
            }
        }

    }
}





                     PREVIEWS DE LA PANTALLA PRINCIPAL DE LA APLICACIÓN:





 */

// Esta preview hace que se muestre la columna de cuadros
@Preview(showBackground = false)
@Composable
fun ColumnaPreview(){
    //MostrarColumnaRectangulos(modifier = Modifier)
}

