package com.example.proyectoesencia.Screens.ScreensAssets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoesencia.R

class Recuadros {

    @Preview(showBackground = false)
    @Composable
    fun CrearRecuadroPreview(){
        val imagen = R.drawable.hipatia
        val nombre = R.string.blanca
        val apellido = R.string.a_blanca
        val profesion = R.string.p_blanca
        CrearReCuadro(imagen,nombre,apellido,profesion, modifier = Modifier)
    }

    @Preview(showBackground = false)
    @Composable
    fun CrearRectanguloPreview(){
        val imagen = R.drawable.hipatia
        val nombre = R.string.blanca
        val apellido = R.string.a_blanca
        val profesion = R.string.p_blanca
        CrearRectangulo(imagen,nombre,apellido,profesion, modifier = Modifier)
    }


    @Composable
    fun CrearReCuadro(@DrawableRes imagen: Int, @StringRes nombre: Int, @StringRes apellido: Int, @StringRes profesion: Int, modifier: Modifier){
        val profesionString = stringResource(profesion); val profesionCrop: String
        if (profesionString.length >= 60){
            profesionCrop = "${profesionString.substring(0,60)}..."
        }else{
            profesionCrop = profesionString
        }
        val shadowOffSet = Offset(2.0f, 3.0f); val shadowOffSet2 = Offset(1.0f, 2.0f)
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.primaryContainer,
            modifier = modifier
                .width(180.dp)
                .height(100.dp)

        ) {
            Box {
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

                    if (stringResource(apellido) !="N/A"){
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
                    var paddingBottom = 8.dp
                    if (profesionCrop.length <= 35){
                        paddingBottom = 20.dp
                    }


                    Text(
                        text = profesionCrop,
                        fontFamily = FontFamily(Font(R.font.afacad)),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = TextStyle(
                            fontSize = 10.sp,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet2, blurRadius = 2f)
                        ),
                        modifier = Modifier
                            .paddingFromBaseline(10.dp)
                            .padding(start = 10.dp, end = 10.dp, bottom = paddingBottom)
                    )


                }

            }
        }
    }


    @Composable
    fun CrearRectangulo(@DrawableRes imagen: Int, @StringRes nombre: Int, @StringRes apellido: Int, @StringRes profesion: Int, modifier: Modifier){
        val profesionString = stringResource(profesion); val profesionCrop: String
        if (profesionString.length >= 60){
            profesionCrop = "${profesionString.substring(0,60)}..."
        }else{
            profesionCrop = profesionString
        }
        val shadowOffSet = Offset(2.0f, 3.0f); val shadowOffSet2 = Offset(1.0f, 2.0f)
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.primaryContainer,
            modifier = modifier
                .width(250.dp)
                .height(100.dp)

        ) {
            Box {
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

                    if (stringResource(apellido) !="N/A"){
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
                    var paddingBottom = 8.dp
                    if (profesionCrop.length <= 35){
                        paddingBottom = 20.dp
                    }


                    Text(
                        text = profesionCrop,
                        fontFamily = FontFamily(Font(R.font.afacad)),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = TextStyle(
                            fontSize = 10.sp,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet2, blurRadius = 2f)
                        ),
                        modifier = Modifier
                            .paddingFromBaseline(10.dp)
                            .padding(start = 10.dp, end = 10.dp, bottom = paddingBottom)
                    )


                }

            }
        }
    }
}