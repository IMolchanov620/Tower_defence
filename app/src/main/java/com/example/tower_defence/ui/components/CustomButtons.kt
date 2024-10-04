package com.example.tower_defence.ui.components


import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tower_defence.constants.GameConstants

object CustomButtons {
    @Composable
    fun SettingsButton(onClick: () -> Unit) {
        GameConstants.initScreenDimensions()

        Button(
            onClick = onClick,
            modifier = Modifier
                .offset(
                    x = (GameConstants.getButtonOffsetX()).dp, y = (GameConstants.getButtonOffsetY()).dp
                )
                .size(
                    width = (GameConstants.getButtonWidth()).dp,
                    height = (GameConstants.getButtonHeight()).dp
                ), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings Button",
                tint = Color.Black
            )
        }
    }


    @Composable
    fun CloseButton(onClick: () -> Unit) {
        Button(
            onClick = onClick, modifier = Modifier.size(
                width = GameConstants.getButtonWidth().dp,
                height = GameConstants.getButtonHeight().dp
            )
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close Dialog")
        }
    }
}
