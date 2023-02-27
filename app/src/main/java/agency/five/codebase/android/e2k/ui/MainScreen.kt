package agency.five.codebase.android.e2k.ui

import agency.five.codebase.android.e2k.R
import agency.five.codebase.android.e2k.ui.components.ButtonRow
import agency.five.codebase.android.e2k.ui.components.EqualsButton
import agency.five.codebase.android.e2k.ui.components.NumberButton
import agency.five.codebase.android.e2k.ui.theme.MyGreen
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow
import kotlin.math.roundToInt

@Composable
fun MainScreen() {
    val euroValue = 7.5345
    val input = remember { mutableStateListOf<Char>() }
    val euroToKuna = remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(MyGreen),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Euro2Kuna",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(120.dp),
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
                .height(120.dp),
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
        ButtonRow(values = "123",
            addToInput = { input.add(it) }
        )
        ButtonRow(values = "456",
            addToInput = { input.add(it) }
        )
        ButtonRow(values = "789",
            addToInput = { input.add(it) }
        )
        Row() {
            ButtonRow(values = "0.",
                addToInput = {
                    if (!input.contains('.')) {
                        input.add(it)
                    }
                }
            )
            EqualsButton(modifier = Modifier
                .height(105.dp)
                .width(130.dp)
                .clickable { input.clear() })
        }
    }
}

fun toNumber(numbers: MutableList<Char>) =
    numbers.joinToString().replace(',', ' ').filterNot { it.isWhitespace() }
