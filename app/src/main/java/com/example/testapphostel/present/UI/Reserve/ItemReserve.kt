package com.example.testapphostel.present.UI.Reserve

import android.widget.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.modifier.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import com.example.testapphostel.present.*
import com.example.testapphostel.present.UI.Room.*
import com.example.testapphostel.present.UI.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemReserve(viewModel: ViewModel, navController: NavHostController) {

    val itemHostel = viewModel.reservList.collectAsState()
    val fullPrice= remember { mutableStateOf(0)   }

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
                                painterResource(id = com.example.testapphostel.R.drawable.vector_55),
                                contentDescription = null,
                                modifier = Modifier.rotate(180f)
                            )
                        }
                        Text(
                            text = "Бронирование",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 18.dp)
                        )


                    }
                }
            )
        }
    ) { padding ->
        Column()
        {
            Card(
                modifier = Modifier
                    .padding(padding),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Column(modifier = Modifier.padding(top = 15.dp))
                {
                    Row {
                        Icon(
                            painter = painterResource(com.example.testapphostel.R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .padding(start = 5.dp),
                            tint = RatingText
                        )

                        Text(
                            text = itemHostel.value?.horating?.toString() ?: "5",
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
                    Text(
                        text = itemHostel.value?.hotel_name
                            ?: "Лучший пятизвездочный отель в Хургаде, Египет",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )

                    Text(
                        text = itemHostel.value?.hotel_adress
                            ?: "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
                        fontSize = 15.sp,
                        color = Blue,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 15.dp, bottom = 15.dp)
                            .clickable {

                            }
                    )
                }
            }
            Card(
                modifier = Modifier
                    .padding(top=5.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            )
            {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    )
                    {

                    Box(modifier = Modifier.fillMaxWidth(0.4f)){


                        Text(
                            text = "Вылет из : ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                            color = Gray
                        )
                    }
                        Text(
                            text = itemHostel.value?.departure!!,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    )
                    {

                        Box(modifier = Modifier.fillMaxWidth(0.4f)){


                            Text(
                                text = "Страна, город : ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                        }
                        Text(
                            text = itemHostel.value?.arrival_country!!,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    )
                    {

                        Box(modifier = Modifier.fillMaxWidth(0.4f)){


                            Text(
                                text = "Даты : ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                        }
                        Text(
                            text = ("${itemHostel.value?.tour_date_start!!} - ${itemHostel.value?.tour_date_stop!!}"),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    )
                    {

                        Box(modifier = Modifier.fillMaxWidth(0.4f)){


                            Text(
                                text = "Кол-во ночей : ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                        }
                        Text(
                            text = itemHostel.value?.number_of_nights.toString()!!,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    )
                    {

                        Box(modifier = Modifier.fillMaxWidth(0.4f)){


                            Text(
                                text = "Отель : ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                        }
                        Text(
                            text = itemHostel.value?.hotel_name!!,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    )
                    {

                        Box(modifier = Modifier.fillMaxWidth(0.4f)){


                            Text(
                                text = "Номер ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                        }
                        Text(
                            text = itemHostel.value?.room!!,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    )
                    {

                        Box(modifier = Modifier.fillMaxWidth(0.4f)){


                            Text(
                                text = "Питание : ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                        }
                        Text(
                            text = itemHostel.value?.nutrition!!,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }

            }

            Card(
                modifier = Modifier
                    .padding(5.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            )
            {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {


                        Text(
                            text = "Тур",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                            color = Gray
                        )
                        Text(
                            text = ((itemHostel.value?.tour_price?.toString())?.chunked(3)
                                ?.joinToString(" ") { it }
                                .toString() + " ₽"),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            modifier = Modifier
                                .padding(start = 16.dp),
                        )
                    }
                }
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )
                    {
                        Row(modifier = Modifier.fillMaxWidth()
                            ,horizontalArrangement=Arrangement.SpaceBetween
                        ) {


                            Text(
                                text = "Топливный сбор",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                            Text(
                                text = ((itemHostel.value?.fuel_charge?.toString())?.chunked(3)?.joinToString(" ") { it    }
                                    .toString() +" ₽"),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                            )
                        }
                    }
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )
                    {
                        Row(modifier = Modifier.fillMaxWidth()
                            ,horizontalArrangement=Arrangement.SpaceBetween
                        ) {


                            Text(
                                text = "Сервисный сбор",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                            Text(
                                text = ((itemHostel.value?.service_charge?.toString())?.chunked(3)?.joinToString(" ") { it    }
                                    .toString() +" ₽"),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                            )
                        }
                    }
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )
                    {
                        Row(modifier = Modifier.fillMaxWidth()
                            ,horizontalArrangement=Arrangement.SpaceBetween
                        ) {
                            fullPrice.value = (itemHostel.value?.tour_price!! + itemHostel.value?.service_charge!! + itemHostel.value?.fuel_charge!!)

                            Text(
                                text = "К оплате",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                color = Gray
                            )
                            Text(
                                text = ((fullPrice.value.toString())?.chunked(3)?.joinToString(" ") { it    }
                                    .toString() +" ₽"),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                            )
                        }
                    }

            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
//                    .fillMaxHeight(0.5f)
                    .padding(top = 15.dp, bottom = 5.dp),
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
                        .height(70.dp)
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
                        onClick = { }
                    )
                    {
                        Text(
                            text = ( "Оплатить "+ (fullPrice.value.toString())?.chunked(3)?.joinToString(" ") { it    }
                                .toString() +" ₽")
                            , fontSize = 16.sp
                        )

                    }
                }

            }


        }
    }
}
