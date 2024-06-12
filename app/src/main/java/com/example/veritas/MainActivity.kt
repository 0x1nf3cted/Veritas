package com.example.veritas

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.veritas.ui.screens.HomeScreen
import com.example.veritas.ui.theme.VeritasTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            VeritasTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xFF1C1B1B)
                ) {
                    NavHost(navController = navController, startDestination = Home) {
                        composable<Home>  {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object Home
