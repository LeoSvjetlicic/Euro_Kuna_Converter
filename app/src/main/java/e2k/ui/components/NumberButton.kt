package e2k.ui.components

import agency.five.codebase.android.e2k.ui.theme.Gray
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberButton(
    number: Char,
    modifier: Modifier
) {
    Card(
        modifier = modifier.padding(2.dp),
        backgroundColor = Gray,
        elevation = 3.dp,
    ) {
        Text(
            text = number.toString(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.wrapContentSize(Alignment.Center)

        )
    }
}
