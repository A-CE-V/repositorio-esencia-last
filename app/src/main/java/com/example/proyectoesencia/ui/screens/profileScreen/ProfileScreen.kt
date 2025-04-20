package com.example.proyectoesencia.ui.screens.profileScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectoesencia.R
import com.example.proyectoesencia.data.CientificaSchedule
import com.example.proyectoesencia.navigationManagers.RutasSealed
import com.example.proyectoesencia.ui.screens.mainScreen.PantallaPrincipalVM
import com.example.proyectoesencia.ui.screens.mainScreen.assets.FavButton
import com.example.proyectoesencia.ui.screens.mainScreen.assets.InformacionCientificaTexts
import com.example.proyectoesencia.ui.screens.mainScreen.assets.ProfesionText
import com.example.proyectoesencia.ui.screens.mainScreen.assets.RectanguloPortrait
import com.example.proyectoesencia.ui.screens.mainScreen.assets.tools.calculatePadding
import com.example.proyectoesencia.ui.screens.mainScreen.assets.tools.cropTheTextAt
import com.example.proyectoesencia.ui.screens.mainScreen.assets.tools.findImageByName
import com.example.pruebasesencia.BottomBar

@Composable
fun ProfileScreen(
    navController: NavController,
    pantallaPrincipalVM: PantallaPrincipalVM
) {
    val tablaCompletaMeGusta by pantallaPrincipalVM.getScheduleMeGusta().collectAsState(emptyList())
    val estado = pantallaPrincipalVM.cientificasState.collectAsState()
    BackHandler {

    }
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                    ) {
                        Text(text = "Mis Me Gusta", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(8.dp))
                            HorizontalDivider(
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.Gray,
                                thickness = 1.dp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            AppProfileScreenManager(paddingValues, navController, tablaCompletaMeGusta, pantallaPrincipalVM::updateState, pantallaPrincipalVM::updateSelectedFilter, estado.value.filter, pantallaPrincipalVM)
                        }
                    }
                }
            }
        },
        bottomBar = { BottomBar(navController) }
    )
}

@Composable
fun AppProfileScreenManager(paddingValues: PaddingValues, navController: NavController, schedule: List<CientificaSchedule>, updateID: (Int) -> Unit, updateFilter: (String) -> Unit, currentFilter: String, pantallaPrincipalVM: PantallaPrincipalVM) {
    Column(
        Modifier.fillMaxSize().padding(paddingValues)
    ){
        MostrarColumnaMainMeGusta(paddingValues, navController, schedule, updateID, currentFilter, pantallaPrincipalVM)
    }
}

@Composable
fun MostrarColumnaMainMeGusta(paddingValues: PaddingValues, navController: NavController, schedule: List<CientificaSchedule>, updateID: (Int) -> Unit, currentFilter: String, pantallaPrincipalVM: PantallaPrincipalVM){
    Column(Modifier.verticalScroll(rememberScrollState())) {
        schedule.forEach { item ->
            if (item.profesiones.lowercase().contains(currentFilter.lowercase())) {
                RectanguloPortraitMeGusta(
                    item.id,
                    item.nombre,
                    item.apellidos,
                    item.profesiones,
                    onClicked = {
                        updateID(item.id)
                        navController.navigate(RutasSealed.DetailScreen.ruta)
                    },
                    pantallaPrincipalVM
                )
            }
        }
    }
}

@Composable
fun RectanguloPortraitMeGusta(id: Int, nombre: String, apellido: String, profesion: String, onClicked: () -> Unit, pantallaPrincipalVM: PantallaPrincipalVM){
    //val width = 180.dp
    val imagen = findImageByName(nombre, apellido)
    val height = 290.dp; val nameSize = 28.sp; val surnameSize = 30.sp; val profesionSize = 20.sp
    val characterCropAt = 70; val gradiente = listOf(colorScheme.surface, colorScheme.primaryContainer, colorScheme.secondaryContainer)
    val shape = shapes.extraLarge
    val profesionCrop = cropTheTextAt(profesion, characterCropAt); val paddingBottom = calculatePadding(profesionCrop)
    val shadowOffSet = Offset(2.0f, 3.0f); val shadowOffSet2 = Offset(1.0f, 2.0f)
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
                    .blur(40.dp).fillMaxHeight()
            )
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height-85.dp)
            )
            FavButtonMeGusta(Icons.Default.Favorite, modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 30.dp, end = 20.dp), onClickFunction = { pantallaPrincipalVM.meGusta(id) })
            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize().padding(10.dp)) {

                InformacionCientificaMeGustaTexts(nombre, apellido, nameSize, shadowOffSet, surnameSize, shadowOffSet2)
                ProfesionTextMeGusta(profesionCrop, profesionSize, shadowOffSet2, paddingBottom)

            }
        }
    }
}

@Composable
fun InformacionCientificaMeGustaTexts(nombre: String, apellido: String, nameSize: TextUnit, shadowOffSet: Offset, surnameSize: TextUnit, shadowOffSet2: Offset){
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
fun ProfesionTextMeGusta(profesionCrop: String, profesionSize: TextUnit, shadowOffSet2: Offset, paddingBottom: Dp){
    Text(
        text = profesionCrop,
        fontFamily = FontFamily(Font(R.font.afacad)),
        color = Color.White,
        style = TextStyle(
            fontSize = profesionSize,
            shadow = Shadow(color = Color.Black, offset = shadowOffSet2, blurRadius = 2f)
        ),
        modifier = Modifier
            .paddingFromBaseline(10.dp).fillMaxWidth()
            .padding(start = 10.dp, end = 60.dp, bottom = paddingBottom)
    )
}

@Composable
fun FavButtonMeGusta(Icon: ImageVector, modifier: Modifier, onClickFunction: () -> Unit){
    val tamanio = 60.dp
    IconButton(
        onClick = {onClickFunction()},
        enabled = true,
        modifier = modifier.size(tamanio).clip(CircleShape).shadow(6.dp, shape = CircleShape, spotColor = Color.Black),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = Icon,
            contentDescription = null,
            modifier = Modifier.size(tamanio/2)
        )
    }
}
