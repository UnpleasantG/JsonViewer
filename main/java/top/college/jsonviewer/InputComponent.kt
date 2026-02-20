import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

@Composable
fun Input(label: String, inputText: MutableState<String>, modifier: Modifier) {
    Row(modifier = modifier) {
        Text(
            text = label,
            modifier = modifier
        )
        TextField(
            value = inputText.value,
            onValueChange = {text -> inputText.value = text},
            modifier = modifier
        )

    }
}