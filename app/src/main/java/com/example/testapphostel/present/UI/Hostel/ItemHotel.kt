package com.example.testapphostel.present.UI.Hostel

import android.util.*
import android.widget.*
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
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import androidx.navigation.compose.*
import coil.compose.*
import com.example.testapphostel.R
import com.example.testapphostel.data.*
import com.example.testapphostel.data.NET.*
import com.example.testapphostel.domian.DataClass.*
import com.example.testapphostel.present.*
import com.example.testapphostel.present.UI.theme.*
import com.skydoves.sandwich.*

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ItemHotel(
    viewModel: ViewModel,navController: NavController
) {

    val listImages = viewModel.listImages.collectAsState()
    val itemHostel = viewModel.hostel.collectAsState()
    val pagerState = rememberPagerState()
    val price = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val trig = remember { mutableStateOf(false)    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                            ,horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Отель")
                    }
                }
            )
        }
    ){ it

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(it)
    )
    {
        Column {


            Card(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 5.dp, bottom = 5.dp),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp, bottomStart = 15.dp, bottomEnd = 15.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            )
            {
                Column {
                    Box(
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                            .fillMaxHeight(0.28f)
                    )
                    {

                        HorizontalPager(
                            pageCount = listImages.value!!.size,
                            state = pagerState,
                            modifier = Modifier
                                .zIndex(0f)
                                .height(220.dp)

                        )
                        {
                            AsyncImage(
                                model = listImages.value!![it],
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                                    .clip(RoundedCornerShape(8)),
                                placeholder = painterResource(androidx.core.R.drawable.ic_call_answer_video_low)
                            )


                            Log.d("MyLog", "ItemHotel.kt. ItemHotel: ${listImages.value}")
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
                                Row() {
                                    repeat(listImages.value!!.size) { iteration ->
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

                    Box(
                        modifier = Modifier
                            .padding(20.dp, end = 20.dp)
                            .clip(RoundedCornerShape(25))
                            .height(30.dp)
                            .background(Rating), contentAlignment = Alignment.Center
                    )
                    {
                        Row {
                            Icon(
                                painter = painterResource(R.drawable.star),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(start = 5.dp),
                                tint = RatingText
                            )

                            Text(
                                text = itemHostel.value?.rating?.toString() ?: "5",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                color = RatingText,
                                modifier = Modifier
                                    .padding(start = 2.dp)
                            )
                            Text(
                                text = itemHostel.value?.rating_name ?: "Превосходно",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                color = RatingText,
                                modifier = Modifier
                                    .padding(start = 5.dp, end = 5.dp)
                            )
                        }
                    }
                    Text(
                        text = itemHostel.value?.name ?: "Лучший пятизвездочный отель в Хургаде, Египет",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )

                    Text(
                        text = itemHostel.value?.adress
                            ?: "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
                        fontSize = 15.sp,
                        color = Blue,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 5.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "Переход", Toast.LENGTH_LONG)
                                    .show()
                            }
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
                    )
                    {
                         price.value = ((itemHostel.value?.minimal_price?.toString()) ?: "134268").chunked(3).joinToString(" ") { it }

                       Text(
                            text = ("от ${price.value} ₽"),
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = itemHostel.value?.price_for_it ?: "За тур с перелётом",
                            fontSize = 16.sp,
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
                    .fillMaxWidth(1f)
//                    .fillMaxHeight(0.5f)
                    .padding(top = 5.dp, bottom = 5.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            )
            {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(start = 14.dp,top=15.dp),
                        text = "Об отеле",
                        fontSize = 25.sp, fontWeight = FontWeight.Medium
                    )
                    Box(
                        Modifier
                            .fillMaxHeight(0.01f)
                            .padding(start = 15.dp, end = 15.dp)
                    )
                    {
                        LazyRow() {
                            val list = itemHostel.value?.about_the_hotel?.peculiarities ?: listOf(
                                "Бесплатный Wifi на всей территории отеля",
                                "1 км до пляжа",
                                "Бесплатный фитнес-клуб",
                                "20 км до аэропорта"
                            )

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
                }

                Text(
                    modifier = Modifier
                        .padding(start = 15.dp, bottom = 15.dp),
                    text = itemHostel.value?.about_the_hotel?.description
                        ?: "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
                    fontSize = 18.sp, fontWeight = FontWeight.W200
                )

                Card(
                    modifier = Modifier
                        .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
                        .fillMaxWidth()
                )
                {
                    Box(modifier = Modifier.fillMaxWidth())
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {

                            Image(
                                painter = painterResource(R.drawable.emoji_happy),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(start = 10.dp)
                            ) {

                                Column {
                                    Text(
                                        text = "Удобство",
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        color = Gray, text = "Самое необходимое"
                                    )

                                }
                            }
                            Image(
                                painter = painterResource(R.drawable.vector_55),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                    }

                    Box(modifier = Modifier.fillMaxWidth())
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {

                            Image(
                                painter = painterResource(R.drawable.tick_square),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(start = 10.dp)
                            ) {


                                Column {
                                    Text(
                                        text = "Что включено",
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        color = Gray, text = "Самое необходимое"
                                    )

                                }
                            }
                            Image(
                                painter = painterResource(R.drawable.vector_55),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                    }
                    Box(modifier = Modifier.fillMaxWidth())
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {

                            Image(
                                painter = painterResource(R.drawable.close_square),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(start = 10.dp)
                            ) {


                                Column {
                                    Text(
                                        text = "Что не включено",
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        color = Gray, text = "Самое необходимое"
                                    )

                                }
                            }
                            Image(
                                painter = painterResource(R.drawable.vector_55),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                    }

                }


            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth(1f)
//                    .fillMaxHeight(0.5f)
                .padding(top = 5.dp, bottom = 5.dp),
            shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp, topEnd = 15.dp , topStart = 15.dp),
            elevation = CardDefaults.cardElevation(5.dp)
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
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
                    onClick = { android.util.Log.d("MyLog","ItemHotel.kt. ItemHotel: ${itemHostel.value?.name}")
                        trig.value=!trig.value;navController.navigate("Room/${itemHostel.value?.name}") })
                {
                    Text(
                        text = "К выбору номера"
                        , fontSize = 16.sp
                    )

                }
            }

        }

    }
    }
    LaunchedEffect(trig.value)
    {
        viewModel.getDataRoom()

    }
}

