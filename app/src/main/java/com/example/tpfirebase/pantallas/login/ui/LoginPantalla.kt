package com.example.tpfirebase.pantallas.login.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.tpfirebase.pantallas.login.domain.Usuario
import com.example.tpfirebase.pantallas.navegacion.AppScreens
import com.example.tpfirebase.pantallas.scaffold.ScaffoldBase

@Composable
fun PantallaLogin(navController: NavController) {

    ContenidoDeLaPantalla(navController)

}

@Composable
fun ContenidoDeLaPantalla(navController: NavController) {

    ScaffoldBase(
        topbar = { },
        bottombar = { }
    ) { DatosLogin(navController = navController)}
}

@Composable
private fun DatosLogin(navController: NavController) {

    var usuarioRegistrado by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {

            TituloDeLaApp()

            Spacer(modifier = Modifier.padding(10.dp))

            TextoDatosLogin("", "")

            Spacer(modifier = Modifier.padding(vertical = 20.dp))

            BotonIngreso(true, navController)
        }
    }
}

@Composable
private fun TituloDeLaApp() {

    Text(
        text = "Pawsearch",
        fontSize = 45.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
private fun TextoDatosLogin(email: String, clave: String) {


    Column {

        IngresoDeEmail(email)

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        IngresoDeClave(clave)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun IngresoDeClave(clave: String) {

    var claveValue by remember { mutableStateOf(clave) }
    var mostrarClave by remember {
        mutableStateOf(false)
    }
    var isClaveError by remember { mutableStateOf(false) }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        value = claveValue, onValueChange = { newClave ->
            claveValue = newClave
            isClaveError = false
        },
        textStyle = TextStyle(
            fontSize = 20.sp
        ),
        label = {
            Text(
                text = " Clave ",
                color = MaterialTheme.colorScheme.secondary
            )
        },
        placeholder = {
            Text(
                text = "Ingresa tu clave.",
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Lock,
                contentDescription = "Clave Icon",
                tint = MaterialTheme.colorScheme.secondary
            )
        },
        trailingIcon = {
            IconButton(onClick = { mostrarClave = !mostrarClave }) {
                Icon(
                    imageVector = if (mostrarClave) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                    contentDescription = if (mostrarClave) "Mostrar Password" else "Esconder Password"
                )
            }
        },
        visualTransformation = if (mostrarClave) VisualTransformation.None else PasswordVisualTransformation(),
        isError = isClaveError,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.background,
            textColor = MaterialTheme.colorScheme.onSecondaryContainer,
            cursorColor = MaterialTheme.colorScheme.secondary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {

            isClaveError = isClaveError(claveValue)
            localFocusManager.clearFocus()
        })
    )

    if (isClaveError) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Clave erronea",
            color = MaterialTheme.colorScheme.error
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun IngresoDeEmail(email: String) {

    var emailValue by remember { mutableStateOf(email) }
    val localFocusManager = LocalFocusManager.current

    val maxLetras = 15

    OutlinedTextField(
        value = emailValue,
        onValueChange = { newEmail ->
            if (newEmail.length <= maxLetras) emailValue = newEmail
        },
        textStyle = TextStyle(
            fontSize = 20.sp
        ),
        maxLines = 1,
        label = {
            Text(
                text = "Email",
                color = MaterialTheme.colorScheme.secondary,
            )
        },
        placeholder = {
            Text(
                text = "Ingresa tu email.",
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = "Email Icon",
                tint = MaterialTheme.colorScheme.secondary
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.background,
            textColor = MaterialTheme.colorScheme.onSecondaryContainer,
            cursorColor = MaterialTheme.colorScheme.secondary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                localFocusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
}

@Composable
private fun BotonIngreso(usuarioRegistrado: Boolean, navController: NavController) {

    Button(
        onClick = {
            if (usuarioRegistrado) {
                Log.e("CHECK", "el usuario es valido")
                navController.navigate(route = AppScreens.PantallaMenuPrincipal.ruta)

            } else {
                Log.e("CHECK", "Usuario no encontrado")
            }
        },
        shape = MaterialTheme.shapes.extraLarge,
        elevation = ButtonDefaults.buttonElevation(5.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
    ) {
        Text(text = "INGRESAR", fontSize = 24.sp)
    }
}

private fun isClaveError(newClave: String): Boolean {

    Usuario.listaUsuarioCache.forEach { user ->
        if (newClave == user.clave) {

            return false
        }
    }
    return true
}

private fun isEmailError(newEmail: String): Boolean {

    Usuario.listaUsuarioCache.forEach { user ->
        if (newEmail == user.email) {

            return false
        }
    }
    return true
}