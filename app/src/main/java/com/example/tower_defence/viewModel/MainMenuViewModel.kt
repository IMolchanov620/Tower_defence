package com.example.tower_defence.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainMenuViewModel : ViewModel() {
    val isSettingsDialogVisible = mutableStateOf(false)


    fun onSettingsButtonClick() {
        isSettingsDialogVisible.value = true
    }

    fun onDialogDismiss() {
        isSettingsDialogVisible.value = false
    }
}
