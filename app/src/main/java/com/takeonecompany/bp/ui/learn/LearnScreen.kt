package com.takeonecompany.bp.ui.learn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.takeonecompany.bp.data.MockCategories
import com.takeonecompany.bp.model.LearnCategory
import com.takeonecompany.bp.model.Topic
import com.takeonecompany.bp.ui.components.CardAccentGradient
import com.takeonecompany.bp.ui.components.IconBadge
import com.takeonecompany.bp.ui.theme.DividerGreen
import com.takeonecompany.bp.ui.theme.GreenDeep
import com.takeonecompany.bp.ui.theme.GreenPale
import com.takeonecompany.bp.ui.theme.GreenPrimary
import com.takeonecompany.bp.ui.theme.TextPrimary
import com.takeonecompany.bp.ui.theme.TextSecondary

@Composable
fun LearnScreen(
    onOpenTopic: (LearnCategory, Topic) -> Unit,
) {
    var expandedId by rememberSaveable { mutableStateOf<String?>(null) }

    LazyColumn(
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item { LearnHeader() }
        items(MockCategories, key = { it.id }) { category ->
            CategoryCard(
                category = category,
                expanded = expandedId == category.id,
                onToggle = {
                    expandedId = if (expandedId == category.id) null else category.id
                },
                onOpenTopic = { topic -> onOpenTopic(category, topic) }
            )
        }
    }
}

@Composable
private fun LearnHeader() {
    Column(modifier = Modifier.padding(bottom = 6.dp)) {
        Text(
            text = "Learn",
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = GreenDeep
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Fifteen core areas of biology. Tap a category to unfold its topics, then tap a topic to open the lesson.",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
    }
}

@Composable
private fun CategoryCard(
    category: LearnCategory,
    expanded: Boolean,
    onToggle: () -> Unit,
    onOpenTopic: (Topic) -> Unit,
) {
    val elevation by animateDpAsState(if (expanded) 10.dp else 4.dp, tween(260), label = "elev")
    val arrowRotation by animateFloatAsState(if (expanded) 180f else 0f, tween(260), label = "arrow")
    val titleColor by animateColorAsState(
        if (expanded) GreenDeep else TextPrimary, tween(260), label = "title"
    )

    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onToggle() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconBadge(iconKey = category.iconKey, size = 56)
                Spacer(Modifier.width(14.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.titleLarge,
                        color = titleColor
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = category.subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                }
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .background(GreenPale, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ExpandMore,
                        contentDescription = if (expanded) "Collapse" else "Expand",
                        tint = GreenPrimary,
                        modifier = Modifier.rotate(arrowRotation)
                    )
                }
            }

            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(tween(260)) + expandVertically(tween(260)),
                exit = fadeOut(tween(200)) + shrinkVertically(tween(220))
            ) {
                Column(modifier = Modifier.padding(top = 14.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(DividerGreen)
                    )
                    Spacer(Modifier.height(12.dp))
                    category.topics.forEachIndexed { index, topic ->
                        TopicRow(
                            topic = topic,
                            index = index + 1,
                            onClick = { onOpenTopic(topic) }
                        )
                        if (index < category.topics.lastIndex) Spacer(Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun TopicRow(
    topic: Topic,
    index: Int,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = CardAccentGradient, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = index.toString(),
                style = MaterialTheme.typography.labelLarge,
                color = GreenDeep
            )
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = topic.title,
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimary
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = topic.summary,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }
        Spacer(Modifier.width(8.dp))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = GreenPrimary
        )
    }
}
