package com.example.proyectoesencia.Screens.ScreensAssets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.secondaryLight

class Toolbar {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppToolbar(navController: NavController) {
        val colorIconos = Color.White; val colorTexto = colorIconos
        val colorFondo = secondaryLight


        CenterAlignedTopAppBar(
            title = {},
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        tint = colorIconos,
                        contentDescription = "Buscar"
                    )
                }
                IconButton(onClick = {
                    navController.navigate("settings")
                }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        tint = colorIconos,
                        contentDescription = "Configuración"
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = colorFondo,
                titleContentColor = colorTexto
            )
        )
    }

    @Preview
    @Composable
    fun ToolBarPreview(){
        val navController = rememberNavController()
        AppToolbar(navController)
    }

}