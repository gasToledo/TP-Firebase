package com.example.tpfirebase.pantallas.menu_principal.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tpfirebase.pantallas.scaffold.ScaffoldBase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

@Preview
@Composable
private fun DefaultPreview() {

    val navController = rememberNavController()
    PantallaMenuPrincipal(navController)

}

@Composable
fun PantallaMenuPrincipal(navController: NavController) {

    val firebaseAnalytics = Firebase.analytics

    ScaffoldBase(topbar = { /*TODO*/ }, bottombar = { /*TODO*/ }) {

        MenuPrincipalContent(navController = navController)

    }

    firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
        param(FirebaseAnalytics.Param.SCREEN_NAME, "menu_principal")
        param(FirebaseAnalytics.Param.SCREEN_CLASS, "Pantalla_menu")
    }
}

@Composable
private fun MenuPrincipalContent(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonBack(navController = navController)
    }
}

@Composable
private fun BotonBack(navController: NavController) {

    Button(
        onClick = { navController.popBackStack() },
        shape = MaterialTheme.shapes.extraLarge,
        elevation = ButtonDefaults.buttonElevation(5.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
    ) {
        Text(text = "VOLVER", fontSize = 28.sp)
    }
}