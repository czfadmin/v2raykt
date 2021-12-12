package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun V2rayServerListView() {

}


@Composable
fun V2rayServerListItem(title: String, onItemClick: () -> Unit) {
	Row(
		modifier = Modifier.fillMaxWidth().clickable { onItemClick() },
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(title)
	}
}