package com.example.proyectoesencia.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*

    Esta es la clase Entity.
    Esta clase sirve a modo de objeto individual para cada fila de la tabla. Se creará un objeto por científica en la tabla

    Es importante que contenga los mismos datos que las columnas disponibles de la tabla de la base de datos


 */

@Entity(tableName = "cientificas")
data class CientificaSchedule (
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "nombre")
    val nombre: String,

    @ColumnInfo(name = "apellidos")
    val apellidos: String,

    @ColumnInfo(name = "fechas")
    val fechas: String,

    @ColumnInfo(name = "citas")
    val citas: String,

    @ColumnInfo(name = "profesiones")
    val profesiones: String,

    @ColumnInfo(name = "biografia")
    val biografia: String,
)