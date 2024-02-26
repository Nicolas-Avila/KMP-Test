import BottomBar.BottonBarScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.SlideTransition


@Composable
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen()){navigator ->
            SlideTransition(navigator)
        }

    }
}


class MainScreen:Screen{

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            //avanza en la navegacion
        navigator.push(SecondScreen())
        }){
            Text("avanza gil")
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            //avanza en la navegacion
            navigator.push(BottonBarScreen())
        }){
            Text("button bar")
        }

        }
    }
}

class SecondScreen:Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier.fillMaxSize().background(androidx.compose.ui.graphics.Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("funciona sos el mejor de tu casa ", fontSize = 25.sp, color = androidx.compose.ui.graphics.Color.White)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {navigator.pop()}){Text("volve pamflin", fontSize = 25.sp, color = androidx.compose.ui.graphics.Color.Red)
            }
        }
    }
}



