package com.example.tower_defence.constants

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

object GameConstants {
    private var buttonWidth = 0f
    private var buttonHeight = 0f
    private var buttonOffsetX = 0f
    private var buttonOffsetY = 0f

    private const val BUTTON_WIDTH_PERCENTAGE = 0.2f // 20% of screen width
    private const val BUTTON_HEIGHT_PERCENTAGE = 0.2f // 20% of screen height
    private const val BUTTON_OFFSET_X_PERCENTAGE = 0.01f // 2% of screen width for X offset
    private const val BUTTON_OFFSET_Y_PERCENTAGE = 0.01f // 2% of screen height for Y offset

    @Composable
    fun initScreenDimensions() {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp
        val screenHeight = configuration.screenHeightDp


        buttonWidth = screenWidth * BUTTON_WIDTH_PERCENTAGE
        buttonHeight = screenHeight * BUTTON_HEIGHT_PERCENTAGE
        buttonOffsetX = screenWidth * BUTTON_OFFSET_X_PERCENTAGE
        buttonOffsetY = screenHeight * BUTTON_OFFSET_Y_PERCENTAGE
    }

    fun getButtonWidth(): Float = buttonWidth
    fun getButtonHeight(): Float = buttonHeight
    fun getButtonOffsetX(): Float = buttonOffsetX
    fun getButtonOffsetY(): Float = buttonOffsetY
}
