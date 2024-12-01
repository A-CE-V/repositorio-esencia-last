package com.example.proyectoesencia.Screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(onBack: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Configuración",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(32.dp))


            Text(text = "Opción 1: Notificaciones")

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Opción 2: Cambiar idioma")

            Spacer(modifier = Modifier.height(32.dp))


            Button(onClick = onBack) {
                Text(text = "Volver")
            }
        }
    }
}
