package com.example.testapphostel.present.UI.Room

import android.util.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import coil.compose.*
import com.example.testapphostel.R
import com.example.testapphostel.domian.DataClass.*
import com.example.testapphostel.present.*
import com.example.testapphostel.present.UI.theme.*

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ItemRoom(viewModel: ViewModel, room: Room, navController: NavController) {

    val pagerState = rememberPagerState()
    val trig = remember { mutableStateOf(false)    }



        Card(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp),
            shape = RoundedCornerShape(
                topStart = 15.dp,
                topEnd = 15.dp,
                bottomStart = 15.dp,
                bottomEnd = 15.dp
            ),
            elevation = CardDefaults.cardElevation(5.dp)
        )
        {
            Column(modifier = Modifier.padding(top = 15.dp))
            {


                Box(
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                )
                {

                    HorizontalPager(
                        pageCount = room.image_urls.size,
                        state = pagerState,
                        modifier = Modifier
                            .zIndex(0f)
                            .height(250.dp)

                    )
                    {

                        AsyncImage(
                            model = room.image_urls[it],
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                                .clip(RoundedCornerShape(8)),
                            placeholder = painterResource(R.drawable.baseline_cloud_sync_24),
                            error = painterResource(R.drawable.baseline_plagiarism_24),
                            onError = { Log.d("MyLog", "ItemRoom.kt. ItemRoom: Error") },
                            contentScale = ContentScale.FillBounds
                        )

                    }

                    Row(
                        Modifier
                            .height(25.dp)
                            .align(Alignment.BottomCenter)
                            .zIndex(1f),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .alpha(0.7f)
                                .clip(CircleShape)
                                .background(Color.White)
                        ) {
                            Row {
                                repeat(room.image_urls.size) { iteration ->
                                    val color =
                                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                                    val size =
                                        if (pagerState.currentPage == iteration) 7.dp else 5.dp

                                    Box(
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .clip(CircleShape)
                                            .background(color)
                                            .size(size)

                                    )
                                }
                            }
                        }


                    }

                }
                Text(
                    text = room.name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
                Row(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp)
                )
                {
                    LazyRow {
                        val list = room.peculiarities


                        items(list) {

                            Card(
                                modifier = Modifier
                                    .padding(5.dp),
                                elevation = CardDefaults.cardElevation(5.dp)
                            )
                            {
                                Text(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .wrapContentWidth(align = Alignment.Start), text = it
                                )

                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                        .clip(RoundedCornerShape(25))
                        .height(30.dp)
                        .background(BlueClick), contentAlignment = Alignment.Center
                )
                {
                    Row {

                        Text(
                            text = "Подробнее о номере",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            color = Blue,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp)
                        )
                        Icon(
                            painter = painterResource(R.drawable.frame_579_vector_55),
                            contentDescription = null,
                            modifier = Modifier
                                .size(18.dp)
                                .padding(end = 10.dp),
                            tint = Blue
                        )

                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(10.dp)
                )
                {
                    val price = (room.price.toString()).chunked(3).joinToString(" ") { it }

                    Text(
                        text = ("от ${price} ₽"),
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    Text(
                        text = room.price_per,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier
                            .padding(start = 16.dp),
                        color = Gray
                    )
                }
            }
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
                .fillMaxHeight()
                .padding(20.dp),
                shape = customShape,
                colors = customColors,
                onClick = {  trig.value=!trig.value;navController.navigate("Reserve") })
            {
                Text(
                    text = "Выбрать номер", fontSize = 16.sp
                )

            }
        }
    LaunchedEffect(trig.value)
    {
        viewModel.getDataRezerv()

    }
    }







