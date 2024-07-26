package com.jhm.testingloadingbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jhm.loadingbutton.LoadingButton
import com.jhm.loadingbutton.LoadingElevatedButton
import com.jhm.loadingbutton.LoadingFilledTonalButton
import com.jhm.loadingbutton.LoadingOutlinedButton
import com.jhm.loadingbutton.LoadingTextButton
import com.jhm.testingloadingbutton.ui.theme.TestingLoadingButtonTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingLoadingButtonTheme {
                val scope = rememberCoroutineScope()
                var isLoading by rememberSaveable { mutableStateOf(false) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(10.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoadingButton(
                            buttonText = "Prueba de boton normal",
                            isLoading = isLoading,
                            onClick = {
                                scope.launch {
                                    isLoading = true
                                    delay(3000)
                                    isLoading = false
                                }
                            },
                            startIcon = Icons.Default.Add
                        )

                        LoadingFilledTonalButton(
                            buttonText = "Prueba de boton tonal",
                            isLoading = isLoading,
                            onClick = {
                                scope.launch {
                                    isLoading = true
                                    delay(3000)
                                    isLoading = false
                                }
                            },
                            endIcon = Icons.Default.Remove
                        )

                        LoadingOutlinedButton(
                            buttonText = "Prueba de boton outlined",
                            isLoading = isLoading,
                            onClick = {
                                scope.launch {
                                    isLoading = true
                                    delay(3000)
                                    isLoading = false
                                }
                            },
                            startIcon = Icons.Default.Add,
                            endIcon = Icons.Default.Remove
                        )

                        LoadingTextButton(
                            buttonText = "Prueba de boton texto",
                            isLoading = isLoading,
                            onClick = {
                                scope.launch {
                                    isLoading = true
                                    delay(3000)
                                    isLoading = false
                                }
                            }
                        )

                        LoadingElevatedButton(
                            buttonText = "Prueba de boton elevado",
                            isLoading = isLoading,
                            onClick = {
                                scope.launch {
                                    isLoading = true
                                    delay(3000)
                                    isLoading = false
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}