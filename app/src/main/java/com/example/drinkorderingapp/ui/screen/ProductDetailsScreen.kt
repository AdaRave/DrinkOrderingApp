package com.example.drinkorderingapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.drinkorderingapp.R
import com.example.drinkorderingapp.ui.screen.components.ProductDescriptionSection
import com.example.drinkorderingapp.ui.screen.components.ProductPreviewSection
import com.example.drinkorderingapp.ui.theme.AppTheme

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onLikeItem: () -> Unit
) {
    ProductBackground(
        modifier = Modifier
            .statusBarsPadding()

    )
    Column {
        ProductPreviewSection(
            onBack = onBack,
            onLikeItem = onLikeItem,
            modifier = Modifier
                .height(284.dp)
                .statusBarsPadding()
        )
        ProductDescriptionSection()
    }

}

@Composable
private fun ProductBackground(
    modifier: Modifier = Modifier,
) {

    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (topImg, bottomImg, background) = createRefs()

        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    color = AppTheme.colors.secondarySurface
                )
                .constrainAs(background) {

                }
        )

        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "",
            modifier = Modifier
                .size(266.dp)
                .constrainAs(topImg) {
                    top.linkTo(anchor = parent.top)
                    end.linkTo(anchor = parent.end, margin = (-70).dp)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.cirlce2),
            contentDescription = "",
            modifier = Modifier
                .size(241.dp)
                .constrainAs(bottomImg) {
                    top.linkTo(anchor = topImg.bottom, margin = (-70).dp)
                    start.linkTo(anchor = parent.start, margin = (-80).dp)
                }
        )
    }
}
