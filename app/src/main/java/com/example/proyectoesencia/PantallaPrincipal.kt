package com.example.proyectoesencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ProyectoESENCIATheme

class PantallaPrincipal : ComponentActivity() {
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
/*

OLD
@Composable
fun CrearReCuadro( @DrawableRes imagen: Int,  @StringRes nombre: Int,  modifier: Modifier){
    val datos = AsociacionDatos()
    val listaDatos = datos.getTodosLosDatosStringsDe(nombre)
    val apellido = listaDatos.get(0); val cita = listaDatos.get(2)
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = modifier
            .width(150.dp)
            .height(150.dp)
    ) {

        val offset = Offset(2.0f, 5.0f)
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .paint(
                    painter = painterResource(imagen)
                )) {
            Image(
                painter = painterResource(imagen),
                contentDescription = null
            )

            Text(
                text = stringResource(nombre),
                fontFamily = FontFamily(Font(R.font.nlight)),
                color = MaterialTheme.colorScheme.onPrimary,
                style = TextStyle(
                    fontSize = 23.sp,
                    shadow = Shadow(color = Color.Black, offset = offset, blurRadius = 2f)
                ),
                modifier = Modifier
                    .paddingFromBaseline(5.dp)
                    .padding(horizontal = 5.dp)
            )


        }
    }

}
*/

@Composable
fun CrearReCuadro(@DrawableRes imagen: Int, @StringRes nombre: Int, modifier: Modifier){
    val listaDatos = AsociacionDatos().getTodosLosDatosStringsDe(nombre)
    val apellido = listaDatos[0]; val cita = stringResource(listaDatos[2])
    val citaCrop = "\"${cita.substring(0,50)}...\""
    val shadowOffSet = Offset(2.0f, 3.0f); val shadowOffSet2 = Offset(1.0f, 2.0f)
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = modifier
            .width(180.dp)
            .height(100.dp)

    ) {
        Box(){
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .blur(15.dp)

            )
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
            )
            Column(verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp)) {

                if (stringResource(apellido)!="N/A"){
                    Text(
                        text = stringResource(nombre),
                        fontFamily = FontFamily(Font(R.font.nlight)),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = TextStyle(
                            fontSize = 15.sp,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet, blurRadius = 2f)
                        )
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(
                        text = stringResource(apellido),
                        fontFamily = FontFamily(Font(R.font.nheavy)),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = TextStyle(
                            fontSize = 17.sp,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet2, blurRadius = 2f)
                        )
                    )
                }else{
                    Text(
                        text = stringResource(nombre),
                        fontFamily = FontFamily(Font(R.font.nheavy)),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = TextStyle(
                            fontSize = 17.sp,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet, blurRadius = 2f)
                        )
                    )
                }

                Text(
                    text = citaCrop,
                    fontFamily = FontFamily(Font(R.font.afacad)),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontSize = 10.sp,
                        shadow = Shadow(color = Color.Black, offset = shadowOffSet2, blurRadius = 2f)
                    ),
                    modifier = Modifier
                        .paddingFromBaseline(10.dp)
                        .padding(start = 10.dp, end = 10.dp, bottom = 8.dp)
                )


            }

        }
    }
}

@Preview(showBackground = false)
@Composable
fun CrearRecuadroPreview(){
    val imagen = R.drawable.hipatia
    val nombre = R.string.blanca
    CrearReCuadro(imagen,nombre, modifier = Modifier)
}


@Composable
fun MostrarCuadriculaReCuadros(modifier: Modifier){
    val listaMujeres = listOf("maria_juana","blanca","valentina","hipatia","sofia")
    val mapasImagenesNombres = AsociacionDatos().imagenesData
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .height(168.dp)
                .padding(10.dp)) {
                    items(mapasImagenesNombres) { entry ->
                        CrearReCuadro(entry.imagen, entry.nombre, Modifier)
                    }
        }
    }


}

@Preview(showBackground = false)
@Composable
fun RecuadrosPreview(){
    MostrarCuadriculaReCuadros(modifier = Modifier)
}

