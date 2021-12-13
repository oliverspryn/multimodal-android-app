package com.oliverspryn.android.multimodal.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.oliverspryn.android.multimodal.ui.navigation.MultimodalNavGraph
import com.oliverspryn.android.multimodal.ui.theme.MultimodalTheme

@ExperimentalMaterial3Api
@Composable
fun Multimodal() {
    MultimodalTheme {
        val navController = rememberNavController()

        Scaffold { innerPadding ->
            MultimodalNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
