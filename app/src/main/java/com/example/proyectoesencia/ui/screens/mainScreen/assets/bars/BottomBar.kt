package com.example.pruebasesencia

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.compose.ProyectoESENCIATheme
import com.example.proyectoesencia.navigationManagers.RutasSealed

/*

     Composable de la barra de navegación inferior de la pantalla principal

     Creador original: Yaris
     Modificado por: Adrián


 */

@Composable
fun BottomBar(navController: NavController) {
    ProyectoESENCIATheme {
        NavigationBar{
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = borderOrFilledIcon(1, navController, RutasSealed.MainScreen.ruta),
                        contentDescription = null
                    )
                },
                label = { Text("Inicio") },
                alwaysShowLabel = false,// Hard Code
                selected = comprobarDestino(navController = navController, RutasSealed.MainScreen.ruta),
                onClick = { navController.navigate(RutasSealed.MainScreen.ruta) }
            )


            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = borderOrFilledIcon(2, navController, RutasSealed.ProfileScreen.ruta),
                        contentDescription = null
                    )
                },
                label = { Text("Perfil") }, // Hard Code
                selected = comprobarDestino(navController = navController, RutasSealed.ProfileScreen.ruta),
                onClick = {navController.navigate(RutasSealed.ProfileScreen.ruta)}
            )

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = borderOrFilledIcon(3, navController, RutasSealed.MoreScreen.ruta),
                        contentDescription = null
                    )
                },
                label = { Text("Más") }, // Hard Code
                selected = comprobarDestino(navController = navController, RutasSealed.MoreScreen.ruta),
                onClick = {navController.navigate(RutasSealed.MoreScreen.ruta)}
            )
        }
    }

}

@Composable
fun borderOrFilledIcon(current: Int, navController: NavController, ruta: String): ImageVector{
    return when(current){
        1 -> if (comprobarDestino(navController, ruta)){Icons.Default.Home}else{Icons.Sharp.Home}
        2 -> if (comprobarDestino(navController, ruta)){Icons.Default.Person}else{Icons.Sharp.Person}
        3 -> if (comprobarDestino(navController, ruta)){Icons.Default.Menu}else{ Icons.Sharp.Menu}
        else -> Icons.Default.Build
    }
}

@Composable
fun comprobarDestino(navController: NavController, ruta: String):Boolean{
    //Para poder crear esta variable, he tenido que utilizar la IA, porque si no era imposible saber cual era la ruta actual
    val currentDestination = navController.currentBackStackEntry?.destination?.route
    return currentDestination == ruta
}

@Composable
fun AntiguaBottomBar(navController: NavController) {
    ProyectoESENCIATheme {
        NavigationBar{
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = null
                    )
                },
                label = { Text("Inicio") }, // Hard Code
                selected = comprobarDestino(navController = navController, RutasSealed.MainScreen.ruta),
                onClick = { navController.navigate(RutasSealed.MainScreen.ruta) }
            )


            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = null
                    )
                },
                label = { Text("Perfil") }, // Hard Code
                selected = comprobarDestino(navController = navController, RutasSealed.ProfileScreen.ruta),
                onClick = {navController.navigate(RutasSealed.ProfileScreen.ruta)}
            )

            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = null
                    )
                },
                label = { Text("Más") }, // Hard Code
                selected = comprobarDestino(navController = navController, RutasSealed.MoreScreen.ruta),
                onClick = {navController.navigate(RutasSealed.MoreScreen.ruta)}
            )
        }
    }

}