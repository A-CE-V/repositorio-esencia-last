package com.example.proyectoesencia

import android.app.Application
import com.example.proyectoesencia.data.AppDatabase


class CientificasScheduleApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}