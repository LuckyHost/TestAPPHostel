package com.example.testapphostel.present

import android.os.Bundle
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.testapphostel.present.UI.*
import com.example.testapphostel.present.UI.Hostel.*
import com.example.testapphostel.present.UI.Room.*
import dagger.hilt.android.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel:ViewModel by viewModels()
        viewModel.getDataHostel()
        setContent {

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "Splash" ){


                composable("Splash"){
                    Splash( viewModel,navController)

                }

                composable("Hotel"){
                    ItemHotel( viewModel,navController)

                }
                composable("Room/{nameHostel}"
                    ,arguments = listOf(navArgument("nameHostel") { type = NavType.StringType })
                ) { entry ->
                    // Используйте значение аргумента для отображения данных
                    val nameHostel = entry.arguments?.getString("nameHostel")
                    Rooms(viewModel = viewModel, navController = navController,nameHostel ?: "Hostel")
                }


                composable("Reserve"){

                }

                composable("Pay"){

                }


            }

        }
    }
}


