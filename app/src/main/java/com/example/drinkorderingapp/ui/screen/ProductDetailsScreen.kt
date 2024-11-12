package com.example.drinkorderingapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.drinkorderingapp.data.DescriptionProductData
import com.example.drinkorderingapp.data.DescriptionProductState
import com.example.drinkorderingapp.data.OrderData
import com.example.drinkorderingapp.data.OrderState
import com.example.drinkorderingapp.data.TitleProductData
import com.example.drinkorderingapp.data.TitleProductState
import com.example.drinkorderingapp.ui.screen.components.OrderActionBar
import com.example.drinkorderingapp.ui.screen.components.ProductBackground
import com.example.drinkorderingapp.ui.screen.components.ProductDescriptionSection
import com.example.drinkorderingapp.ui.screen.components.ProductPreviewSection

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    onReturnBack: () -> Unit,
    onChooseFavorite: () -> Unit,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit,
    onAddProduct: () -> Unit,
    titleProduct: TitleProductState = TitleProductData,
    descriptionProduct: DescriptionProductState = DescriptionProductData,
    state: OrderState
) {
    ProductBackground(
        modifier = Modifier
            .statusBarsPadding()

    )
    Column {
        ProductPreviewSection(
            onReturnBack = onReturnBack,
            onChooseFavorite = onChooseFavorite,
            modifier = Modifier
                .height(284.dp)
                .statusBarsPadding(),
            titleProduct = titleProduct
        )
        ProductDescriptionSection(
            descriptionProduct = descriptionProduct,
        )
    }
    Box(
        modifier = Modifier.fillMaxHeight(),
        contentAlignment = Alignment.BottomCenter
    ) {
        OrderActionBar(
            modifier = modifier
                .navigationBarsPadding(),
            state = state,
            onAddItemClicked = onAddItemClicked,
            onRemoveItemClicked = onRemoveItemClicked,
            onAddProduct = onAddProduct
        )
    }

}




