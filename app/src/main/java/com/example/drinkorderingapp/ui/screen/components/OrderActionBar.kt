package com.example.drinkorderingapp.ui.screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.drinkorderingapp.R
import com.example.drinkorderingapp.data.OrderState
import com.example.drinkorderingapp.ui.theme.AppTheme

@Composable
fun OrderActionBar(
    modifier: Modifier = Modifier,
    state: OrderState,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit,
    onAddProduct: () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = AppTheme.colors.surface,
        contentColor = AppTheme.colors.surface,
        shadowElevation = 16.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Selector(
                amount = state.amount,
                onAddItemClicked = onAddItemClicked,
                onRemoveItemClicked = onRemoveItemClicked,
                modifier = Modifier.weight(weight = 1f)
            )
        }
    }
}

@Composable
private fun Selector(
    modifier: Modifier = Modifier,
    amount: Int,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SelectionButton(
            onClicked = onAddItemClicked,
            iconRes = R.drawable.ic_plus,
            containerColor = AppTheme.colors.actionSurface,
            contentColor = AppTheme.colors.surface,
        )
        Text(
            text = amount.toString(),
            color = AppTheme.colors.highlightSurface,
            style = AppTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(75.dp)
                .height(32.dp)
                .border(
                    width = 1.dp,
                    color = AppTheme.colors.regularSurface,
                    shape = RoundedCornerShape(5.dp)
                )
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
        SelectionButton(
            onClicked = onRemoveItemClicked,
            iconRes = R.drawable.ic_minus,
            containerColor = AppTheme.colors.onActionSurface,
            contentColor = AppTheme.colors.highlightSurface,
        )
    }

}


@Composable
private fun SelectionButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    onClicked: () -> Unit,
    containerColor: Color,
    contentColor: Color,
) {
    Surface(
        modifier = modifier.size(24.dp),
        shape = RoundedCornerShape(5.dp),
        color = containerColor,
        contentColor = contentColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onClicked),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(7.dp)
            )
        }
    }

}