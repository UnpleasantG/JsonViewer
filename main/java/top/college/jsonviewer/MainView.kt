package top.college.jsonviewer

import Input
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import kotlinx.serialization.json.*

@Composable
fun MainView(modifier: Modifier)
{
    val buffer = remember{mutableStateOf("")}
    val bufferId = remember{mutableStateOf("")}
    val message = remember{mutableStateOf("")}
    val messageId = remember{mutableStateOf("")}
    val messages = remember { mutableStateListOf<User>() }

    val json = LocalContext
        .current
        .assets
        .open("user.json")
        .bufferedReader()
        .use { it.readText() }
    val user = Json.decodeFromString<User>(json)
    messages.add(user)



    Column(modifier = modifier) {

        LazyColumn(modifier = modifier.fillMaxWidth()) {
            item { Row() { Text(text = "TEXT") } }
            items(messages){msg -> Text(text = msg.name)}
        }



        Input(label = "name", inputText = message, modifier = modifier)
        Input(label = "Id", inputText = messageId, modifier = modifier)
        Button(
            content = {Text (text = "Сохранить")},
            modifier = modifier,
            onClick = {
                message.value = buffer.value
                messageId.value = bufferId.value
                messages.add(User(bufferId.value, buffer.value))
            }
        )
    }
}