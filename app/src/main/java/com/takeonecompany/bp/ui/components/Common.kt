package com.takeonecompany.bp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.EnergySavingsLeaf
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Opacity
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.takeonecompany.bp.ui.theme.GreenBgBottom
import com.takeonecompany.bp.ui.theme.GreenBgTop
import com.takeonecompany.bp.ui.theme.GreenDeep
import com.takeonecompany.bp.ui.theme.GreenMedium
import com.takeonecompany.bp.ui.theme.GreenMint
import com.takeonecompany.bp.ui.theme.GreenPale
import com.takeonecompany.bp.ui.theme.GreenPrimary

val PageGradient = Brush.verticalGradient(
    colors = listOf(GreenBgTop, GreenBgBottom)
)

val PrimaryGradient = Brush.linearGradient(
    colors = listOf(GreenMedium, GreenPrimary, GreenDeep)
)

val CardAccentGradient = Brush.linearGradient(
    colors = listOf(GreenPale, GreenMint)
)

val SoftGradient = Brush.verticalGradient(
    colors = listOf(Color.White, GreenPale)
)

@Composable
fun ScreenBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PageGradient)
    ) { content() }
}

@Composable
fun BioIcon(key: String, modifier: Modifier = Modifier, tint: Color = GreenDeep) {
    val vector: ImageVector = when (key) {
        "cell" -> Icons.Filled.Science
        "dna", "helix" -> Icons.Filled.Biotech
        "anatomy" -> Icons.Filled.Psychology
        "heart" -> Icons.Filled.Favorite
        "leaf" -> Icons.Filled.EnergySavingsLeaf
        "paw" -> Icons.Filled.Pets
        "microbe" -> Icons.Filled.Hub
        "tree" -> Icons.Filled.Park
        "globe" -> Icons.Filled.Public
        "flask" -> Icons.Filled.Science
        "shield" -> Icons.Filled.Security
        "seedling" -> Icons.Filled.Grass
        "gear" -> Icons.Filled.Settings
        "wave" -> Icons.Filled.Waves
        "bone" -> Icons.Filled.MedicalServices
        "muscle" -> Icons.Filled.FitnessCenter
        "brain" -> Icons.Filled.Psychology
        "sun" -> Icons.Filled.WbSunny
        "chain" -> Icons.Filled.Link
        "drop" -> Icons.Filled.Opacity
        else -> Icons.Filled.Spa
    }
    Icon(imageVector = vector, contentDescription = null, modifier = modifier, tint = tint)
}

@Composable
fun IconBadge(iconKey: String, size: Int = 52) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .background(brush = CardAccentGradient, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        BioIcon(key = iconKey, modifier = Modifier.size((size * 0.55).dp))
    }
}

@Composable
fun CircleBadge(iconKey: String, size: Int = 48) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .background(brush = PrimaryGradient, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        BioIcon(key = iconKey, modifier = Modifier.size((size * 0.55).dp), tint = Color.White)
    }
}
