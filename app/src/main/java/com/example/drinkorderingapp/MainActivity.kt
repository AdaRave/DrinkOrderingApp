package com.example.drinkorderingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.drinkorderingapp.ui.screen.ProductDetailScreen
import com.example.drinkorderingapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                ProductDetailScreen(
                    onBack = {},
                    onLikeItem = {}
                )
            }
        }
    }
}

