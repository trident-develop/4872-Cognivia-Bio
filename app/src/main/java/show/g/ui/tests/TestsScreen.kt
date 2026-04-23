package show.g.ui.tests

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import show.g.data.MockTests
import show.g.model.BioTest
import show.g.ui.components.IconBadge
import show.g.ui.components.PrimaryGradient
import show.g.ui.theme.GreenDeep
import show.g.ui.theme.GreenPale
import show.g.ui.theme.GreenPrimary
import show.g.ui.theme.TextPrimary
import show.g.ui.theme.TextSecondary

@Composable
fun TestsScreen(onStartTest: (BioTest) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item { TestsHeader() }
        items(MockTests, key = { it.id }) { test ->
            TestCard(test = test, onClick = { onStartTest(test) })
        }
    }
}

@Composable
private fun TestsHeader() {
    Column(modifier = Modifier.padding(bottom = 6.dp)) {
        Text(
            text = "Tests",
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = GreenDeep
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Twenty quick biology quizzes. Five minutes each.",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
    }
}

@Composable
private fun TestCard(test: BioTest, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth().clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconBadge(iconKey = test.iconKey, size = 56)
            Spacer(Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = test.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = TextPrimary
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = test.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
                Spacer(Modifier.height(10.dp))
                Column(horizontalAlignment = Alignment.Start) {
                    InfoChip(icon = Icons.Filled.QuestionAnswer, text = "${test.questionCount} questions")
                    Spacer(Modifier.height(6.dp))
                    InfoChip(icon = Icons.Filled.Schedule, text = "5 min")
                }
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(brush = PrimaryGradient, shape = RoundedCornerShape(14.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Start",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
private fun InfoChip(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(GreenPale, RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = GreenPrimary, modifier = Modifier.size(14.dp))
        Spacer(Modifier.width(6.dp))
        Text(text = text, style = MaterialTheme.typography.labelMedium, color = GreenDeep)
    }
}
