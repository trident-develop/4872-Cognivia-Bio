package show.g.ui.stats

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import show.g.data.MockTests
import show.g.data.StatsRepository
import show.g.model.BioTest
import show.g.model.TestStats
import show.g.ui.components.CardAccentGradient
import show.g.ui.components.IconBadge
import show.g.ui.components.PrimaryGradient
import show.g.ui.components.SoftGradient
import show.g.ui.theme.AccentAmber
import show.g.ui.theme.AccentCoral
import show.g.ui.theme.GreenDeep
import show.g.ui.theme.GreenPale
import show.g.ui.theme.GreenPrimary
import show.g.ui.theme.TextPrimary
import show.g.ui.theme.TextSecondary

@Composable
fun StatsScreen(repo: StatsRepository) {
    val completed = repo.totalCompleted()
    val hasData = completed > 0

    LazyColumn(
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item { StatsHeader() }
        item {
            SummaryDashboard(
                totalCompleted = completed,
                avgScore = repo.averageScore(),
                bestResult = repo.bestResult(),
                totalTime = repo.totalTimeSpent()
            )
        }
        if (!hasData) {
            item { EmptyState() }
        } else {
            item {
                Text(
                    text = "Per-test progress",
                    style = MaterialTheme.typography.titleMedium,
                    color = GreenDeep,
                    modifier = Modifier.padding(top = 6.dp, bottom = 2.dp)
                )
            }
            items(MockTests, key = { it.id }) { test ->
                TestStatsRow(test = test, stats = repo.statsFor(test.id))
            }
        }
    }
}

@Composable
private fun StatsHeader() {
    Column(modifier = Modifier.padding(bottom = 6.dp)) {
        Text(
            text = "Statistics",
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = GreenDeep
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Your biology journey at a glance.",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
    }
}

@Composable
private fun SummaryDashboard(
    totalCompleted: Int,
    avgScore: Int,
    bestResult: Int,
    totalTime: Int,
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(brush = PrimaryGradient, shape = RoundedCornerShape(24.dp))
                .padding(18.dp)
        ) {
            Text(
                text = "Overview",
                color = Color.White.copy(alpha = 0.85f),
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Keep learning, one cell at a time",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                SummaryTile(
                    icon = Icons.Filled.BarChart,
                    label = "Completed",
                    value = totalCompleted.toString(),
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(10.dp))
                SummaryTile(
                    icon = Icons.AutoMirrored.Filled.TrendingUp,
                    label = "Avg score",
                    value = "$avgScore%",
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                SummaryTile(
                    icon = Icons.Filled.EmojiEvents,
                    label = "Best result",
                    value = "$bestResult%",
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(10.dp))
                SummaryTile(
                    icon = Icons.Filled.Schedule,
                    label = "Time spent",
                    value = formatTime(totalTime),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun SummaryTile(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.18f), RoundedCornerShape(18.dp))
            .padding(14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .background(Color.White.copy(alpha = 0.25f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
            }
            Spacer(Modifier.width(8.dp))
            Text(label, color = Color.White.copy(alpha = 0.85f), style = MaterialTheme.typography.labelMedium)
        }
        Spacer(Modifier.height(6.dp))
        Text(
            value,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
private fun TestStatsRow(test: BioTest, stats: TestStats) {
    val progress = stats.bestScore / 100f
    val animated by animateFloatAsState(progress, tween(700), label = "progress")
    val color = when {
        stats.attempts == 0 -> TextSecondary
        stats.bestScore >= 80 -> GreenPrimary
        stats.bestScore >= 50 -> AccentAmber
        else -> AccentCoral
    }
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconBadge(iconKey = test.iconKey, size = 44)
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = test.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                    Text(
                        text = if (stats.attempts == 0) "Not attempted yet"
                        else "Attempts: ${stats.attempts}  ·  Last: ${stats.lastScore}%",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "${stats.bestScore}%",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = color
                    )
                    Text(
                        text = "best",
                        style = MaterialTheme.typography.labelSmall,
                        color = TextSecondary
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(GreenPale, RoundedCornerShape(4.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(animated)
                        .height(8.dp)
                        .background(brush = PrimaryGradient, shape = RoundedCornerShape(4.dp))
                )
            }
        }
    }
}

@Composable
private fun EmptyState() {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(brush = SoftGradient, shape = RoundedCornerShape(24.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(76.dp)
                    .background(brush = CardAccentGradient, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.LocalFireDepartment,
                    contentDescription = null,
                    tint = GreenPrimary,
                    modifier = Modifier.size(38.dp)
                )
            }
            Spacer(Modifier.height(14.dp))
            Text(
                "No results yet",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                color = GreenDeep
            )
            Spacer(Modifier.height(6.dp))
            Text(
                "Take your first test to see your progress grow here.",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
        }
    }
}

private fun formatTime(totalSeconds: Int): String {
    val h = totalSeconds / 3600
    val m = (totalSeconds % 3600) / 60
    val s = totalSeconds % 60
    return if (h > 0) "${h}h ${m}m" else if (m > 0) "${m}m ${s}s" else "${s}s"
}
