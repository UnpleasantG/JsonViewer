
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import top.college.jsonviewer.User

@Composable
fun List(message: MutableState<String>, messages: MutableList<User>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        LazyColumn(modifier = modifier.fillMaxWidth()) {
            item { Row() { Text(text = "TEXT") } }
            items(messages){msg -> Text(text = msg.name)}
        }

        Text(
            text = message.value,
            modifier = modifier
        )
    }
}