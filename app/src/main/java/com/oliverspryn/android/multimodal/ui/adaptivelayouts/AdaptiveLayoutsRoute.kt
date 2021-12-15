package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.oliverspryn.android.multimodal.utils.screen.ScreenClassifier
import com.oliverspryn.android.multimodal.utils.screen.WindowSizeClass

@Composable
fun AdaptiveLayoutsRoute(
    adaptiveLayoutsViewModel: AdaptiveLayoutsViewModel,
    screenClassifier: ScreenClassifier
) {
    val uiState by adaptiveLayoutsViewModel.uiState.collectAsState()

    AdaptiveLayoutsRoute(
        screenClassifier = screenClassifier,
        uiState = uiState,
        onBackPressed = { adaptiveLayoutsViewModel.closeDetails() },
        onSelectNumber = { selectedNumber -> adaptiveLayoutsViewModel.openDetails(selectedNumber) }
    )
}

@Composable
fun AdaptiveLayoutsRoute(
    screenClassifier: ScreenClassifier,
    uiState: AdaptiveLayoutsUiState,
    onBackPressed: () -> Unit,
    onSelectNumber: (Int) -> Unit
) {
    var adaptiveLayoutsScreenType by rememberSaveable { mutableStateOf(AdaptiveLayoutsScreenType.ListOnly) }
    adaptiveLayoutsScreenType =
        screenClassifier.toAdaptiveLayoutsScreenType(articleSelected = uiState.numberSelected)

    val listState = rememberLazyListState()

    when (adaptiveLayoutsScreenType) {
        AdaptiveLayoutsScreenType.ListOnly -> AdaptiveLayoutsListScreen(
            listState = listState,
            onSelectNumber = onSelectNumber
        )

        AdaptiveLayoutsScreenType.DetailOnly -> {
            AdaptiveLayoutsDetailScreen(
                uiState = uiState
            )

            BackHandler {
                onBackPressed()
            }
        }

        AdaptiveLayoutsScreenType.ListOneThirdAndDetailTwoThirds -> AdaptiveLayoutsListOneThirdAndDetailTwoThirds(
            listState = listState,
            uiState = uiState,
            onSelectNumber = onSelectNumber
        )

        AdaptiveLayoutsScreenType.ListHalfAndDetailHalf -> {
            check(screenClassifier is ScreenClassifier.HalfOpened.BookMode)

            AdaptiveLayoutsListHalfAndDetailHalf(
                listState = listState,
                screenClassifier = screenClassifier,
                uiState = uiState,
                onSelectNumber = onSelectNumber
            )
        }

        AdaptiveLayoutsScreenType.ListDetailStacked -> {
            check(screenClassifier is ScreenClassifier.HalfOpened.TableTopMode)

            AdaptiveLayoutsStacked(
                listState = listState,
                screenClassifier = screenClassifier,
                uiState = uiState,
                onSelectNumber = onSelectNumber
            )
        }
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
