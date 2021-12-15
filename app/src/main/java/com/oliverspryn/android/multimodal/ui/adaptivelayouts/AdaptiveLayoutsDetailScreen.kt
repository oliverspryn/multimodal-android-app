package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oliverspryn.android.multimodal.R
import com.oliverspryn.android.multimodal.ui.theme.MultimodalTheme

@Composable
fun AdaptiveLayoutsDetailScreen(
    uiState: AdaptiveLayoutsUiState
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
    ) {
        if (uiState.numberSelected) {
            Text(
                text = stringResource(id = R.string.selected_item, uiState.numberFromList),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            Text(
                text = stringResource(id = R.string.no_item_selected),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true)
@Composable
fun PreviewAdaptiveLayoutsDetailScreen() {
    MultimodalTheme {
        AdaptiveLayoutsDetailScreen(
            uiState = AdaptiveLayoutsUiState()
        )
    }
}

@Preview(name = "Selected Number", showSystemUi = true)
@Composable
fun PreviewSelectedNumber() {
    MultimodalTheme {
        AdaptiveLayoutsDetailScreen(
            uiState = AdaptiveLayoutsUiState(
                numberFromList = 42,
                numberSelected = true
            )
        )
    }
}
