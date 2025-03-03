package com.example.proyectoesencia.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*

    Esta clase es la clase necesaria para poder instanciar correctamente
    la base de datos


 */


@Database(entities = [CientificaSchedule::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cientificaScheduleDao(): CientificaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/cientificas_database.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}