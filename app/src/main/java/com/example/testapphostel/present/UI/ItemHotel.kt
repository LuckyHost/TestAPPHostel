package com.example.testapphostel.present.UI

import android.icu.text.*
import android.icu.util.*
import android.util.*
import android.widget.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import coil.compose.*
import com.example.testapphostel.R
import com.example.testapphostel.data.*
import com.example.testapphostel.data.NET.*
import com.example.testapphostel.domian.DataClass.*
import com.example.testapphostel.present.*
import com.example.testapphostel.present.UI.theme.*
import com.skydoves.sandwich.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemHotel(
    viewModel: ViewModel,
) {

    val listImages = viewModel.listImages.collectAsState()
    val item = viewModel.hostel.collectAsState()
    val pagerState = rememberPagerState()
    val price = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()




    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    )
    {
        Column {


            Card(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 5.dp, bottom = 5.dp),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
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
                    ) {
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
                                text = item.value?.rating?.toString() ?: "5",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                color = RatingText,
                                modifier = Modifier
                                    .padding(start = 2.dp)
                            )
                            Text(
                                text = item.value?.rating_name ?: "Превосходно",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                color = RatingText,
                                modifier = Modifier
                                    .padding(start = 5.dp, end = 5.dp)
                            )
                        }
                    }
                    Text(
                        text = item.value?.name ?: "Лучший пятизвездочный отель в Хургаде, Египет",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )

                    Text(
                        text = item.value?.adress
                            ?: "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
                        fontSize = 15.sp,
                        color = Blue,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 5.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
                    )
                    {
                         price.value = ((item.value?.minimal_price?.toString()) ?: "134268").chunked(3).joinToString(" ") { it }

                       Text(
                            text = ("от ${price.value} ₽"),
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                        Text(
                            text = item.value?.price_for_it ?: "За тур с перелётом",
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
                                val list= item.value?.about_the_hotel?.peculiarities ?: listOf("Бесплатный Wifi на всей территории отеля", "1 км до пляжа","Бесплатный фитнес-клуб","20 км до аэропорта")

                            items(list){

                                    Card(
                                        modifier = Modifier
                                            .padding(5.dp),
                                        elevation = CardDefaults.cardElevation(5.dp)
                                    )
                                    {
                                        Text(modifier = Modifier
                                            .padding(5.dp)
                                            .wrapContentWidth(align = Alignment.Start)
                                            , text = it)

                                    }
                            }
                        }
                    }
                }

                Text(
                    modifier = Modifier
                        .padding(start = 15.dp, bottom = 15.dp),
                    text = item.value?.about_the_hotel?.description
                        ?: "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
                    fontSize = 18.sp, fontWeight = FontWeight.W200
                )


            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth(1f)
//                    .fillMaxHeight(0.5f)
                .padding(top = 5.dp, bottom = 5.dp),
            shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
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
                    onClick = { /*TODO*/ })
                {
                    Text(text = "К выбору отеля")

                }
            }

        }

    }
    }


@Preview(showBackground = true)
@Composable
fun ItemHotelPreview() {

    val api = MockApi()
    val repository = MockRepository(api)
    val viewModel = MockViewModel(repository)
    ItemHotel(viewModel)
}

class MockRepository(apiService: APIService) : Repository(apiService) {
    // ...
}

class MockApi : APIService {
    // ...
    override suspend fun getDataHostel(): ApiResponse<Hostels> {
        TODO("Not yet implemented")
    }
}

class MockViewModel(repo: Repository) : ViewModel(repo) {
    // ...
}