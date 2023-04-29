package com.example.tpfirebase.pantallas.login.domain

data class Usuario(val nombre: String, val apellido: String, val email: String, val clave: String) {


    //Datos de usuarios falsos, guardados para comprobar el correcto funcionamiento
    //de la pantalla LOGIN.

    companion object {
        val listaUsuarioCache = listOf<Usuario>(
            Usuario("N1", "A1", "a1n1@email.com", "a1n1"),
            Usuario("N2", "A2", "a2n2@email.com", "a2n2"),
            Usuario("N3", "A3", "a3n3@email.com", "a3n3"),
            Usuario("N4", "A4", "a4n4@email.com", "a4n4"),
            Usuario("N5", "A5", "a5n5@email.com", "a5n5"),
            Usuario("N6", "A6", "a6n6@email.com", "a6n6"),
            Usuario("N7", "A7", "a7n7@email.com", "a7n7"),
            Usuario("N8", "A8", "a8n8@email.com", "a8n8"),
            Usuario("N9", "A9", "a9n9@email.com", "a9n9")
        )
    }
}
