// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.*


@ExperimentalComposeUiApi
fun main() = application {
	val trayIcon = painterResource("tray-icon.jpg")
	var action by remember { mutableStateOf("") }
	Tray(
		icon = trayIcon,
		menu = {
			Item("Start Server", onClick = {})
			Item("Proxy", onClick = {})
			Separator()
			Item("Quit App", onClick = ::exitApplication)
		}
	)
	
	Window(title = "V2rayKT", icon = trayIcon, onCloseRequest = ::exitApplication) {
		V2rayktApp()
	}
}

@Composable
@Preview
fun V2rayktApp() {
	val v2rayktNavItemState = remember {
		mutableStateOf(V2rayktNavType.Home)
	}
	DesktopMaterialTheme {
		Box(modifier = Modifier.defaultMinSize(720.dp, 640.dp)) {
			Row(modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
				V2raySidebar(v2rayktNavItemState)
				V2rayktBodyContent(v2rayktNavItemState)
			}
		}
	}
}

@Composable
fun V2rayktBodyContent(v2rayktNavType: MutableState<V2rayktNavType>) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight(),
		) {
		when (v2rayktNavType.value) {
			V2rayktNavType.Home -> V2rayktHome()
			V2rayktNavType.Dashboard -> V2rayktDashboard()
			V2rayktNavType.Settings -> V2rayktSettings()
		}
	}
	
}