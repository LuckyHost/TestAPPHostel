package com.example.testapphostel.present

import android.os.Bundle
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.example.testapphostel.present.UI.*
import dagger.hilt.android.*
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel:ViewModel by viewModels()
        viewModel.getData()
        setContent {

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "Splash" ){


                composable("Splash"){
                    Splash( viewModel,navController)

                }

                composable("Hotel"){
                    ItemHotel(viewModel = viewModel)

                }
                composable("Room"){

                }
                composable("Rezerv"){

                }

                composable("Pay"){

                }


            }

        }
    }
}


