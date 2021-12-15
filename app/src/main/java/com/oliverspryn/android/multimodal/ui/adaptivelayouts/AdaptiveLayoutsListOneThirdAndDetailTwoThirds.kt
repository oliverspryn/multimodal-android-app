package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdaptiveLayoutsListOneThirdAndDetailTwoThirds(
    listState: LazyListState,
    uiState: AdaptiveLayoutsUiState,
    onSelectNumber: (Int) -> Unit
) {
    Row {
        Box(modifier = Modifier.fillMaxWidth(0.33f)) {
            AdaptiveLayoutsListScreen(
                listState = listState,
                onSelectNumber = onSelectNumber
            )
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            AdaptiveLayoutsDetailScreen(
                uiState = uiState
            )
        }
    }
}
