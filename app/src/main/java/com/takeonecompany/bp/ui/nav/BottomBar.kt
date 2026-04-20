package com.takeonecompany.bp.ui.nav

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.takeonecompany.bp.ui.components.PrimaryGradient
import com.takeonecompany.bp.ui.theme.GreenDeep
import com.takeonecompany.bp.ui.theme.TextSecondary

enum class Tab(val label: String, val icon: ImageVector) {
    Learn("Learn", Icons.AutoMirrored.Filled.MenuBook),
    Tests("Tests", Icons.Filled.Quiz),
    Stats("Statistics", Icons.Filled.BarChart),
}

@Composable
fun CogniviaBottomBar(
    current: Tab,
    onSelect: (Tab) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 12.dp)
            .background(Color.White, RoundedCornerShape(26.dp))
            .padding(horizontal = 6.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Tab.values().forEach { tab ->
            NavItem(
                tab = tab,
                selected = tab == current,
                onClick = { onSelect(tab) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun NavItem(
    tab: Tab,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    val shape = RoundedCornerShape(20.dp)
    val height by animateDpAsState(if (selected) 58.dp else 50.dp, tween(260), label = "height")
    val labelAlpha by animateFloatAsState(if (selected) 1f else 0.7f, tween(260), label = "alpha")
    val iconColor by animateColorAsState(
        if (selected) Color.White else TextSecondary, tween(260), label = "iconColor"
    )
    val textColor by animateColorAsState(
        if (selected) Color.White else GreenDeep, tween(260), label = "textColor"
    )

    val content: @Composable () -> Unit = {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
        ) {
            Icon(
                imageVector = tab.icon,
                contentDescription = tab.label,
                tint = iconColor,
                modifier = Modifier.size(22.dp)
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = tab.label,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                color = textColor.copy(alpha = labelAlpha)
            )
        }
    }

    if (selected) {
        Box(
            modifier = modifier
                .background(brush = PrimaryGradient, shape = shape)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) { content() }
    } else {
        Box(
            modifier = modifier
                .background(Color.Transparent, shape)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) { content() }
    }
}
