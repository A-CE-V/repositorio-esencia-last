package com.example.proyectoesencia.Screens.mainScreen.assets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.android.material.search.SearchBar

@Composable
fun FloatingSearchButton(onClickFunction: () -> Unit){
    SmallFloatingActionButton(
        onClick = {onClickFunction()},
        elevation = FloatingActionButtonDefaults.elevation(10.dp)
    ) {
        Icon(Icons.Filled.Search, null)
    }
}

// Implementar la search bar
