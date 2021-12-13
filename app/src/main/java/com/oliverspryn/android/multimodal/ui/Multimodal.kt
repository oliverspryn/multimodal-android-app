package com.oliverspryn.android.multimodal.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.WindowLayoutInfo
import com.oliverspryn.android.multimodal.ui.navigation.MultimodalNavGraph
import com.oliverspryn.android.multimodal.ui.theme.MultimodalTheme
import com.oliverspryn.android.multimodal.utils.screen.ScreenInfo
import kotlinx.coroutines.flow.StateFlow

@ExperimentalMaterial3Api
@Composable
fun Multimodal(
    devicePosture: StateFlow<WindowLayoutInfo>,
    windowDpSize: DpSize,
    screenInfo: ScreenInfo = ScreenInfo()
) {
    val devicePostureValue by devicePosture.collectAsState()
    val screenClassifier = screenInfo.createClassifier(devicePostureValue, windowDpSize)

    MultimodalTheme {
        val navController = rememberNavController()

        Scaffold { innerPadding ->
            MultimodalNavGraph(
                screenClassifier = screenClassifier,
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
