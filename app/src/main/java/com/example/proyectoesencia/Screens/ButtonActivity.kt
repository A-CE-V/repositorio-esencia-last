package com.example.proyectoesencia.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.ProyectoESENCIATheme
import com.example.compose.onTertiaryContainerLight
import com.example.compose.onTertiaryLight
import com.example.compose.tertiaryContainerLight
import com.example.compose.tertiaryLight
import com.example.proyectoesencia.R

/*

SIN UTILIZAR


class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoESENCIATheme {
                AppManagerButton()
            }
        }
    }
}
*/
// Funcion encargada de re-escalar la pantalla de bienvenida


@Composable
fun AppManagerMainScreenButton(navController: NavController){
    AppManagerButton(navController)
}

@Composable
fun AppManagerButton(navController: NavController,modifier: Modifier = Modifier){
    Surface(modifier) {
        PantallaBienvenida(navController,modifier)
    }

}






// Función pantalla bienvenida

@Composable
fun PantallaBienvenida(navController: NavController,modifier: Modifier){
    val colorTexto = Color.White
    val colorBackgroundBoton = tertiaryLight


    Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier.fillMaxSize().fillMaxHeight()) {
        Image(
            painter = painterResource(R.drawable.wallpaper),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.blur(10.dp)
        )

        Box(modifier = modifier.fillMaxSize()){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .shadow(10.dp, shape = MaterialTheme.shapes.medium)) {
                Image(
                    painter = painterResource(R.drawable.stem_book),
                    contentDescription = null
                )

                // Muestra el siguiente texto:
                Text(
                    text = stringResource(R.string.text_bienvenida),
                    textAlign = TextAlign.Center,
                    color = colorTexto,
                    modifier = Modifier
                        .padding(20.dp))

                Button(
                    modifier = Modifier.fillMaxWidth().padding( horizontal = 80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorBackgroundBoton),
                    onClick = {
                        navController.navigate("main")
                    }
                ) {
                    Text(
                        text = stringResource(R.string.btn_bienvendia_text),
                        color = colorTexto
                    )
                }


            }
        }
    }


}
//Muestra el preview de la pantalla de bienvenida

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun PreviewPantallaBienvenida() {
    val navController = rememberNavController()
    ProyectoESENCIATheme {
        PantallaBienvenida(navController,Modifier)
    }
}

//Muestra el preview de la pantalla de bienvenida al completo


@Preview
@Composable
fun PreviewPantalla(){
    val navController = rememberNavController()
    ProyectoESENCIATheme {
        AppManagerButton(navController,Modifier.fillMaxSize())
    }
}