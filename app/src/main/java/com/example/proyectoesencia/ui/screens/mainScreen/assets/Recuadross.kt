package com.example.proyectoesencia.ui.screens.mainScreen.assets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.compose.ProyectoESENCIATheme
import com.example.proyectoesencia.R
import com.example.proyectoesencia.ui.screens.mainScreen.PantallaPrincipalVM
import com.example.proyectoesencia.ui.screens.mainScreen.assets.tools.calculatePadding
import com.example.proyectoesencia.ui.screens.mainScreen.assets.tools.cropTheTextAt
import com.example.proyectoesencia.ui.screens.mainScreen.assets.tools.findImageByName
import org.jetbrains.annotations.ApiStatus.NonExtendable

@Preview(showBackground = false)
@Composable
fun NamesPreview(){
    val nombre = "Hipatía"
    val apellido = "Catalán"
    val nameSize = 28.sp; val surnameSize = 30.sp; val profesionSize = 20.sp
    val shadowOffSet = Offset(2.0f, 3.0f); val shadowOffSet2 = Offset(1.0f, 2.0f)
    InformacionCientificaTexts(nombre, apellido, nameSize, shadowOffSet, surnameSize, shadowOffSet2)
}


@Composable
fun RectanguloPortrait(id: Int, nombre: String, apellido: String, profesion: String, onClicked: () -> Unit, viewModel: PantallaPrincipalVM){
    //val width = 180.dp
    val imagen = findImageByName(nombre, apellido)
    val height = 290.dp; val nameSize = 28.sp; val surnameSize = 30.sp; val profesionSize = 20.sp
    val characterCropAt = 70; val gradiente = listOf(colorScheme.surface, colorScheme.primaryContainer, colorScheme.secondaryContainer)
    val shape = shapes.extraLarge
    val profesionCrop = cropTheTextAt(profesion, characterCropAt); val paddingBottom = calculatePadding(profesionCrop)
    val shadowOffSet = Offset(2.0f, 3.0f); val shadowOffSet2 = Offset(1.0f, 2.0f)
    val meGusta by viewModel.getMeGustaFlow(id).collectAsState(initial = 0)

    Surface(
        shape = shape,
        border = BorderStroke(5.dp, Brush.linearGradient(gradiente.shuffled())),
        tonalElevation = 3.dp,
        shadowElevation = 3.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable { onClicked() }
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .blur(40.dp)
                    .fillMaxHeight()
            )
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height-85.dp)
            )
            FavButton(
                Icon = if (meGusta == 1) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 30.dp, end = 20.dp),
                onClickFunction = { viewModel.meGusta(id) }
            )
            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {

                InformacionCientificaTexts(nombre, apellido, nameSize, shadowOffSet, surnameSize, shadowOffSet2)
                ProfesionText(profesionCrop, profesionSize, shadowOffSet2, paddingBottom)

            }
        }
    }
}

@Composable
fun InformacionCientificaTexts(nombre: String, apellido: String, nameSize: TextUnit, shadowOffSet: Offset, surnameSize: TextUnit, shadowOffSet2: Offset){
    if (apellido !="N/A"){
        Column {
            Text(
                text = nombre,
                fontFamily = FontFamily(Font(R.font.afacad)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = TextStyle(
                    fontSize = nameSize,
                    shadow = Shadow(color = Color.Black, offset = shadowOffSet, blurRadius = 2f)
                )
            )
            //Spacer(modifier = Modifier.padding(horizontal = 3.dp))
            Text(
                text = apellido,
                fontFamily = FontFamily(Font(R.font.nheavy)),
                color = Color.White,
                style = TextStyle(
                    fontSize = surnameSize,
                    shadow = Shadow(color = Color.Black, offset = shadowOffSet2, blurRadius = 2f)
                )
            )
        }

    }else{
        Text(
            text = nombre,
            fontFamily = FontFamily(Font(R.font.nheavy)),
            color = Color.White,
            style = TextStyle(
                fontSize = nameSize,
                shadow = Shadow(color = Color.Black, offset = shadowOffSet, blurRadius = 2f)
            )
        )
    }
}

@Composable
fun ProfesionText(profesionCrop: String, profesionSize: TextUnit, shadowOffSet2: Offset, paddingBottom: Dp){
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
            .fillMaxWidth()
            .padding(start = 10.dp, end = 60.dp, bottom = paddingBottom)
    )
}

@Composable
fun MiniRectanguloFiltro(texto: String, currentFilter: String ,onClicked: () -> Unit){
    ProyectoESENCIATheme {
        Button(
            onClick = {onClicked()},
            shape = shapes.large,
            colors = ButtonDefaults.buttonColors(
                contentColor = colorScheme.onPrimaryContainer,
                containerColor = getTheContainerColor(texto, currentFilter)
            ),
            modifier = Modifier.padding(horizontal = 3.dp)
        ) {
            Text(
                text = texto,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}

@Composable
fun getTheContainerColor(texto: String, currentFilter: String): Color{
    return if (texto == currentFilter){
        colorScheme.secondaryContainer
    }else{
        colorScheme.surfaceContainerHigh
    }
}

@Composable
fun NoneFilter(curentFilter: String, onClickFunction: () -> Unit) {
    val tamanio = 50.dp
    IconButton(
        onClick = { onClickFunction() },
        enabled = true,
        modifier = Modifier
            .size(tamanio)
            .clip(CircleShape),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = colorScheme.onPrimaryContainer,
            containerColor = getTheContainerColor("",curentFilter)
        )
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            modifier = Modifier.size(tamanio / 2)
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
                    //Spacer(modifier = Modifier.padding(horizontal = 3.dp))
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