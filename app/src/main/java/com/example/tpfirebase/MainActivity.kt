package com.example.tpfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tpfirebase.ui.theme.TPFirebaseTheme
import com.google.firebase.analytics.FirebaseAnalytics


class MainActivity : ComponentActivity() {

    /*Instancia principal de Analytics*/
    private val mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPFirebaseTheme {
                /* Aca iria pantalla inicial */
                TextoEnPantalla(name = "Usuario1")
            }
        }
    }
}

@Composable
private fun TextoEnPantalla(name: String) {

    Text(
        text = "Bienvenidos $name",
        color = Color.Black,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}


/*Función que se utiliza para mostrar un ejemplo
  de como se veria el resultado final.*/
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    TextoEnPantalla(name = "Miembros de la Fireneta")
}
