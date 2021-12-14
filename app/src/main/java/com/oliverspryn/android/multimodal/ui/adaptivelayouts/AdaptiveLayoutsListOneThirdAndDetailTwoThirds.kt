package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdaptiveLayoutsListOneThirdAndDetailTwoThirds() {
    Row {
        Box(modifier = Modifier.fillMaxWidth(0.33f)) {
            AdaptiveLayoutsListScreen()
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            AdaptiveLayoutsDetailScreen()
        }
    }
}
