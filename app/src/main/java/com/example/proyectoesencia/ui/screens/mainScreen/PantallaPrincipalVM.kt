package com.example.proyectoesencia.ui.screens.mainScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.proyectoesencia.CientificasScheduleApplication
import com.example.proyectoesencia.data.CientificaDao
import com.example.proyectoesencia.data.CientificaSchedule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PantallaPrincipalVM(private val cientificaDao: CientificaDao) : ViewModel(){

    private val _cientificasState = MutableStateFlow(PantallaPrincipalState())
    val cientificasState: StateFlow<PantallaPrincipalState> = _cientificasState.asStateFlow()

    /*

        Obtiene la lista completa de cientificas a través del uso del DAO

     */
    fun getFullSchedule(): Flow<List<CientificaSchedule>> = cientificaDao.getAll()

    /*

        Obtiene datos de una científica determinada gracias a el uso de un nombre como parámetro

     */
    fun getScheduleFor(id: Int): Flow<List<CientificaSchedule>> = cientificaDao.getCientificaById(id)

    /*

        Actualiza el estado del viewmodel con los datos de una mujer científica a partir de la ID
        que se pasa por parámetro.

        Esto lo hago para que en la pantalla de detalles aparezcan los datos de la científica en la que se hizo click previamente

     */

    fun getScheduleMeGusta(): Flow<List<CientificaSchedule>> = cientificaDao.getMeGustaLista()

    fun getMeGustaFlow(id: Int): Flow<Int> {
        return cientificaDao.getMeGustaFlow(id)
    }


    fun updateState(id: Int){
        _cientificasState.update{ nuevoValor ->
            nuevoValor.copy(
                id = id
            )
        }
    }

    fun updateSelectedFilter(filter: String){
        _cientificasState.update{ nuevoValor ->
            nuevoValor.copy(
                filter = filter
            )
        }
    }

    fun meGusta(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val megusta = cientificaDao.getMeGusta(id)
            if (megusta == 1) {
                Log.e("Gusta", "No MeGusta")
                cientificaDao.removeMeGusta(id)
            } else {
                Log.e("Gusta", "MeGusta")
                cientificaDao.updateMeGusta(id)
            }
        }
    }



    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CientificasScheduleApplication)
                PantallaPrincipalVM(application.database.cientificaScheduleDao())
            }
        }
    }
}