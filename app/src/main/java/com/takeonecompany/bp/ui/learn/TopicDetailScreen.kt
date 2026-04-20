package com.takeonecompany.bp.ui.learn

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.takeonecompany.bp.model.LearnCategory
import com.takeonecompany.bp.model.Topic
import com.takeonecompany.bp.ui.components.BioIcon
import com.takeonecompany.bp.ui.components.CardAccentGradient
import com.takeonecompany.bp.ui.components.PrimaryGradient
import com.takeonecompany.bp.ui.components.ScreenBackground
import com.takeonecompany.bp.ui.theme.GreenDeep
import com.takeonecompany.bp.ui.theme.GreenPale
import com.takeonecompany.bp.ui.theme.GreenPrimary
import com.takeonecompany.bp.ui.theme.TextPrimary
import com.takeonecompany.bp.ui.theme.TextSecondary

@Composable
fun TopicDetailScreen(
    category: LearnCategory,
    topic: Topic,
    onBack: () -> Unit,
) {
    BackHandler(onBack = onBack)
    ScreenBackground {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 48.dp, bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                TopicHeader(category = category, topic = topic, onBack = onBack)
            }
            item {
                OverviewCard(text = topic.summary)
            }
            if (topic.keyPoints.isNotEmpty()) {
                item {
                    KeyPointsCard(points = topic.keyPoints)
                }
            }
            if (topic.deepDive.isNotBlank()) {
                item {
                    DeepDiveCard(text = topic.deepDive)
                }
            }
        }
    }
}

@Composable
private fun TopicHeader(
    category: LearnCategory,
    topic: Topic,
    onBack: () -> Unit,
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, CircleShape)
                    .clickable { onBack() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = GreenDeep
                )
            }
            Spacer(Modifier.width(12.dp))
            Text(
                text = category.title,
                color = GreenPrimary,
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(Modifier.height(16.dp))
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(brush = PrimaryGradient, shape = RoundedCornerShape(24.dp))
                    .padding(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    BioIcon(key = category.iconKey, tint = Color.White, modifier = Modifier.size(28.dp))
                }
                Spacer(Modifier.height(14.dp))
                Text(
                    text = topic.title,
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Lesson · ${category.title}",
                    color = Color.White.copy(alpha = 0.85f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun OverviewCard(text: String) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            SectionLabel("Overview")
            Spacer(Modifier.height(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = TextPrimary
            )
        }
    }
}

@Composable
private fun KeyPointsCard(points: List<String>) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            SectionLabel("Key points")
            Spacer(Modifier.height(10.dp))
            points.forEachIndexed { index, point ->
                KeyPointRow(index = index + 1, text = point)
                if (index != points.lastIndex) Spacer(Modifier.height(10.dp))
            }
        }
    }
}

@Composable
private fun KeyPointRow(index: Int, text: String) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = CardAccentGradient, shape = RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(26.dp)
                .background(Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = index.toString(),
                color = GreenDeep,
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(Modifier.width(10.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = TextPrimary,
            modifier = Modifier.padding(top = 3.dp)
        )
    }
}

@Composable
private fun DeepDiveCard(text: String) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            SectionLabel("Dive deeper")
            Spacer(Modifier.height(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = TextPrimary
            )
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Box(
        modifier = Modifier
            .background(GreenPale, RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = text.uppercase(),
            color = GreenPrimary,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}
