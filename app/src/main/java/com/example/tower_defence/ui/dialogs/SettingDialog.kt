package com.example.tower_defence.ui.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.tower_defence.viewmodel.MainMenuViewModel

@Composable
fun SettingsDialog(onDismiss: () -> Unit, viewModel: MainMenuViewModel) {
    GameConstants.initScreenDimensions()

    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties()
    ) {
        Surface(
            modifier = Modifier.size((GameConstants.getButtonWidth() * 3).dp, (GameConstants.getButtonHeight()).dp),
        ) {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                CustomButtons.CloseButton(onClick = { onDismiss() })
            }
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 3 empty buttons
                CustomButtons.SoundButton(
                    onClick = { viewModel.toggleSound() }
                )


                Button(onClick = {}, modifier = Modifier.padding(top = 0.dp)) {
                    Text(text = "2")
                }
                Button(onClick = {}, modifier = Modifier.padding(top = 0.dp)) {
                    Text(text = "3")
                }
            }
        }
    }
}