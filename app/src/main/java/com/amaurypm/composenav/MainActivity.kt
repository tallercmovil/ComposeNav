package com.amaurypm.composenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.amaurypm.composenav.ui.theme.ComposeNavTheme
import com.amaurypm.composenav.ui.theme.Purple40
import com.amaurypm.composenav.ui.theme.Purple80
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //Instanciamos nuestro navController
            var navController: NavHostController = rememberNavController()

            //Ponemos nuestro NavHost
            NavHost(
                navController = navController,
                startDestination = MainScreenDestination
            ) {

                //Aquí va el gráfico de navegación
                composable<MainScreenDestination> {

                    //Todos los composable de esa pantalla
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Purple80)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(DataScreenDestination(
                                        name = "Alberto",
                                        age = 25
                                    ))
                                }
                            ) {
                                Text(
                                    text = "Siguiente",
                                    fontSize = 28.sp
                                )
                            }
                        }
                    }

                }

                composable<SecondScreenDestination> {

                    //Todos los composable de esa pantalla
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Purple40)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Segunda pantalla",
                                fontSize = 28.sp
                            )

                        }
                    }

                }

                composable<DataScreenDestination> { backStackEntry ->

                    //Obtenemos los parámetros con los que se instanció la data class
                    val args = backStackEntry.toRoute<DataScreenDestination>()

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Purple40)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Nombre: ${args.name}, edad: ${args.age} años",
                                fontSize = 28.sp
                            )

                        }
                    }
                }

            }

            ComposeNavTheme {

            }
        }
    }
}

@Serializable
object MainScreenDestination

@Serializable
object SecondScreenDestination

@Serializable
data class DataScreenDestination(
    val name: String,
    val age: Int
)



