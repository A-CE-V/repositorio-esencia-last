package com.example.proyectoesencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose.ProyectoESENCIATheme
import com.example.proyectoesencia.NavigationClasses.StartNavigation

class MainActivity: ComponentActivity() {

    /*
        Función onCreate, primera función en crearse e iniciarse nada más abrirse la aplicación.
        Implementa la navegación navada más empezar.


     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoESENCIATheme {
                // Implementa la navegación
                StartNavigation()
            }
        }
    }

    /*
        NOTA ADRI:

            Implementar el resto de estados posibles aqui abajo
     */




}
