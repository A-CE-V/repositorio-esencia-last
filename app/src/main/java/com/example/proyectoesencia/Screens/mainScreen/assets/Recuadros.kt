package com.example.proyectoesencia.Screens.mainScreen.assets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
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

@Preview(showBackground = false)
@Composable
fun CrearRecuadroPreview(){
    val imagen = R.drawable.hipatia
    val nombre = R.string.blanca
    val apellido = R.string.a_blanca
    val profesion = R.string.p_blanca
    RectanguloPortrait(imagen,nombre,apellido,profesion)
}

// Sin usar
@Preview(showBackground = false)
@Composable
fun CrearRectanguloPreview(){
    val imagen = R.drawable.hipatia
    val nombre = R.string.blanca
    val apellido = R.string.a_blanca
    val profesion = R.string.p_blanca
    RectanguloLandscape(imagen,nombre,apellido,profesion)
}

@Preview
@Composable
fun CrearMiniRectanguloPreview(){
    MiniRectanguloFiltro(R.string.blanca) { }
}


@Composable
fun RectanguloPortrait(@DrawableRes imagen: Int, @StringRes nombre: Int, @StringRes apellido: Int, @StringRes profesion: Int){
    val profesionString = stringResource(profesion); val profesionCrop: String
    //val width = 180.dp;
    val height = 200.dp
    val nameSize = 23.sp; val surnameSize = 25.sp; val profesionSize = 18.sp
    val characterCropAt = 60


    profesionCrop = if (profesionString.length >= characterCropAt){
        "${profesionString.substring(0,characterCropAt)}..."
    }else{
        profesionString
    }
    val shadowOffSet = Offset(2.0f, 3.0f); val shadowOffSet2 = Offset(1.0f, 2.0f)
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)

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
                    .height(height-60.dp)
            )
            Column(verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp)) {

                if (stringResource(apellido) !="N/A"){
                    Text(
                        text = stringResource(nombre),
                        fontFamily = FontFamily(Font(R.font.nlight)),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = nameSize,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet, blurRadius = 2f)
                        )
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(
                        text = stringResource(apellido),
                        fontFamily = FontFamily(Font(R.font.nheavy)),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = surnameSize,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet2, blurRadius = 2f)
                        )
                    )
                }else{
                    Text(
                        text = stringResource(nombre),
                        fontFamily = FontFamily(Font(R.font.nheavy)),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = nameSize,
                            shadow = Shadow(color = Color.Black, offset = shadowOffSet, blurRadius = 2f)
                        )
                    )
                }
                var paddingBottom = 5.dp
                if (profesionCrop.length <= 35){
                    paddingBottom = 25.dp
                }

                Text(
                    text = profesionCrop,
                    fontFamily = FontFamily(Font(R.font.afacad)),
                    color = Color.White,
                    style = TextStyle(
                        fontSize = profesionSize,
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
fun MiniRectanguloFiltro(@StringRes texto: Int, onClicked: () -> Unit){
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 5.dp,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
            .clickable {
            onClicked()
        }
    ) {
        Text(
            text = stringResource(texto),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            modifier = Modifier.padding(10.dp)
        )
    }
}





// Sin usar

@Composable
fun RectanguloLandscape(@DrawableRes imagen: Int, @StringRes nombre: Int, @StringRes apellido: Int, @StringRes profesion: Int) {
    val profesionString = stringResource(profesion)
    val profesionCrop: String
    val width = 150.dp
    val height = 200.dp
    val nameSize = 23.sp
    val surnameSize = 25.sp
    val profesionSize = 18.sp
    val characterCropAt = 15


    profesionCrop = if (profesionString.length >= characterCropAt) {
        "${profesionString.substring(0, characterCropAt)}..."
    } else {
        profesionString
    }
    val shadowOffSet = Offset(2.0f, 3.0f)
    val shadowOffSet2 = Offset(1.0f, 2.0f)
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)

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
                    .height(height - 50.dp)
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp)
            ) {

                if (stringResource(apellido) != "N/A") {
                    Text(
                        text = stringResource(nombre),
                        fontFamily = FontFamily(Font(R.font.nlight)),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = nameSize,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = shadowOffSet,
                                blurRadius = 2f
                            )
                        )
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(
                        text = stringResource(apellido),
                        fontFamily = FontFamily(Font(R.font.nheavy)),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = surnameSize,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = shadowOffSet2,
                                blurRadius = 2f
                            )
                        )
                    )
                } else {
                    Text(
                        text = stringResource(nombre),
                        fontFamily = FontFamily(Font(R.font.nheavy)),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = nameSize,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = shadowOffSet,
                                blurRadius = 2f
                            )
                        )
                    )
                }
                var paddingBottom = 8.dp
                if (profesionCrop.length <= 35) {
                    paddingBottom = 20.dp
                }

                Text(
                    text = profesionCrop,
                    fontFamily = FontFamily(Font(R.font.afacad)),
                    color = Color.White,
                    style = TextStyle(
                        fontSize = profesionSize,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = shadowOffSet2,
                            blurRadius = 2f
                        )
                    ),
                    modifier = Modifier
                        .paddingFromBaseline(10.dp)
                        .padding(start = 10.dp, end = 10.dp, bottom = paddingBottom)
                )


            }

        }
    }
}