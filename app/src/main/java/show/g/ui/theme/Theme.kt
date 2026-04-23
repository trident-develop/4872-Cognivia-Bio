package show.g.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val CogniviaColorScheme = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = Cream,
    primaryContainer = GreenMint,
    onPrimaryContainer = GreenDeep,
    secondary = Sage,
    onSecondary = Cream,
    secondaryContainer = GreenPale,
    onSecondaryContainer = GreenDeep,
    tertiary = Olive,
    onTertiary = TextPrimary,
    background = GreenBgTop,
    onBackground = TextPrimary,
    surface = SurfaceElev,
    onSurface = TextPrimary,
    surfaceVariant = GreenPale,
    onSurfaceVariant = TextSecondary,
    outline = DividerGreen,
    error = AccentCoral,
    onError = Cream,
)

@Composable
fun CogniviaBioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CogniviaColorScheme,
        typography = Typography,
        content = content
    )
}
