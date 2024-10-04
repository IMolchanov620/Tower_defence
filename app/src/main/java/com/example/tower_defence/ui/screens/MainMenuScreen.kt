package com.example.tower_defence.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tower_defence.ui.components.CustomButtons
import com.example.tower_defence.ui.dialogs.SettingsDialog
import com.example.tower_defence.viewmodel.MainMenuViewModel

@Composable
fun MainMenuScreen(viewModel: MainMenuViewModel = viewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue
    ) {
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            CustomButtons.SettingsButton(
                onClick = { viewModel.onSettingsButtonClick() }
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            if (viewModel.isSettingsDialogVisible.value) {
                SettingsDialog(onDismiss = { viewModel.onDialogDismiss() })
            }
        }
    }
}

/*
@Composable
fun MainMenuScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Red
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val isPressed = remember { mutableStateOf(false) }
            val buttonSize = animateDpAsState(targetValue = if (isPressed.value) 120.dp else 100.dp)

            Button(
                onClick = { isPressed.value = !isPressed.value },
                modifier = Modifier.size(buttonSize.value)
            ) {
                Text(text = "Click Me")
            }
        }
    }
}
*/


/*
@Composable
fun MainMenuScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Red
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val isPressed = remember { mutableStateOf(false) }
            val buttonColor = if (isPressed.value) Color.Green else Color.Blue

            Button(
                onClick = { isPressed.value = !isPressed.value },
                modifier = Modifier
                    .padding(start = 100.dp)// start/end/Center
                    .size(100.dp),
                colors = buttonColors(containerColor = buttonColor)
            ) {
                Text(text = "Click Me")
            }
        }
    }
  }
 */
