package dev.sobhy.bmsession

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.sobhy.bmsession.ui.theme.BMSessionTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            BMSessionTheme {
                Column {
                    TextField(value = text, onValueChange = {text = it})
                    Button(onClick = {
                        val intent = Intent("dev.sobhy.bmsession.MY_ACTION")
                        intent.putExtra("textvalue", text)
                        startActivity(intent)
                    }) {
                        Text(text = "Send")
                    }
                }

            }
        }
    }
}
