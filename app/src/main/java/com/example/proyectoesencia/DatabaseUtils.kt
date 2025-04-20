package com.example.proyectoesencia

import android.content.Context

object DatabaseUtils {
    private const val PREF_NAME = "AppPreferences"
    private const val PREF_KEY_FIRST_LAUNCH = "first_launch"

    fun isFirstLaunch(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(PREF_KEY_FIRST_LAUNCH, true)
    }

    fun setFirstLaunchDone(context: Context) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(PREF_KEY_FIRST_LAUNCH, false).apply()
    }
}
