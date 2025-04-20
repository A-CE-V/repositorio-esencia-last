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

    @Query("SELECT me_gusta FROM cientificas WHERE id = :id")
    fun getMeGusta(id: Int): Int

    @Query("SELECT me_gusta FROM cientificas WHERE id = :id")
    fun getMeGustaFlow(id: Int): Flow<Int>

    @Query("UPDATE cientificas SET me_gusta = 1 WHERE id = :id")
    suspend fun updateMeGusta(id: Int)

    @Query("UPDATE cientificas SET me_gusta = 0 WHERE id = :id")
    suspend fun removeMeGusta(id: Int)

    @Query("SELECT * FROM cientificas WHERE me_gusta = 1")
    fun getMeGustaLista(): Flow<List<CientificaSchedule>>
}