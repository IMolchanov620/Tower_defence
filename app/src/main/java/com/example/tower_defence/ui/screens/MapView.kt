package com.example.tower_defence.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tower_defence.R
import com.example.tower_defence.constants.GameConstants.getScreenWidth
import com.example.tower_defence.constants.GameConstants.initScreenDimensions
import com.example.tower_defence.model.MapModel


@Composable
fun DisplayMap(mapModel : MapModel = MapModel(16,8)) {
    val map = mapModel.map
    initScreenDimensions()
    val imageWidth = getScreenWidth() / 8

    Surface(
        modifier = Modifier
    ) {
        Column {
            for (row in map) {
                Row {
                    for (terrain in row) {
                        if (terrain == 1) {
                            Image (
                                painter = painterResource(R.drawable.grass2),
                                contentDescription = null,
                                modifier = Modifier.size(imageWidth.dp)
                            )
                        } else if (terrain == 0) {
                            Image (
                                painter = painterResource(R.drawable.road2),
                                contentDescription = null,
                                modifier = Modifier.size(imageWidth.dp)
                            )
                        } else if (terrain == 3) {
                            Image (
                                painter = painterResource(R.drawable.water2),
                                contentDescription = null,
                                modifier = Modifier.size(imageWidth.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}



@Preview
@Composable
fun MapPreview() {
    DisplayMap()
}


