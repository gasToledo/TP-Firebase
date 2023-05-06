package com.example.tpfirebase.pantallas.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tpfirebase.pantallas.login.ui.PantallaLogin
import com.example.tpfirebase.pantallas.menu_principal.ui.PantallaMenuPrincipal

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.PantallaLogin.ruta ){

        composable(route = AppScreens.PantallaLogin.ruta){
            PantallaLogin(navController)
        }
        composable(route = AppScreens.PantallaMenuPrincipal.ruta) {
            PantallaMenuPrincipal(navController)
        }
    }
}