package com.example.testapphostel.present.UI.Reserve

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.example.testapphostel.domian.DataClass.*
import com.example.testapphostel.present.UI.theme.*


@Composable
fun ItemPerson(person: Person) {

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    var text5 by remember { mutableStateOf("") }
    var text6 by remember { mutableStateOf("") }
    person.firstName= text1
    person.secondName=text2
    person.year = text3
    person.citizenship=text4
    person.numberInternationalPassport=text5
    person.termInternationalPassport=text6

    var numberText by remember { mutableStateOf("") }

    numberText = when (person.id) {
        1-> "Первый"
        2-> "Второй"
        3-> "Третий"
        4-> "Четвертый"
        5-> "Пятый"
        6-> "Шестой"
        7-> "Седьмой"
        8-> "Восьмой"
        9-> "Девятый"
        10-> "Десятый"
        else -> " Более 10-ти нельзя."
    }



    var isActive by remember { mutableStateOf(false) }
    val height by animateDpAsState(targetValue = if (isActive) 500.dp else 55.dp)
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(height),
        elevation = CardDefaults.cardElevation(5.dp)
    )
    {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(), contentAlignment = Alignment.CenterStart
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "$numberText турист" ,
                    fontSize = 25.sp, fontWeight = FontWeight.Medium
                )
                IconButton(onClick = { isActive = !isActive }) {
                    if (isActive) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = null)
                    } else {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }
            }
        }
        if (isActive) {

            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            )
            {

                OutlinedTextField(
                    value = (text1),
                    onValueChange = { text1 = (it) },
                    label = { Text(text = "Имя") },
                    placeholder = { Text(text = "Иван", color = Gray) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
            }

            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            )
            {

                OutlinedTextField(
                    value = (text2),
                    onValueChange = { text2 = (it) },
                    label = { Text(text = "Фамилия") },
                    placeholder = { Text(text = "Петров", color = Gray) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
            }

            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            )
            {

                OutlinedTextField(
                    value = (text3),
                    onValueChange = { text3 = (it) },
                    label = { Text(text = "Дата рождения") },
                    placeholder = { Text(text = "11.02.1996", color = Gray) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
            }

            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            )
            {

                OutlinedTextField(
                    value = (text4),
                    onValueChange = { text4 = (it) },
                    label = { Text(text = "Гражданство") },
                    placeholder = { Text(text = "РФ", color = Gray) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
            }

            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            )
            {

                OutlinedTextField(
                    value = (text5),
                    onValueChange = { text5 = (it) },
                    label = { Text(text = "Дата получения загран паспорта") },
                    placeholder = { Text(text = "78-9658-95", color = Gray) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
            }

            Box(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 15.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            )
            {

                OutlinedTextField(
                    value = (text6),
                    onValueChange = { text6 = (it) },
                    label = { Text(text = "Срок действия загран паспорта") },
                    placeholder = { Text(text = "28.02.2026", color = Gray) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
            }
        }

    }
}