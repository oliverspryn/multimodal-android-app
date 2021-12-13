package com.oliverspryn.android.multimodal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oliverspryn.android.multimodal.ui.adaptivelayouts.AdaptiveLayoutsRoute
import com.oliverspryn.android.multimodal.ui.home.HomeRoute
import com.oliverspryn.android.multimodal.ui.screeninfo.ScreenInfoRoute
import com.oliverspryn.android.multimodal.utils.screen.ScreenClassifier

@Composable
fun MultimodalNavGraph(
    screenClassifier: ScreenClassifier,
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home,
        modifier = modifier
    ) {
        composable(Destinations.Home) {
            HomeRoute(
                onViewScreenInfoButtonTap = { navController.navigate(Destinations.ScreenInfo) },
                onViewAdaptiveLayoutsButtonTap = { navController.navigate(Destinations.AdaptiveLayouts) }
            )
        }

        composable(Destinations.ScreenInfo) {
            ScreenInfoRoute(
                screenClassifier = screenClassifier
            )
        }

        composable(Destinations.AdaptiveLayouts) {
            AdaptiveLayoutsRoute(
                screenClassifier = screenClassifier
            )
        }
    }
}
