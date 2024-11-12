package com.example.drinkorderingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.drinkorderingapp.data.OrderState
import com.example.drinkorderingapp.ui.screen.ProductDetailScreen
import com.example.drinkorderingapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var amount by remember { mutableIntStateOf(0) }

                ProductDetailScreen(
                    onReturnBack = {},
                    onChooseFavorite = {},
                    onRemoveItemClicked = {
                        if (amount > 0) amount = amount.dec()
                    },
                    onAddItemClicked = {
                        amount = amount.inc()
                    },
                    onAddProduct = {},
                    state = OrderState(
                        amount = amount
                    )
                )
            }
        }
    }
}

