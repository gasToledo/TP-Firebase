package com.example.tpfirebase.pantallas.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DefaultPreview() {


}

@Composable
fun PantallaLogin() {

    ContenidoDeLaPantalla()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoDeLaPantalla() {

    Scaffold(topBar = { }, bottomBar = { }) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(5.dp)
        ) {


        }
    }

}

@Composable
private fun DatosLogin() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextoDatosLogin(email: String, clave: String) {

    TextField(
        value = "Ingrese usuario",
        onValueChange = { },
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 22.sp
        )
    )

}
