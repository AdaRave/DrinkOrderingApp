package com.example.drinkorderingapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.drinkorderingapp.R
import com.example.drinkorderingapp.ui.theme.AppTheme

@Composable
fun ProductDescriptionSection(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
    ) {
        BackgroundSection()
    }
}

@Composable
private fun BackgroundSection(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val (productImg, background) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(AppTheme.colors.background)
                .constrainAs(background){}
        )
        Image(
            painter = painterResource(id = R.drawable.big_mocha),
            contentDescription = "Mocha",
            modifier = Modifier
                .height(184.dp)
                .constrainAs(productImg) {
                    end.linkTo(anchor = parent.end, margin = 40.dp)
                    bottom.linkTo(anchor = background.top, margin = (-50).dp)
                },
            contentScale = ContentScale.FillHeight,

            )
    }
}