package com.example.tpfirebase.pantallas.navegacion

sealed class AppScreens(val ruta: String){

    object PantallaLogin : AppScreens(ruta = "pantalla_login")
    object PantallaMenuPrincipal : AppScreens(ruta = "pantalla_menu_principal")

}
