package e2k.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonRow(
    values: String,
    modifier: Modifier = Modifier,
    addToInput: (Char) -> Unit,
    reset: () -> Unit = {}
) {
    Row(modifier) {
        values.forEach {
            if (it == 'R') {
                ResetButton(modifier = Modifier
                    .weight(1F)
                    .clickable { reset() }
                    .fillMaxSize()
                )
            } else {
                NumberButton(
                    number = it, modifier = Modifier
                        .weight(1F)
                        .clickable {
                            addToInput(it)
                        }
                        .fillMaxSize()
                )
            }
        }
    }
}
