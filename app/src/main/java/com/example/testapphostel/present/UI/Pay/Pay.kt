package com.example.testapphostel.present.UI.Pay

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import com.example.testapphostel.R
import com.example.testapphostel.present.*
import com.example.testapphostel.present.UI.theme.*
import kotlin.random.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pay(viewModel: ViewModel, navController: NavHostController) {
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
                        Text(
                            text = "Заказ оплачен",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 18.dp)
                        )


                    }
                }
            )
        }
    )
    {

        Box(
            Modifier
                .padding(it)
                .fillMaxSize(1f)
        )
        {

            Column {
                Card(
                    modifier = Modifier
                        .fillMaxHeight(0.9f)
                        .padding(5.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(5.dp)
                )
                {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.frame_610),
                                contentDescription = null
                            )

                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            contentAlignment = Alignment.Center
                        )
                        {

                            Text(
                                text = "Ваш заказ принят в работу",
                                fontSize = 25.sp, fontWeight = FontWeight.Medium
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Text(
                                text = "Подтверждение заказа № ${Random.nextLong(55555,99999999)} может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                        }
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
//                    .fillMaxHeight(0.5f)
                        .padding(5.dp),
                    shape = RoundedCornerShape(
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp,
                        topEnd = 15.dp,
                        topStart = 15.dp
                    ),
                    elevation = CardDefaults.cardElevation(5.dp)
                )
                {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        val customShape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )

                        val customColors = ButtonDefaults.buttonColors(
                            containerColor = Blue,
                            contentColor = Color.White
                        )

                        Button(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                            shape = customShape,
                            colors = customColors,
                            onClick = {navController.popBackStack("Hotel",false) }
                        )
                        {
                            Text(
                                text = "Супер!"
                            )

                        }
                    }
                }
            }
        }
    }
}
