package com.amaurypm.composenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amaurypm.composenav.ui.theme.ComposeNavTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //Generamos el estado para navegación
            val navController: NavHostController = rememberNavController()

            ComposeNavTheme {

                NavHost(
                    navController = navController,
                    startDestination = MainScreenDestination
                ) {

                    //Colocamos nuestros destinos

                    composable<MainScreenDestination> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFFDF6E6E)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(DataScreenDestination)
                                }
                            ) {
                                Text(
                                    text = "Siguiente",
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    composable<DataScreenDestination> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFF70E6D4)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Datos recibidos",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold
                            )

                        }
                    }


                }

            }
        }
    }
}

//Generamos los destinos a navegar
@Serializable
object MainScreenDestination

@Serializable
object DataScreenDestination
