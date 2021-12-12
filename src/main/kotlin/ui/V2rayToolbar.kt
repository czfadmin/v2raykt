package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun V2rayToolbar() {
    Row(modifier = Modifier.fillMaxWidth().background(Color.LightGray)) {
        IconButton(onClick = {}) {
            Icon(Icons.Default.Send, contentDescription = "Run")
        }

    }
}