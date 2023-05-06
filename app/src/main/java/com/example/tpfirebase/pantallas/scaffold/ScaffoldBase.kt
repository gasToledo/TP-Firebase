package com.example.tpfirebase.pantallas.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldBase(
    topbar: @Composable () -> Unit,
    bottombar: @Composable () -> Unit,
    content: @Composable () -> Unit
) {

    AppTheme {
        Scaffold(topBar = { topbar() }, bottomBar = { bottombar() }) {

            Box(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize()
                    .padding(it)
                    .padding(5.dp)
            ) {
                content()
            }
        }
    }

}