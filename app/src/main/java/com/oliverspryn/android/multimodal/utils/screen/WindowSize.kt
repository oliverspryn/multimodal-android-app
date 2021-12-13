package com.oliverspryn.android.multimodal.utils.screen

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toComposeRect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.window.layout.WindowMetricsCalculator

@Composable
fun rememberWindowDpSize(activity: Activity): DpSize {
    val configuration = LocalConfiguration.current

    val windowMetrics = remember(configuration) {
        WindowMetricsCalculator
            .getOrCreate()
            .computeCurrentWindowMetrics(activity)
    }

    val windowDpSize = with(LocalDensity.current) {
        windowMetrics
            .bounds
            .toComposeRect()
            .size
            .toDpSize()
    }

    return windowDpSize
}
