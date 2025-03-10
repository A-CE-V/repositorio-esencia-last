package com.example.proyectoesencia.ui.screens.mainScreen.assets.tools

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.proyectoesencia.R
import com.example.proyectoesencia.zzzdeprecated.aStaticAppData.listaData

fun cropTheTextAt(texto: String, characterCropAt: Int): String{
    if (texto.length >= characterCropAt){
        return "${texto.substring(0,characterCropAt)}..."
    }else{
        return texto
    }
}

fun calculatePadding(profesionCrop: String): Dp{
    return if (profesionCrop.length <= 39){
        25.dp
    }else{
        7.dp
    }
}

@Composable
fun findImageByName(nombre: String, apellido: String): Int{
    listaData.forEach { item ->
        val name : String = stringResource(item.nombre); val surname: String = stringResource(item.apellido)
        if ( name.lowercase() == nombre.lowercase() && surname.lowercase() == apellido.lowercase()){
            return item.imagenPortada
        }
    }
    return R.drawable.desconocida
}