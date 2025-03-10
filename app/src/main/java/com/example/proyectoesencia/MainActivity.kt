package com.example.proyectoesencia

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.ProyectoESENCIATheme
import com.example.proyectoesencia.data.CientificaDao
import com.example.proyectoesencia.navigationManagers.NavigationManager
import com.example.proyectoesencia.navigationManagers.RutasSealed
import com.example.proyectoesencia.ui.screens.mainScreen.PantallaPrincipalVM

@Suppress("DEPRECATION")
class MainActivity: ComponentActivity() {
    private lateinit var navController: NavController
    /*
        Función onCreate, primera función en crearse e iniciarse nada más abrirse la aplicación.
        Implementa la navegación navada más empezar.


     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProyectoESENCIATheme {
                // Implementa la navegación
                navController = rememberNavController()
                val pantallaPrincipalVM: PantallaPrincipalVM = viewModel(factory = PantallaPrincipalVM.factory)
                NavigationManager(navController, pantallaPrincipalVM, RutasSealed.MainScreen.ruta)
            }
        }
    }

    /*
        NOTA ADRI:

            Implementar el resto de estados posibles aqui abajo
     */




}
