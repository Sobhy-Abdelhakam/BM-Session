package dev.sobhy.bmsession.mainscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    LazyColumn(content = {
        items(10){
            createItem()
            Divider(modifier = Modifier.padding(6.dp))
            Spacer(modifier = Modifier.padding(4.dp))
        }
    })
}

@Composable
fun createItem() {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = "name", fontWeight = FontWeight.Bold)
        Text(text = "Description")
    }
}