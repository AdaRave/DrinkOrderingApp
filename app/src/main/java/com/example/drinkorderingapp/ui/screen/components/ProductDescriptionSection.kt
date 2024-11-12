package com.example.drinkorderingapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.drinkorderingapp.data.DescriptionProductState
import com.example.drinkorderingapp.data.OrderState
import com.example.drinkorderingapp.ui.theme.AppTheme

@Composable
fun ProductDescriptionSection(
    modifier: Modifier = Modifier,
    descriptionProduct: DescriptionProductState,

) {
    Box(
        modifier = Modifier
    ) {
        BackgroundSection(
            modifier = modifier,
            imgRes = descriptionProduct.imgRes
        )
        Content(
            descriptionProduct = descriptionProduct,
            modifier = modifier
                .padding(
                    top = 50.dp
                )
                .padding(horizontal = 20.dp)
        )

    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    descriptionProduct: DescriptionProductState,

    ) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = descriptionProduct.name,
            style = AppTheme.typography.titleSmall,
            color = AppTheme.colors.highlightSurface,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Text(
            text = descriptionProduct.description,
            style = AppTheme.typography.bodySmall,
            color = AppTheme.colors.onActionSurface,

            modifier = Modifier.padding(vertical = 5.dp)
        )

    }

}

@Composable
private fun BackgroundSection(
    modifier: Modifier = Modifier,
    imgRes: Int
) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val (productImg, background) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(AppTheme.colors.background)
                .constrainAs(background) {}
        )
        Image(
            painter = painterResource(id = imgRes),
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


