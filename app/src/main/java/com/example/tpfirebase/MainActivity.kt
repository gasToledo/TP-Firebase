package com.example.tpfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.tpfirebase.pantallas.login.ui.PantallaLogin
import com.example.tpfirebase.pantallas.navegacion.AppNavigation
import com.google.firebase.analytics.FirebaseAnalytics


class MainActivity : ComponentActivity() {

    /*Instancia principal de Analytics*/
    private val mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavigation()
            }
        }
    }
}


/***
 * Se debe borrar cuando se comience el proyecto.  ***/
@Composable
private fun TextoEnPantalla(name: String) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        //verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Color: $name de la app",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Color: SECUNDARIO de la app",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.tertiaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Color: TERCIARIO de la app",
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }
    }
}


/*Función que se utiliza para mostrar un ejemplo
  de como se veria el resultado final.*/
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    TextoEnPantalla(name = "Primario")
}
