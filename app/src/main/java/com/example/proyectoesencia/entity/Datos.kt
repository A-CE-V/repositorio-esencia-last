package com.example.proyectoesencia.entity

import com.example.proyectoesencia.R

/*        --------------------   OLD  --------------------

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
    // Imágenes de Daniel, añadidas por Adrián:
    R.drawable.alicia to R.string.alicia,
    R.drawable.rosa to R.string.rosa,
    R.drawable.montserrat to R.string.montserrat,
    R.drawable.maria to R.string.maria,
    R.drawable.margarita to R.string.margarita,
    // Imágenes de Salvador, añadidas por Adrián:
    R.drawable.marie to R.string.marie,
    R.drawable.barbara to R.string.barbara,
    R.drawable.elizabeth to R.string.elizabeth,
    R.drawable.rosalind to R.string.rosalind,
    R.drawable.caroline to R.string.caroline,
    // Imágenes de Yaris, añadidas por Adrián:
    R.drawable.aspasia to R.string.aspasia,
    R.drawable.mary to R.string.mary,
    R.drawable.ada to R.string.ada,
    R.drawable.nettie to R.string.nettie,
    R.drawable.lise to R.string.lise,
    // Imágenes de Adrián, añadidas por Adrián:
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

 */

// Está siendo reformado


/*

 @StringRes val nombre: Int,
    @StringRes val apellido: Int,
    @StringRes val cita: Int,
    @StringRes val fechas: Int,
    @StringRes val profesion: Int,
    @DrawableRes val imagenPortada: Int,
    @DrawableRes val imagen2: Int


 */

class Datos{
    val listaData = listOf(
        WomenDataClass(R.string.alicia,R.string.a_alicia,R.string.c_alicia,R.string.f_alicia,R.string.p_alicia,R.drawable.alicia),
        WomenDataClass(R.string.rosa,R.string.a_rosa,R.string.c_rosa,R.string.f_rosa,R.string.p_rosa,R.drawable.rosa),
        WomenDataClass(R.string.maria,R.string.a_maria,R.string.c_maria,R.string.f_maria,R.string.p_maria,R.drawable.maria),
        WomenDataClass(R.string.montserrat,R.string.a_montserrat,R.string.c_montserrat,R.string.f_montserrat,R.string.p_montserrat,R.drawable.montserrat),
        WomenDataClass(R.string.margarita,R.string.a_margarita,R.string.c_margarita,R.string.f_margarita,R.string.p_margarita,R.drawable.margarita),

        WomenDataClass(R.string.marie,R.string.a_marie,R.string.c_marie,R.string.f_marie,R.string.p_marie,R.drawable.marie),
        WomenDataClass(R.string.barbara,R.string.a_barbara,R.string.c_barbara,R.string.f_barbara,R.string.p_barbara,R.drawable.barbara),
        WomenDataClass(R.string.elizabeth,R.string.a_elizabeth,R.string.c_elizabeth,R.string.f_elizabeth,R.string.p_elizabeth,R.drawable.elizabeth),
        WomenDataClass(R.string.rosalind,R.string.a_rosalind,R.string.c_rosalind,R.string.f_rosalind,R.string.p_rosalind,R.drawable.rosalind),
        WomenDataClass(R.string.caroline,R.string.a_caroline,R.string.c_caroline,R.string.f_caroline,R.string.p_caroline,R.drawable.caroline),

        WomenDataClass(R.string.aspasia,R.string.a_aspasia,R.string.c_aspasia,R.string.f_aspasia,R.string.p_aspasia,R.drawable.aspasia),
        WomenDataClass(R.string.mary,R.string.a_mary,R.string.c_mary,R.string.f_mary,R.string.p_mary,R.drawable.mary),
        WomenDataClass(R.string.ada,R.string.a_ada,R.string.c_ada,R.string.f_ada,R.string.p_ada,R.drawable.ada),
        WomenDataClass(R.string.nettie,R.string.a_nettie,R.string.c_nettie,R.string.f_nettie,R.string.p_nettie,R.drawable.nettie),
        WomenDataClass(R.string.lise,R.string.a_lise,R.string.c_lise,R.string.f_lise,R.string.p_lise,R.drawable.lise),

        WomenDataClass(R.string.maria_juana,R.string.a_maria_juana,R.string.c_maria_juana,R.string.f_maria_juana,R.string.p_maria_juana,R.drawable.mariaandresa),
        WomenDataClass(R.string.blanca,R.string.a_blanca,R.string.c_blanca,R.string.f_blanca,R.string.p_blanca,R.drawable.blanca),
        WomenDataClass(R.string.valentina,R.string.a_valentina,R.string.c_valentina,R.string.f_valentina,R.string.p_valentina,R.drawable.valentina),
        WomenDataClass(R.string.hipatia,R.string.a_hipatia,R.string.c_hipatia,R.string.f_hipatia,R.string.p_hipatia,R.drawable.hipatia),
        WomenDataClass(R.string.sofia,R.string.a_sofia,R.string.c_sofia,R.string.f_sofia,R.string.p_sofia,R.drawable.sofia))
}

/*
fun averiguarProfesiones(@StringRes profesion: Int):List<Int>{
    val apellidos: String = profesion.toString()
    val profesiones: Int
    for ()
}*/

/*
fun getTodosLosDatosStringsDe(@StringRes nombre: Int): List<Int>{
    val datos = mutableListOf<Int>()
    val apellido = apellidosData[nombre]; val fechas = fechasData[nombre]; val cita = citasData[nombre]

    if (apellido != null && fechas != null && cita != null) {
        datos.add(apellido); datos.add(fechas); datos.add(cita)
    }else{
        repeat(3){
            datos.add(R.string.datos_null_error1)
        }
    }
    return datos
}
*/

