package com.example.proyectoesencia.NavigationClasses

sealed class RutasSealed(val ruta: String) {
    object FirstScreen: RutasSealed("button")
    object MainScreen: RutasSealed("main")
    object IntroScreen: RutasSealed("intro")
    object SettingsScreen: RutasSealed("settings")
}