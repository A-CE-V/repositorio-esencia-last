package com.example.proyectoesencia

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class AsociacionDatos {
    val apellidosData = mapOf(
        R.string.alicia to R.string.a_alicia,
        R.string.rosa to R.string.a_rosa,
        R.string.montserrat to R.string.a_montserrat,
        R.string.maria to R.string.a_maria,
        R.string.margarita to R.string.a_margarita,
        R.string.marie to R.string.a_marie,
        R.string.barbara to R.string.a_barbara,
        R.string.elizabeth to R.string.a_elizabeth,
        R.string.rosalind to R.string.a_rosalind,
        R.string.caroline to R.string.a_caroline,
        R.string.aspasia to R.string.a_aspasia,
        R.string.mary to R.string.a_mary,
        R.string.ada to R.string.a_ada,
        R.string.nettie to R.string.a_nettie,
        R.string.lise to R.string.a_lise,
        R.string.maria_juana to R.string.a_maria_juana,
        R.string.blanca to R.string.a_blanca,
        R.string.valentina to R.string.a_valentina,
        R.string.hipatia to R.string.a_hipatia,
        R.string.sofia to R.string.a_sofia
    )

    val fechasData = mapOf(
        R.string.alicia to R.string.f_alicia,
        R.string.rosa to R.string.f_rosa,
        R.string.montserrat to R.string.f_montserrat,
        R.string.maria to R.string.f_maria,
        R.string.margarita to R.string.f_margarita,
        R.string.marie to R.string.f_marie,
        R.string.barbara to R.string.f_barbara,
        R.string.elizabeth to R.string.f_elizabeth,
        R.string.rosalind to R.string.f_rosalind,
        R.string.caroline to R.string.f_caroline,
        R.string.aspasia to R.string.f_aspasia,
        R.string.mary to R.string.f_mary,
        R.string.ada to R.string.f_ada,
        R.string.nettie to R.string.f_nettie,
        R.string.lise to R.string.f_lise,
        R.string.maria_juana to R.string.f_maria_juana,
        R.string.blanca to R.string.f_blanca,
        R.string.valentina to R.string.f_valentina,
        R.string.hipatia to R.string.f_hipatia,
        R.string.sofia to R.string.f_sofia
    )

    val citasData = mapOf(
        R.string.alicia to R.string.c_alicia,
        R.string.rosa to R.string.c_rosa,
        R.string.montserrat to R.string.c_montserrat,
        R.string.maria to R.string.c_maria,
        R.string.margarita to R.string.c_margarita,
        R.string.marie to R.string.c_marie,
        R.string.barbara to R.string.c_barbara,
        R.string.elizabeth to R.string.c_elizabeth,
        R.string.rosalind to R.string.c_rosalind,
        R.string.caroline to R.string.c_caroline,
        R.string.aspasia to R.string.c_aspasia,
        R.string.mary to R.string.c_mary,
        R.string.ada to R.string.c_ada,
        R.string.nettie to R.string.c_nettie,
        R.string.lise to R.string.c_lise,
        R.string.maria_juana to R.string.c_maria_juana,
        R.string.blanca to R.string.c_blanca,
        R.string.valentina to R.string.c_valentina,
        R.string.hipatia to R.string.c_hipatia,
        R.string.sofia to R.string.c_sofia
    )


    public val imagenesData = listOf(
        R.drawable.mariaandresa to R.string.maria_juana,
        R.drawable.blanca to R.string.blanca,
        R.drawable.valentina to R.string.valentina,
        R.drawable.hipatia to R.string.hipatia,
        R.drawable.sofia to R.string.sofia
    ).map { DrawableStringPair(it.first, it.second) }



    data class DrawableStringPair(
        @DrawableRes val imagen: Int,
        @StringRes val nombre: Int
    )


    fun getTodosLosDatosStringsDe(@StringRes nombre: Int): List<Int>{
        val datos = mutableListOf<Int>()
        val apellido = apellidosData[nombre]; val fechas = fechasData[nombre]; val cita = citasData[nombre]

        if (apellido != null && fechas != null && cita != null) {
            datos.add(apellido); datos.add(fechas); datos.add(cita)
        }else{
            datos.add(R.string.datos_null_error1)
        }
        return datos
    }


}


