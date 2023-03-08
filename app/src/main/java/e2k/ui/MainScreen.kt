package e2k.ui

import agency.five.codebase.android.e2k.R
import e2k.ui.components.ButtonRow
import agency.five.codebase.android.e2k.ui.theme.MyGreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun MainScreen() {
    val euroValue = 7.5345
    val input = remember { mutableStateListOf<Char>() }
    val euroToKuna = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1F)
                .background(MyGreen),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Euro2Kuna",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
        }
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .weight(1.5F),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (euroToKuna.value) {
                    Text(text = "€", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = (toNumber(input).toDoubleOrNull() ?: (0.0)).toString(),
                        fontSize = 25.sp
                    )
                } else {
                    Text(text = "Kuna", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = (toNumber(input).toDoubleOrNull() ?: (0.0)).toString(),
                        fontSize = 25.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .weight(1.5F),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (euroToKuna.value) {
                    Text(text = "Kuna", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = (((toNumber(input).toDoubleOrNull()
                            ?.times(euroValue * 100.0))?.roundToInt()
                            ?: 0) / 100.0).toString(),
                        fontSize = 25.sp
                    )
                } else {
                    Text(text = "€", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = (((toNumber(input).toDoubleOrNull()?.div(euroValue)
                            ?.times(100.0))?.roundToInt() ?: 0) / 100.0).toString(),
                        fontSize = 25.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.switch_button),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            euroToKuna.value = !euroToKuna.value
                        },
                )
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            if (input.size != 0) {
                                input.removeAt(input.size - 1)
                            }
                        },
                )
            }
            ButtonRow(
                values = "123",
                addToInput = { input.add(it) },
                modifier = Modifier.weight(1F)
            )
            ButtonRow(
                values = "456",
                addToInput = { input.add(it) },
                modifier = Modifier.weight(1F)
            )
            ButtonRow(
                values = "789",
                addToInput = { input.add(it) },
                modifier = Modifier.weight(1F)
            )
            ButtonRow(
                values = "0.R",
                addToInput = { input.add(it) },
                reset = { input.clear() },
                modifier = Modifier.weight(1F)
            )
        }
    }
}

private fun toNumber(numbers: MutableList<Char>) =
    numbers.joinToString().replace(',', ' ').filterNot { it.isWhitespace() }
