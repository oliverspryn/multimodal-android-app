package com.oliverspryn.android.multimodal.ui.home

import androidx.compose.runtime.Composable

@Composable
fun HomeRoute(
    onViewScreenInfoButtonTap: () -> Unit,
    onViewAdaptiveLayoutsButtonTap: () -> Unit
) {
    HomeScreen(
        onViewScreenInfoButtonTap = onViewScreenInfoButtonTap,
        onViewAdaptiveLayoutsButtonTap = onViewAdaptiveLayoutsButtonTap
    )
}