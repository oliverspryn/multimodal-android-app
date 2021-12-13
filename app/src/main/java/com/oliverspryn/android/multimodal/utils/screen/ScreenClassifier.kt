package com.oliverspryn.android.multimodal.utils.screen

import android.graphics.Rect
import androidx.window.layout.FoldingFeature

sealed interface ScreenClassifier {
    data class FullyOpened(
        val height: Dimension,
        val width: Dimension
    ) : ScreenClassifier

    sealed interface HalfOpened : ScreenClassifier {
        val hingePosition: Rect
        val hingeSeparationRatio: Float
        val isSeparating: Boolean
        val occlusionType: FoldingFeature.OcclusionType

        data class BookMode(
            override val hingePosition: Rect,
            override val hingeSeparationRatio: Float,
            override val isSeparating: Boolean,
            override val occlusionType: FoldingFeature.OcclusionType
        ) : HalfOpened

        data class TableTopMode(
            override val hingePosition: Rect,
            override val hingeSeparationRatio: Float,
            override val isSeparating: Boolean,
            override val occlusionType: FoldingFeature.OcclusionType
        ) : HalfOpened
    }
}
