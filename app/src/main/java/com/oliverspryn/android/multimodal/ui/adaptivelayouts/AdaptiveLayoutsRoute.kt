package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.oliverspryn.android.multimodal.utils.screen.ScreenClassifier
import com.oliverspryn.android.multimodal.utils.screen.WindowSizeClass

@Composable
fun AdaptiveLayoutsRoute(
    screenClassifier: ScreenClassifier
) {
    var adaptiveLayoutsScreenType by rememberSaveable { mutableStateOf(AdaptiveLayoutsScreenType.ListOnly) }
    adaptiveLayoutsScreenType =
        screenClassifier.toAdaptiveLayoutsScreenType(articleSelected = false)

    Text(text = adaptiveLayoutsScreenType.toString())

    when (adaptiveLayoutsScreenType) {
        AdaptiveLayoutsScreenType.ListOnly -> Unit
        AdaptiveLayoutsScreenType.DetailOnly -> Unit
        AdaptiveLayoutsScreenType.ListOneThirdAndDetailTwoThirds -> Unit
        AdaptiveLayoutsScreenType.ListHalfAndDetailHalf -> Unit
        AdaptiveLayoutsScreenType.ListDetailStacked -> Unit
    }
}

enum class AdaptiveLayoutsScreenType {
    ListOnly,
    DetailOnly,
    ListOneThirdAndDetailTwoThirds,
    ListHalfAndDetailHalf,
    ListDetailStacked
}

@Composable
private fun ScreenClassifier.toAdaptiveLayoutsScreenType(articleSelected: Boolean) =
    if (this is ScreenClassifier.FullyOpened && width.sizeClass == WindowSizeClass.Expanded) {
        AdaptiveLayoutsScreenType.ListOneThirdAndDetailTwoThirds
    } else if (this is ScreenClassifier.FullyOpened && !articleSelected) {
        AdaptiveLayoutsScreenType.ListOnly
    } else if (this is ScreenClassifier.FullyOpened && articleSelected) {
        AdaptiveLayoutsScreenType.DetailOnly
    } else if (this is ScreenClassifier.HalfOpened.BookMode) {
        AdaptiveLayoutsScreenType.ListHalfAndDetailHalf
    } else if (this is ScreenClassifier.HalfOpened.TableTopMode) {
        AdaptiveLayoutsScreenType.ListDetailStacked
    } else {
        AdaptiveLayoutsScreenType.ListOnly
    }
