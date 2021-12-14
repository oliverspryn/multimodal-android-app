package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oliverspryn.android.multimodal.utils.screen.ScreenClassifier

@Composable
fun AdaptiveLayoutsListHalfAndDetailHalf(
    screenClassifier: ScreenClassifier.HalfOpened.BookMode
) {

    Row {
        Box(modifier = Modifier.fillMaxWidth(screenClassifier.hingeSeparationRatio)) {
            AdaptiveLayoutsListScreen()
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            AdaptiveLayoutsDetailScreen()
        }
    }
}
