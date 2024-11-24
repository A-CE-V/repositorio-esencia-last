package com.example.proyectoesencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ProyectoESENCIATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoESENCIATheme {
                AppManager(Modifier.fillMaxSize())
            }
        }
    }
}

// Funcion encargada de re-escalar la pantalla de bienvenida


@Composable
fun AppManager(modifier: Modifier = Modifier){
    Surface(modifier) {
        PantallaBienvenida()
    }

}

// Función pantalla bienvenida

@Composable
fun PantallaBienvenida(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        // Muestra el siguiente texto:
        Text(stringResource(R.string.text_bienvenida))

        // Muestra un botón con el texto "Empezar" pero no hace nada
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = {}
        ) {
            Text(stringResource(R.string.btn_bienvendia_text))
        }
    }

}
//Muestra el preview de la pantalla de bienvenida

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun PreviewPantallaBienvenida() {
    ProyectoESENCIATheme {
        PantallaBienvenida()
    }
}

//Muestra el preview de la pantalla de bienvenida al completo


@Preview
@Composable
fun PreviewPantalla(){
    ProyectoESENCIATheme {
        AppManager(Modifier.fillMaxSize())
    }
}