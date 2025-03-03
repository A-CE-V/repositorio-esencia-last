package com.example.proyectoesencia.ui.screens.mainScreen.assets



import androidx.appcompat.view.menu.ShowableListMenu
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.commandiron.compose_loading.Circle
import com.commandiron.compose_loading.CubeGrid
import com.commandiron.compose_loading.FoldingCube
import com.commandiron.compose_loading.ThreeBounce

@Composable
fun ShowLoader(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        when(genRandomNumber(1,5)){
            1 -> CircularProgressIndicator()
            2 -> CubeGrid()
            3 -> Circle()
            4 -> FoldingCube()
            5 -> ThreeBounce()
            else -> CircularProgressIndicator()
        }

    }
}


fun genRandomNumber(min: Int, max: Int):Int{
    return (min..max).random()
}




