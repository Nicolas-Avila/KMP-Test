package BottomBar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class BottonBarScreen : Screen{
    @Composable
    override fun Content() {

        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    it,
                    listOf(HomeTab,OptionTab)
                )
            }
        ){
            Scaffold (
                topBar = {
                   //Button(onClick = {navigator.pop()}){ Text("volver")}
                   TopAppBar (title = {Text(it.current.options.title )})
                },
                bottomBar = {
                    BottomNavigation {
                        val tabNavigator = LocalTabNavigator.current
                        //Inicio
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == HomeTab.key,
                            label = { Text(HomeTab.options.title)},
                            icon = {Icon(painter = HomeTab.options.icon!!, contentDescription = null)},
                            onClick = {tabNavigator.current = HomeTab}
                        )
                        //Favorito
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == FavoriteTab.key,
                            label = { Text(FavoriteTab.options.title)},
                            icon = {Icon(painter = FavoriteTab.options.icon!!, contentDescription = null)},
                            onClick = {tabNavigator.current = FavoriteTab}
                        )
                        //Opciones
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == OptionTab.key,
                            label = { Text(OptionTab.options.title)},
                            icon = {Icon(painter = OptionTab.options.icon!!, contentDescription = null)},
                            onClick = {tabNavigator.current = OptionTab}
                        )
                    }

                },

                content = { CurrentTab()}

            )//{ CurrentTab()}
        }

    }

}