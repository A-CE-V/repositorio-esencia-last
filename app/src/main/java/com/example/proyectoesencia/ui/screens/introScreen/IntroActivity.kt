import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoesencia.R
import com.example.proyectoesencia.navigationManagers.RutasSealed
import kotlinx.coroutines.delay


@Composable
fun AppLogoIntro(navController: NavController) {
    var showMyApp by remember { mutableStateOf(true) }
    var showMujeresStem by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        delay(3000)
        showMyApp = false
        showMujeresStem = true
        navController.popBackStack(RutasSealed.FirstScreen.ruta, false)
        showMujeresStem = false
    }

    AnimatedVisibility(
        visible = showMyApp,
        exit = fadeOut(animationSpec = tween(1000))
    ) {
        MyLogo(Modifier.fillMaxSize())
    }
    AnimatedVisibility(
        visible = showMujeresStem,
        enter = fadeIn(animationSpec = tween(1000)),
        exit = fadeOut(animationSpec = tween(1000))
    ) {


    }

}




@Composable
fun MyLogo(modifier: Modifier = Modifier) {
    Surface(modifier, color = Color(0xFF000000)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "My image description",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}


@Preview
@Composable
fun AppNavigationPreview(){
    val navController = rememberNavController()
    AppLogoIntro(navController)
}

@Preview
@Composable
fun MyLogoPreview() {
    MyLogo(Modifier.fillMaxSize())
}