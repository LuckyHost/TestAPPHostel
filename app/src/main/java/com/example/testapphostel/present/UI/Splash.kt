package com.example.testapphostel.present.UI

import android.util.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import com.example.testapphostel.present.*
import com.example.testapphostel.present.UI.theme.*
import kotlinx.coroutines.*

@Composable
fun Splash(myViewModel: ViewModel,navController: NavController) {
    var isLoad = myViewModel.isLoadFile.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Pink40),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {

        Text(
            text = "Loading...",
            color = Color.White,
            fontSize = 25.sp
        )
        LinearProgressIndicator(
            modifier = Modifier
                .width(200.dp)
                .height(4.dp),
            color = PurpleGrey40,
        )

        LaunchedEffect(isLoad.value) {

            if (isLoad.value) {
                delay(1500)
                Log.d("MyLog", "Splash.kt. Splash: ${myViewModel.isLoadFile.value}")
                navController.popBackStack()
                navController.navigate("Hotel")
            }
        }

    }
}