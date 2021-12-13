package com.oliverspryn.android.multimodal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oliverspryn.android.multimodal.ui.adaptivelayouts.AdaptiveLayoutsRoute
import com.oliverspryn.android.multimodal.ui.home.HomeRoute
import com.oliverspryn.android.multimodal.ui.screeninfo.ScreenInfoRoute

@Composable
fun MultimodalNavGraph(
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
            ScreenInfoRoute()
        }

        composable(Destinations.AdaptiveLayouts) {
            AdaptiveLayoutsRoute()
        }
    }
}
