package com.example.testapphostel.present.UI.Room

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.res.*
import androidx.navigation.*
import com.example.testapphostel.R
import com.example.testapphostel.present.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Rooms(viewModel: ViewModel, navController: NavController, nameHostel: String?) {
    val listRoom = viewModel.listRoom.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                painterResource(id = R.drawable.vector_55),
                                contentDescription = null,
                                modifier = Modifier.rotate(180f)
                            )
                        }


                        Text(nameHostel.toString())


                    }
                }
            )
        }
    ) {padding ->
        LazyColumn( modifier = Modifier.padding(padding)) {
            items(listRoom.value!!) {
                ItemRoom(viewModel = viewModel, room = it, navController)
            }
        }
    }
}