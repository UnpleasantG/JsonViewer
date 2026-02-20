package top.college.jsonviewer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import kotlinx.serialization.json.*

@Composable
fun MainView(modifier: Modifier)
{
    val json = LocalContext
        .current
        .assets
        .open("user.json")
        .bufferedReader()
        .use { it.readText() }
    val user = Json.decodeFromString<User>(json)
    val text = "${user.id}: ${user.name}"

    Text(modifier = modifier, text = text)
}