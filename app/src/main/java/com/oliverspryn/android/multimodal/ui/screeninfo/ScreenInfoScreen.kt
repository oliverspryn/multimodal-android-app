package com.oliverspryn.android.multimodal.ui.screeninfo

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Rect
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.layout.FoldingFeature
import com.oliverspryn.android.multimodal.R
import com.oliverspryn.android.multimodal.ui.theme.MultimodalTheme
import com.oliverspryn.android.multimodal.utils.screen.Dimension
import com.oliverspryn.android.multimodal.utils.screen.ScreenClassifier
import com.oliverspryn.android.multimodal.utils.screen.WindowSizeClass

@Composable
fun ScreenInfoScreen(
    screenClassifier: ScreenClassifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
    ) {
        Column {
            Text(
                text = screenClassifier::class.java.simpleName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = screenClassifier.toString(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )

            if (screenClassifier is ScreenClassifier.HalfOpened) {
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = stringResource(id = R.string.hinge_position),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(
                        R.string.hinge_position_coordinates,
                        screenClassifier.hingePosition.top,
                        screenClassifier.hingePosition.bottom,
                        screenClassifier.hingePosition.left,
                        screenClassifier.hingePosition.right
                    ),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(
                        R.string.hinge_position_size,
                        screenClassifier.hingePosition.width(),
                        screenClassifier.hingePosition.height()
                    ),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(name = "Table Top Mode", showBackground = true, widthDp = 1280, heightDp = 720)
@Composable
fun PreviewTableTopMode() {
    MultimodalTheme {
        ScreenInfoScreen(
            screenClassifier = ScreenClassifier.HalfOpened.TableTopMode(
                hingePosition = Rect(),
                hingeSeparationRatio = 0.5f,
                isSeparating = false,
                occlusionType = FoldingFeature.OcclusionType.NONE
            )
        )
    }
}

@Preview(name = "Book Mode", showBackground = true, widthDp = 720, heightDp = 1080)
@Composable
fun PreviewBookMode() {
    MultimodalTheme {
        ScreenInfoScreen(
            screenClassifier = ScreenClassifier.HalfOpened.BookMode(
                hingePosition = Rect(),
                hingeSeparationRatio = 0.5f,
                isSeparating = false,
                occlusionType = FoldingFeature.OcclusionType.NONE
            )
        )
    }
}

@Preview(name = "Tablet Mode", showBackground = true, device = Devices.PIXEL_C)
@Composable
fun PreviewTabletMode() {
    MultimodalTheme {
        ScreenInfoScreen(
            screenClassifier = ScreenClassifier.FullyOpened(
                height = Dimension(
                    dp = 1080.dp,
                    sizeClass = WindowSizeClass.Expanded
                ),
                width = Dimension(
                    dp = 1920.dp,
                    sizeClass = WindowSizeClass.Expanded
                )
            )
        )
    }
}

@Preview(name = "Phone Mode", showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun PreviewPhoneMode() {
    MultimodalTheme {
        ScreenInfoScreen(
            screenClassifier = ScreenClassifier.FullyOpened(
                height = Dimension(
                    dp = 1920.dp,
                    sizeClass = WindowSizeClass.Expanded
                ),
                width = Dimension(
                    dp = 1080.dp,
                    sizeClass = WindowSizeClass.Expanded
                )
            )
        )
    }
}

@Preview(name = "Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkMode() {
    MultimodalTheme {
        ScreenInfoScreen(
            screenClassifier = ScreenClassifier.FullyOpened(
                height = Dimension(
                    dp = 1920.dp,
                    sizeClass = WindowSizeClass.Expanded
                ),
                width = Dimension(
                    dp = 1080.dp,
                    sizeClass = WindowSizeClass.Expanded
                )
            )
        )
    }
}
