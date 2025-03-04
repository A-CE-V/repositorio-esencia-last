package com.example.proyectoesencia.navigationManagers

sealed class RutasSealed(val ruta: String) {
    object IntroScreen: RutasSealed("intro")
    object FirstScreen: RutasSealed("button")
    object MainScreen: RutasSealed("main")
    object DetailScreen: RutasSealed("detail")
    object ProfileScreen: RutasSealed("profile")
    object MoreScreen: RutasSealed("more")
    object CreditScreen: RutasSealed("credits")
    object SettingsScreen: RutasSealed("settings")
}