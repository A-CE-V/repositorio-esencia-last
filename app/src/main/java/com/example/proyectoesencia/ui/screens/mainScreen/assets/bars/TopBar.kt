package com.example.proyectoesencia.ui.screens.mainScreen.assets.bars

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.SearchBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.ProyectoESENCIATheme
import com.example.compose.secondaryLight
import com.example.proyectoesencia.R
import com.example.proyectoesencia.navigationManagers.RutasSealed

/*

    Creador original: Salvador
    Modificado por: Adrián


 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, scrollBehavior: TopAppBarScrollBehavior) {
    ProyectoESENCIATheme {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.stem_book_logo_black),
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = { navController.navigate(RutasSealed.SettingsScreen.ruta)
                }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            scrollBehavior = scrollBehavior,
            modifier = Modifier.padding(5.dp).clip(shapes.large)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar(navController: NavController) {
    ProyectoESENCIATheme {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack(RutasSealed.MainScreen.ruta, false)}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.padding(5.dp).clip(shapes.large)
        )
    }

}
