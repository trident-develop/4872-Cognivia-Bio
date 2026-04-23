package show.g.ui.loading

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import show.g.R
import show.g.ui.theme.GreenBgBottom
import show.g.ui.theme.GreenBgTop
import show.g.ui.theme.GreenDeep
import show.g.ui.theme.GreenMedium
import show.g.ui.theme.GreenPrimary
import show.g.ui.theme.GreenSoft
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun LoadingScreen() {
    val transition = rememberInfiniteTransition(label = "loading")

    val helixPhase by transition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3600, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "helixPhase"
    )
    val orbPhase by transition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "orbPhase"
    )
    val pulse by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(1400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "pulse"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(GreenBgTop, GreenBgBottom))),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawFloatingCells(orbPhase, pulse)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.size(220.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawDnaHelix(helixPhase)
                }
            }

            Spacer(Modifier.height(28.dp))

            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = GreenDeep,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "Elegant biology, made simple",
                style = MaterialTheme.typography.bodyMedium,
                color = GreenPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Spacer(Modifier.height(28.dp))
            CircularProgressIndicator(
                color = GreenPrimary,
                trackColor = GreenSoft.copy(alpha = 0.35f),
                strokeWidth = 4.dp,
                modifier = Modifier.size(42.dp)
            )
        }
    }
}

private fun DrawScope.drawDnaHelix(phase: Float) {
    val w = size.width
    val h = size.height
    val cx = w / 2f
    val amplitude = w * 0.28f
    val steps = 36
    val rungsEvery = 3

    val pointsA = ArrayList<Offset>(steps)
    val pointsB = ArrayList<Offset>(steps)
    for (i in 0..steps) {
        val t = i / steps.toFloat()
        val y = t * h
        val angle = t * PI.toFloat() * 3.6f + phase
        val xA = cx + sin(angle) * amplitude
        val xB = cx - sin(angle) * amplitude
        pointsA.add(Offset(xA, y))
        pointsB.add(Offset(xB, y))
    }

    for (i in 0 until pointsA.size - 1) {
        val alpha = 0.85f
        val colorA = Color(0xFF2E7D4F).copy(alpha = alpha)
        val colorB = Color(0xFF3FA167).copy(alpha = alpha)
        drawLine(colorA, pointsA[i], pointsA[i + 1], strokeWidth = 6f)
        drawLine(colorB, pointsB[i], pointsB[i + 1], strokeWidth = 6f)
    }

    for (i in pointsA.indices step rungsEvery) {
        val a = pointsA[i]
        val b = pointsB[i]
        val depth = (sin(i / steps.toFloat() * PI.toFloat() * 3.6f + phase) + 1f) / 2f
        val rungColor = Color(0xFF8BC9A4).copy(alpha = 0.35f + depth * 0.45f)
        drawLine(rungColor, a, b, strokeWidth = 3f)
        drawCircle(Color(0xFF1B5E3F), radius = 5f, center = a)
        drawCircle(Color(0xFF1B5E3F), radius = 5f, center = b)
    }
}

private fun DrawScope.drawFloatingCells(phase: Float, pulse: Float) {
    val w = size.width
    val h = size.height

    data class Particle(val baseX: Float, val baseY: Float, val r: Float, val speed: Float, val ringy: Boolean)

    val particles = listOf(
        Particle(w * 0.12f, h * 0.18f, 28f, 0.9f, true),
        Particle(w * 0.82f, h * 0.12f, 22f, 1.2f, false),
        Particle(w * 0.2f, h * 0.82f, 34f, 0.7f, true),
        Particle(w * 0.78f, h * 0.74f, 26f, 1.1f, false),
        Particle(w * 0.08f, h * 0.5f, 18f, 1.5f, false),
        Particle(w * 0.9f, h * 0.46f, 20f, 1.3f, true),
        Particle(w * 0.5f, h * 0.08f, 16f, 1.6f, false),
        Particle(w * 0.5f, h * 0.92f, 16f, 1.0f, false),
    )

    particles.forEach { p ->
        val dx = cos(phase * p.speed + p.baseX * 0.01f) * 22f
        val dy = sin(phase * p.speed + p.baseY * 0.01f) * 22f
        val cx = p.baseX + dx
        val cy = p.baseY + dy
        val radius = p.r * pulse

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    GreenMedium.copy(alpha = 0.22f),
                    GreenSoft.copy(alpha = 0.04f),
                    Color.Transparent
                ),
                center = Offset(cx, cy),
                radius = radius * 2.4f
            ),
            radius = radius * 2.4f,
            center = Offset(cx, cy)
        )
        drawCircle(
            color = GreenPrimary.copy(alpha = 0.18f),
            radius = radius,
            center = Offset(cx, cy)
        )
        if (p.ringy) {
            drawCircle(
                color = GreenDeep.copy(alpha = 0.35f),
                radius = radius,
                center = Offset(cx, cy),
                style = Stroke(width = 2f)
            )
            drawCircle(
                color = GreenDeep.copy(alpha = 0.5f),
                radius = radius * 0.35f,
                center = Offset(cx, cy)
            )
        }
    }
}
