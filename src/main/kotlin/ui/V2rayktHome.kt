package ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun V2rayktHome() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
	) {
		Row(
			modifier = Modifier.fillMaxWidth().fillMaxHeight(),
			horizontalArrangement = Arrangement.SpaceBetween,
		) {
			V2rayServerListView()
			Column() {
				V2rayToolbar()

			}
		}
	}
}