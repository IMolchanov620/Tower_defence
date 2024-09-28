package com.example.tower_defence

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tower_defence.ui.theme.Tower_DefenceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tower_DefenceTheme {
                // A surface container with gray background color
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFB0BEC5)  // Custom gray color
                ) {
                    CounterApp()  // Calling the function to display the app
                }
            }
        }
    }
}

@Composable
fun CounterApp() {
    // State variable to keep track of the counter
    var count by remember { mutableStateOf(0) }

    // UI layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        // Text to display the current counter value
        Text(text = "Counter: $count", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Button to increase the counter
        Button(onClick = { count++ }) {
            Text(text = "Increase Counter")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tower_DefenceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFB0BEC5)  // Custom gray color
        ) {
            CounterApp()  // Preview of the function that renders the UI
        }
    }
}
