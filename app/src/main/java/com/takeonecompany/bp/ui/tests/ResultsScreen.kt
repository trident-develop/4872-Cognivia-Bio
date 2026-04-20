package com.takeonecompany.bp.ui.tests

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.takeonecompany.bp.model.BioTest
import com.takeonecompany.bp.model.TestResult
import com.takeonecompany.bp.ui.components.PrimaryGradient
import com.takeonecompany.bp.ui.components.ScreenBackground
import com.takeonecompany.bp.ui.theme.AccentAmber
import com.takeonecompany.bp.ui.theme.AccentCoral
import com.takeonecompany.bp.ui.theme.GreenDeep
import com.takeonecompany.bp.ui.theme.GreenMedium
import com.takeonecompany.bp.ui.theme.GreenPale
import com.takeonecompany.bp.ui.theme.GreenPrimary
import com.takeonecompany.bp.ui.theme.GreenSoft
import com.takeonecompany.bp.ui.theme.TextPrimary
import com.takeonecompany.bp.ui.theme.TextSecondary
import androidx.compose.foundation.Canvas

@Composable
fun ResultsScreen(
    test: BioTest,
    result: TestResult,
    onRetry: () -> Unit,
    onBack: () -> Unit,
) {
    BackHandler(onBack = onBack)
    val message = motivationalMessage(result.percent)

    ScreenBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 18.dp)
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Results",
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = GreenDeep
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = test.title,
                style = MaterialTheme.typography.titleMedium,
                color = TextSecondary
            )
            Spacer(Modifier.height(22.dp))

            ScoreRing(percent = result.percent)

            Spacer(Modifier.height(24.dp))

            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    StatPill(
                        label = "Correct",
                        value = result.correct.toString(),
                        icon = Icons.Filled.CheckCircle,
                        tint = GreenPrimary,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(10.dp))
                    StatPill(
                        label = "Wrong",
                        value = result.wrong.toString(),
                        icon = Icons.Filled.Cancel,
                        tint = AccentCoral,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(10.dp))
                    StatPill(
                        label = "Score",
                        value = "${result.percent}%",
                        icon = Icons.Filled.EmojiEvents,
                        tint = AccentAmber,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(14.dp))
                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimary
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth()) {
                SecondaryButton(text = "Back", onClick = onBack, modifier = Modifier.weight(1f))
                Spacer(Modifier.width(12.dp))
                PrimaryButton(
                    text = "Retry",
                    icon = Icons.Filled.Refresh,
                    onClick = onRetry,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun ScoreRing(percent: Int) {
    val sweep by animateFloatAsState(percent / 100f, tween(900), label = "sweep")
    val ringColor = when {
        percent >= 80 -> GreenPrimary
        percent >= 50 -> GreenMedium
        else -> AccentCoral
    }
    Box(
        modifier = Modifier.size(180.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val stroke = 16f
            val diameter = size.minDimension - stroke
            val topLeft = Offset((size.width - diameter) / 2f, (size.height - diameter) / 2f)
            drawArc(
                color = GreenPale,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = topLeft,
                size = Size(diameter, diameter),
                style = Stroke(width = stroke)
            )
            drawArc(
                brush = Brush.sweepGradient(
                    colors = listOf(GreenSoft, ringColor, GreenDeep, ringColor)
                ),
                startAngle = -90f,
                sweepAngle = 360f * sweep,
                useCenter = false,
                topLeft = topLeft,
                size = Size(diameter, diameter),
                style = Stroke(width = stroke)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${(sweep * 100).toInt()}%",
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                color = GreenDeep
            )
            Text(
                text = "your score",
                style = MaterialTheme.typography.labelLarge,
                color = TextSecondary
            )
        }
    }
}

@Composable
private fun StatPill(
    label: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    tint: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(GreenPale, RoundedCornerShape(14.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(26.dp)
                .background(Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(16.dp))
        }
        Spacer(Modifier.width(8.dp))
        Column {
            Text(value, style = MaterialTheme.typography.titleMedium, color = TextPrimary)
            Text(label, style = MaterialTheme.typography.labelSmall, color = TextSecondary)
        }
    }
}

@Composable
private fun PrimaryButton(
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .background(brush = PrimaryGradient, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(vertical = 14.dp)
    ) {
        Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
        Spacer(Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Composable
private fun SecondaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = GreenDeep,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

private fun motivationalMessage(percent: Int): String = when {
    percent >= 90 -> "Outstanding! You have mastered this topic. Keep the streak going."
    percent >= 75 -> "Great work. You clearly understand the core ideas."
    percent >= 50 -> "Nice effort. A quick review will push your score even higher."
    percent >= 25 -> "Good start. Revisit the basics and try again to improve."
    else -> "Don't worry. Every expert was once a beginner. Keep learning."
}
