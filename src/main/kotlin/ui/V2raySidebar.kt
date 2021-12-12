package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun V2raySidebar(navItemState: MutableState<V2rayktNavType>) {
	val isCollapse = remember { mutableStateOf(false) }
	Column(
		modifier = Modifier
			.fillMaxHeight()
			.width(if (isCollapse.value) 48.dp else 160.dp)
			.background(Color.LightGray),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Top
		) {
			V2rayktSidebarHeader(isCollapse.value) {
				isCollapse.value = !isCollapse.value
			}
			V2rayktNavItem(
				"Home",
				Icons.Default.Home,
				"Home",
				navItemState.value == V2rayktNavType.Home,
				isCollapse.value
			) {
				navItemState.value = V2rayktNavType.Home
			}
			V2rayktNavItem(
				"Dashboard",
				Icons.Default.Info,
				"Dashboard",
				navItemState.value == V2rayktNavType.Dashboard,
				isCollapse.value
			) {
				navItemState.value = V2rayktNavType.Dashboard
			}
		}
		V2rayktNavItem(
			"Settings",
			Icons.Default.Settings,
			"Setting",
			navItemState.value == V2rayktNavType.Settings,
			isCollapse.value
		) {
			navItemState.value = V2rayktNavType.Settings
		}
	}

}

@Composable
fun V2rayktSidebarHeader(
	isCollapse: Boolean,
	onClick: () -> Unit
) {
	if (!isCollapse) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.defaultMinSize(minHeight = 48.dp)
				.clickable { onClick.invoke() },
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center,
		) {
			Text("V2raykt Compose")
		}
	} else {
		IconButton(onClick = {
			onClick.invoke()
		}) {
			Icon(Icons.Default.Menu, contentDescription = "Open Sidebar")
		}
	}
}

@Composable
fun V2rayktNavItem(
	title: String,
	icon: ImageVector,
	contentDescription: String,
	selected: Boolean,
	isCollapse: Boolean,
	onClick: () -> Unit
) {
	val horizontalAlignment = if (isCollapse) Arrangement.Center else Arrangement.Start
	Row(
		modifier = Modifier.fillMaxWidth()
			.defaultMinSize(minHeight = 48.dp)
			.clickable {
				onClick.invoke()
			},
		horizontalArrangement = horizontalAlignment,
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			imageVector = icon,
			contentDescription = contentDescription,
			modifier = Modifier
				.padding(2.dp)
		)
		if (!isCollapse) {
			Text(title, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
		}

	}
}

