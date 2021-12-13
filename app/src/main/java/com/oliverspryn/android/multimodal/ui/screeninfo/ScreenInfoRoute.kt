package com.oliverspryn.android.multimodal.ui.screeninfo

import androidx.compose.runtime.Composable
import com.oliverspryn.android.multimodal.utils.screen.ScreenClassifier

@Composable
fun ScreenInfoRoute(
    screenClassifier: ScreenClassifier
) {
    ScreenInfoScreen(
        screenClassifier = screenClassifier
    )
}
