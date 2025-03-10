package com.example.proyectoesencia.ui.screens.mainScreen.assets

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun FavButton(Icon: ImageVector, modifier: Modifier, onClickFunction: () -> Unit) {
    val tamanio = 60.dp
    IconButton(
        onClick = { onClickFunction() },
        enabled = true,
        modifier = modifier
            .size(tamanio)
            .clip(CircleShape)
            .shadow(6.dp, shape = CircleShape, spotColor = Color.Black),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = Icon,
            contentDescription = null,
            modifier = Modifier.size(tamanio / 2)
        )
    }
}

@Preview
@Composable
fun FavButtonPreview(){
    FavButton(Icons.Default.Favorite, modifier = Modifier){}
}
