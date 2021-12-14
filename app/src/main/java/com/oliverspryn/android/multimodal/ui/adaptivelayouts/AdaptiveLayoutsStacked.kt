package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oliverspryn.android.multimodal.utils.screen.ScreenClassifier

@Composable
fun AdaptiveLayoutsStacked(
    screenClassifier: ScreenClassifier.HalfOpened.TableTopMode
) {

    Column {
        Box(modifier = Modifier.fillMaxHeight(screenClassifier.hingeSeparationRatio)) {
            AdaptiveLayoutsListScreen()
        }

        Box(modifier = Modifier.fillMaxHeight()) {
            AdaptiveLayoutsDetailScreen()
        }
    }
}
