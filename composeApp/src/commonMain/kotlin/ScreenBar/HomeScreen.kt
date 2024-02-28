import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Magenta, Color.Yellow, Color.Cyan, Color.Gray)
        val texts = listOf("Hello", "World", "Android", "AVE", "Hola", "8448", "888888888888888888888888888888888888888")

        val squareModifier = Modifier.padding(horizontal = 10.dp) // Añade espacio entre los cuadrados

        var showMessageDialog by remember { mutableStateOf(false) }
        var messageToShow by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 56.dp), // Añade margen inferior para evitar que los cuadros sean tapados por la bottom bar
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val lastIndex = colors.lastIndex
            for (i in 0 until lastIndex step 2) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Square(modifier = Modifier.weight(1f), color = colors[i], text = texts[i]) {
                        showMessageDialog = true
                        messageToShow = texts[i]
                    }
                    Square(modifier = Modifier.weight(1f), color = colors[i + 1], text = texts[i + 1]) {
                        showMessageDialog = true
                        messageToShow = texts[i + 1]
                    }
                }
            }
            // Tratar el último elemento si la lista tiene un número impar de elementos
            if (colors.size % 2 != 0) {
                val lastColor = colors[lastIndex]
                val lastText = texts[lastIndex]
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Square(modifier = Modifier.weight(1f), color = lastColor, text = lastText) {
                        showMessageDialog = true
                        messageToShow = lastText
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }

        if (showMessageDialog) {
            AlertDialog(
                onDismissRequest = { showMessageDialog = false },
                title = { Text("Mensaje") },
                text = { Text(text = messageToShow) },
                confirmButton = {
                    TextButton(
                        onClick = { showMessageDialog = false }
                    ) {
                        Text("Aceptar")
                    }
                }
            )
        }
    }

    @Composable
    private fun Square(modifier: Modifier, color: Color, text: String, onClick: () -> Unit) {
        Box(
            modifier = modifier
                .size(150.dp)
                .background(color = color)
                .clickable(onClick = onClick) // Agrega un listener de clics al cuadro
        ) {
            Text(
                text = text,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomCenter) // Texto en la parte inferior del cuadrado
                    .padding(bottom = 16.dp) // Añade un pequeño espacio entre el texto y el borde inferior del cuadrado
            )
        }
    }
}
