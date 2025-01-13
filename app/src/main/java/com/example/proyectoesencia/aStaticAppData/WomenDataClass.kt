package com.example.proyectoesencia.aStaticAppData

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class WomenDataClass(
    @StringRes val nombre: Int,
    @StringRes val apellido: Int,
    @StringRes val cita: Int,
    @StringRes val fechas: Int,
    @StringRes val profesion: Int,
    @DrawableRes val imagenPortada: Int,
)