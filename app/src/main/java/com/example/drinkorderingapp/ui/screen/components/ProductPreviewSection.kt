package com.example.drinkorderingapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.drinkorderingapp.R
import com.example.drinkorderingapp.ui.theme.AppTheme

@Composable
fun ProductPreviewSection(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onLikeItem: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {

        Content(
            onBack = onBack,
            onLikeItem = onLikeItem,
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 14.dp)
        )
    }
}



@Composable
private fun Content(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onLikeItem: () -> Unit
) {

    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (actionBar, highlights) = createRefs()

        ActionBar(
            onBack = onBack,
            onLikeItem = onLikeItem,
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 20.dp)
                .constrainAs(actionBar) {
                    top.linkTo(parent.top)
                }
        )

    }

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