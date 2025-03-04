package com.example.proyectoesencia.ui.screens.creditScreen

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoesencia.R
import kotlinx.coroutines.launch

@Composable
fun CreditScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C1F37))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 48.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.stem_book),
                contentDescription = "Imagen del logo",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Titulo Principal
        Text(
            text = "CRÉDITOS",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF60A5FA),
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Subtitulo
        Text(
            text = "Equipo de Desarrollo",
            fontSize = 24.sp,
            color = Color(0xFF93C5FD),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Nuestras tarjetas VAMONOSSSSS
        DeveloperCard(
            nombre = "Adrian Castillo Vega",
            rol = "EL LIDL",
            descripcion = "La vida es dura, pero mas dura, es mi android studio",
            colorNombre = Color(0xFF34D399),
            imageResId = R.drawable.lidl
        )

        Spacer(modifier = Modifier.height(16.dp))

        DeveloperCard(
            nombre = "Salvador Mora Millan",
            rol = "Desarrollador Bald",
            descripcion = "Lo que decida Santi Bald",
            colorNombre = Color(0xFFFACC15),
            imageResId = R.drawable.salvador
        )

        Spacer(modifier = Modifier.height(16.dp))

        DeveloperCard(
            nombre = "Daniel Rivas",
            rol = "Desarrollador",
            descripcion = "Lo que decida Dabi",
            colorNombre = Color(0xFFA78BFA),
            imageResId = R.drawable.daniel
        )

        Spacer(modifier = Modifier.height(16.dp))

        DeveloperCard(
            nombre = "Yaroslav Horuk",
            rol = "Desarrollador Support",
            descripcion = "",
            colorNombre = Color(0xFFF472B6),
            imageResId = R.drawable.sup_prime
        )

        Spacer(modifier = Modifier.weight(1f))

        // Piececito da pagina
        Divider(
            color = Color(0xFF374151),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text(
            text = "© 2025 STEM Book",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Text(
            text = "Versión 1.3.0",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun DeveloperCard(
    nombre: String,
    rol: String,
    descripcion: String,
    colorNombre: Color,
    imageResId: Int
) {
    // Usar Animatable para controlar la rotación con animaciones
    val rotationState = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clickable {
                // Al hacer clic, lanzar una corrutina para animar la rotación
                coroutineScope.launch {
                    rotationState.animateTo(
                        targetValue = rotationState.value + 5400f,
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D3748)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Fotos Nuestras
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Foto de $nombre",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .rotate(rotationState.value),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Esto pertenece a nuestra info compis
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = nombre,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorNombre
                )

                Text(
                    text = rol,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Text(
                    text = descripcion,
                    fontSize = 14.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}
