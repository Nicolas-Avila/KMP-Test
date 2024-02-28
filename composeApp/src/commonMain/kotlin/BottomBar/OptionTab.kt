package BottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object OptionTab: Tab {
    @Composable
    override fun Content() {
        Box(Modifier.fillMaxSize().background(Color.Yellow), contentAlignment = Alignment.Center) {
            Text("Option", fontSize = 22.sp, color = Color.Black)
        }
    }

    override val options: TabOptions
        @Composable
        get(){
            val icon =  rememberVectorPainter(Icons.Default.AddCircle)
            return remember {
                TabOptions(
                    index = 1u,
                    title = "Opciones",
                    icon = icon
                )
            }
        }

}