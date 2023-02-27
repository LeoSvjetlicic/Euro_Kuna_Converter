package agency.five.codebase.android.e2k.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonRow(
    values: String,
    modifier: Modifier = Modifier,
    addToInput: (Char) -> Unit
) {
    Row(modifier) {
        values.forEach {
            NumberButton(
                number = it, modifier = Modifier
                    .width(130.dp)
                    .height(105.dp)
                    .clickable {
                        addToInput(it)
                    }
            )
        }

    }
}
