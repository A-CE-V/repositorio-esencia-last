package com.example.proyectoesencia.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


/*

    Este es el DAO, que contiene todas las consultas necesarias para obtener los datos
    de la base de datos


 */

@Dao
interface CientificaDao{
    @Query(
        """
        SELECT * FROM cientificas 
        ORDER BY nombre ASC    
        """
    )
    fun getAll(): Flow<List<CientificaSchedule>>

    @Query(
        """
        SELECT * FROM cientificas 
        WHERE id = :id
        ORDER BY id ASC
        """
    )
    fun getCientificaById(id: Int): Flow<List<CientificaSchedule>>

}