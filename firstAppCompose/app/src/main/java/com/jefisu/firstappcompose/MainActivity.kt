package com.jefisu.firstappcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jefisu.firstappcompose.ui.theme.FirstAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             FirstAppComposeTheme {
                 Conversation(messages = SampleData.conversationSample)
             }
        }
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    FirstAppComposeTheme {
        MessageCard(
            msg = MessageModel(
                "Colleague",
                "Hey, take a look at Jetpack Compose, it's great!"
            )
        )
    }
}

@Preview
@Composable
fun PreviewConversation() {
    FirstAppComposeTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}
