package com.example.proyectoesencia.navigationManagers

import AppLogoIntro
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.ProyectoESENCIATheme
import com.example.proyectoesencia.ui.screens.firstScreen.AppManagerMainScreenButton
import com.example.proyectoesencia.ui.screens.mainScreen.AppManagerPP
import com.example.proyectoesencia.ui.screens.mainScreen.PantallaPrincipalVM
import com.example.proyectoesencia.ui.screens.mainScreen.detalilScreen.DetalleCientificaScreen
import com.example.proyectoesencia.ui.screens.profileScreen.ProfileScreen
import com.example.proyectoesencia.ui.screens.settingsScreen.SettingsScreen

@Composable
fun NavigationManager(
    navController: NavController,
    pantallaPrincipalVM: PantallaPrincipalVM,
    startDestination: String

) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = startDestination
    ) {
        composable(RutasSealed.FirstScreen.ruta) {
            AppManagerMainScreenButton(navController)
        }
        composable(RutasSealed.MainScreen.ruta) {
            ProyectoESENCIATheme {
                AppManagerPP(navController, pantallaPrincipalVM)
            }
        }
        composable(RutasSealed.DetailScreen.ruta){
            ProyectoESENCIATheme {
                DetalleCientificaScreen(navController, pantallaPrincipalVM)
            }
        }
        composable(RutasSealed.IntroScreen.ruta) {
            AppLogoIntro(navController)
        }
        composable(RutasSealed.SettingsScreen.ruta) {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
        composable(RutasSealed.ProfileScreen.ruta) {
            ProfileScreen(navController, pantallaPrincipalVM)
        }

    }
}