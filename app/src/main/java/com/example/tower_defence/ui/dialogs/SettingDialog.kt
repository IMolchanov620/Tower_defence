package com.example.tower_defence.ui.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.tower_defence.constants.GameConstants
import com.example.tower_defence.ui.components.CustomButtons

@Composable
fun SettingsDialog(onDismiss: () -> Unit) {
    GameConstants.initScreenDimensions()

    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties()
    ) {
        Surface(
            modifier = Modifier.size((GameConstants.getButtonWidth() * 3).dp, (GameConstants.getButtonHeight() * 2).dp),
        ) {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                CustomButtons.CloseButton(onClick = { onDismiss() })
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 3 empty buttons
                Button(onClick = {}) {
                    Text(text = "Option 1")
                }
                Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
                    Text(text = "Option 2")
                }
                Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
                    Text(text = "Option 3")
                }
            }
        }
    }
}