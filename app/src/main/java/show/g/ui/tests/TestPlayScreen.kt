package show.g.ui.tests

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import show.g.model.BioTest
import show.g.model.TestResult
import show.g.ui.components.PrimaryGradient
import show.g.ui.components.ScreenBackground
import show.g.ui.theme.AccentCoral
import show.g.ui.theme.DividerGreen
import show.g.ui.theme.GreenDeep
import show.g.ui.theme.GreenMint
import show.g.ui.theme.GreenPale
import show.g.ui.theme.GreenPrimary
import show.g.ui.theme.GreenSoft
import show.g.ui.theme.TextPrimary
import show.g.ui.theme.TextSecondary
import kotlinx.coroutines.delay
import kotlin.collections.get
import kotlin.text.get

@Composable
fun TestPlayScreen(
    test: BioTest,
    onFinish: (TestResult) -> Unit,
    onExit: () -> Unit,
) {
    BackHandler(onBack = onExit)
    val total = test.questions.size
    var currentIndex by rememberSaveable(test.id) { mutableStateOf(0) }
    val answers = remember(test.id) {
        mutableStateListOf<Int?>().apply { repeat(total) { add(null) } }
    }
    var remaining by rememberSaveable(test.id) { mutableStateOf(test.timeLimitSeconds) }

    LaunchedEffect(test.id) {
        while (remaining > 0) {
            delay(1000L)
            remaining -= 1
        }
        val elapsed = test.timeLimitSeconds - remaining
        onFinish(buildResult(test, answers, elapsed))
    }

    val elapsedSeconds = test.timeLimitSeconds - remaining
    val question = test.questions[currentIndex]
    val selectedAnswer = answers[currentIndex]
    val progress = (currentIndex + 1) / total.toFloat()

    ScreenBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .padding(top = 32.dp)
        ) {
            PlayHeader(
                title = test.title,
                remaining = remaining,
                onExit = onExit
            )
            Spacer(Modifier.height(16.dp))
            ProgressBlock(
                currentIndex = currentIndex,
                total = total,
                progress = progress
            )
            Spacer(Modifier.height(18.dp))

            AnimatedContent(
                targetState = currentIndex,
                transitionSpec = {
                    (slideInHorizontally { w -> w } + fadeIn()) togetherWith
                            (slideOutHorizontally { w -> -w } + fadeOut())
                },
                label = "question",
                modifier = Modifier.weight(1f)
            ) { index ->
                val q = test.questions[index]
                QuestionCard(
                    questionNumber = index + 1,
                    prompt = q.prompt,
                    options = q.options,
                    selected = answers[index],
                    onSelect = { answers[index] = it }
                )
            }

            Spacer(Modifier.height(12.dp))
            BottomBar(
                canGoBack = currentIndex > 0,
                isLast = currentIndex == total - 1,
                canAdvance = selectedAnswer != null,
                onBack = { if (currentIndex > 0) currentIndex-- },
                onNext = {
                    if (currentIndex < total - 1) {
                        currentIndex++
                    } else {
                        onFinish(buildResult(test, answers, elapsedSeconds))
                    }
                }
            )
        }
    }
}

private fun buildResult(
    test: BioTest,
    answers: List<Int?>,
    elapsed: Int,
): TestResult {
    val correct = test.questions.indices.count { answers[it] == test.questions[it].correctIndex }
    val answered = answers.count { it != null }
    val total = test.questions.size
    val wrong = answered - correct
    val percent = if (total == 0) 0 else (correct * 100) / total
    return TestResult(
        testId = test.id,
        correct = correct,
        wrong = wrong.coerceAtLeast(0),
        total = total,
        percent = percent,
        timeSpentSeconds = elapsed.coerceAtLeast(0),
    )
}

@Composable
private fun PlayHeader(title: String, remaining: Int, onExit: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onExit) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = GreenDeep)
        }
        Spacer(Modifier.width(4.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = GreenDeep,
            modifier = Modifier.weight(1f)
        )
        TimerPill(remaining)
    }
}

@Composable
private fun TimerPill(remaining: Int) {
    val mm = remaining / 60
    val ss = remaining % 60
    val warn = remaining <= 30
    val color by animateColorAsState(
        if (warn) AccentCoral else GreenPrimary, tween(260), label = "timer"
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp, GreenSoft, RoundedCornerShape(20.dp))
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Icon(Icons.Filled.Schedule, contentDescription = null, tint = color, modifier = Modifier.size(18.dp))
        Spacer(Modifier.width(6.dp))
        Text(
            text = "%02d:%02d".format(mm, ss),
            color = color,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Composable
private fun ProgressBlock(currentIndex: Int, total: Int, progress: Float) {
    val animated by animateFloatAsState(progress, tween(400), label = "progress")
    Column {
        Row {
            Text(
                text = "Question ${currentIndex + 1} of $total",
                style = MaterialTheme.typography.labelLarge,
                color = TextSecondary
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = "${(animated * 100).toInt()}%",
                style = MaterialTheme.typography.labelLarge,
                color = GreenPrimary
            )
        }
        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .background(GreenPale, RoundedCornerShape(6.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(animated)
                    .height(10.dp)
                    .background(brush = PrimaryGradient, shape = RoundedCornerShape(6.dp))
            )
        }
    }
}

@Composable
private fun QuestionCard(
    questionNumber: Int,
    prompt: String,
    options: List<String>,
    selected: Int?,
    onSelect: (Int) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "Q$questionNumber",
                color = GreenPrimary,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = prompt,
                style = MaterialTheme.typography.titleLarge,
                color = TextPrimary
            )
            Spacer(Modifier.height(14.dp))
            options.forEachIndexed { index, text ->
                AnswerRow(
                    text = text,
                    selected = selected == index,
                    onClick = { onSelect(index) }
                )
                if (index != options.lastIndex) Spacer(Modifier.height(10.dp))
            }
        }
    }
}

@Composable
private fun AnswerRow(text: String, selected: Boolean, onClick: () -> Unit) {
    val bg by animateColorAsState(
        if (selected) GreenMint else GreenPale, tween(220), label = "bg"
    )
    val border by animateColorAsState(
        if (selected) GreenPrimary else DividerGreen, tween(220), label = "border"
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(bg, RoundedCornerShape(16.dp))
            .border(1.5.dp, border, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(14.dp)
    ) {
        Icon(
            imageVector = if (selected) Icons.Filled.CheckCircle else Icons.Filled.RadioButtonUnchecked,
            contentDescription = null,
            tint = if (selected) GreenPrimary else TextSecondary
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = TextPrimary
        )
    }
}

@Composable
private fun BottomBar(
    canGoBack: Boolean,
    isLast: Boolean,
    canAdvance: Boolean,
    onBack: () -> Unit,
    onNext: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (canGoBack) {
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenPale,
                    contentColor = GreenDeep
                ),
                shape = RoundedCornerShape(16.dp)
            ) { Text("Previous") }
            Spacer(Modifier.width(12.dp))
        }
        Spacer(Modifier.weight(1f))
        PrimaryGradientButton(
            text = if (isLast) "Finish" else "Next",
            enabled = canAdvance,
            onClick = onNext
        )
    }
}

@Composable
private fun PrimaryGradientButton(text: String, enabled: Boolean, onClick: () -> Unit) {
    val alpha = if (enabled) 1f else 0.45f
    Box(
        modifier = Modifier
            .background(brush = PrimaryGradient, shape = RoundedCornerShape(16.dp))
            .clickable(enabled = enabled) { onClick() }
            .padding(horizontal = 28.dp, vertical = 14.dp)
    ) {
        Text(
            text = text,
            color = Color.White.copy(alpha = alpha),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}
