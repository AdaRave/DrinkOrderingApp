package com.example.drinkorderingapp.ui.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.drinkorderingapp.R
import com.example.drinkorderingapp.data.TitleProductData
import com.example.drinkorderingapp.data.TitleProductState
import com.example.drinkorderingapp.ui.theme.AppTheme

@Composable
fun ProductPreviewSection(
    modifier: Modifier = Modifier,
    onReturnBack: () -> Unit,
    onChooseFavorite: () -> Unit,
    titleProduct: TitleProductState

) {
    Box(modifier = modifier.fillMaxSize()) {

        Content(
            onReturnBack = onReturnBack,
            onChooseFavorite = onChooseFavorite,
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 14.dp),
            titleProduct = titleProduct
        )
    }
}


@Composable
private fun Content(
    modifier: Modifier = Modifier,
    onReturnBack: () -> Unit,
    onChooseFavorite: () -> Unit,
    titleProduct: TitleProductState
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        val (actionBar, nameProduct, typeProduct, priceProduct) = createRefs()

        ActionBar(
            onBack = onReturnBack,
            onLikeItem = onChooseFavorite,
            modifier = Modifier
                .statusBarsPadding()
                /*    .padding(horizontal = 20.dp)*/
                .constrainAs(actionBar) {
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = titleProduct.name,
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onHighlightSurface,
            modifier = Modifier.constrainAs(nameProduct) {
                top.linkTo(anchor = actionBar.bottom, margin = 50.dp)
                start.linkTo(anchor = parent.start)
            }
        )
        Text(
            text = titleProduct.type,
            style = AppTheme.typography.body,
            color = AppTheme.colors.onHighlightSurface,
            modifier = Modifier.constrainAs(typeProduct) {
                top.linkTo(anchor = nameProduct.bottom, margin = 10.dp)
                start.linkTo(anchor = parent.start)
            }
        )

        Text(
            text = "$ ${titleProduct.price}",
            style = AppTheme.typography.headline,
            color = AppTheme.colors.onHighlightSurface,
            modifier = Modifier.constrainAs(priceProduct) {
                top.linkTo(anchor = typeProduct.bottom, margin = 20.dp)
                start.linkTo(anchor = parent.start)
            }
        )

    }

}

@Composable
private fun TitleProduct(
    modifier: Modifier = Modifier,
    name: String,
    type: String,
    price: String
) {

}

@Composable
private fun ActionBar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onLikeItem: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        IconButton(onClick = onBack) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back",
                modifier = Modifier.size(21.dp),
                tint = AppTheme.colors.surface
            )
        }


        IconButton(onClick = { onLikeItem }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_like),

                contentDescription = "back",
                modifier = Modifier.size(21.dp),
                tint = AppTheme.colors.surface
            )

        }
    }

}