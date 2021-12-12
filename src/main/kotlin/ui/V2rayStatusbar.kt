package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun V2rayktStatusbar() {
	Row(
		modifier = Modifier.fillMaxWidth().fillMaxHeight(),
		verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
		Arrangement.SpaceBetween
	) {
		V2rayKtStatusItem("Status", Icons.Default.Close) {
		}
		Row {
			V2rayKtStatusItem("Http", Icons.Default.Close) {
			
			}
			V2rayKtStatusItem("Socket", Icons.Default.Close) {
			
			}
		}
	}
}

@Composable
fun V2rayKtStatusItem(title: String, icon: ImageVector, onClick: () -> Unit) {
	Row(
		modifier = Modifier.clickable {
			onClick.invoke()
		},
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Icon(icon, contentDescription = title)
		Text(title, modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
	}
}