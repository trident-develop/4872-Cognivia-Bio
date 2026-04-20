package com.takeonecompany.bp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.takeonecompany.bp.data.MockCategories
import com.takeonecompany.bp.data.MockTests
import com.takeonecompany.bp.data.StatsRepository
import com.takeonecompany.bp.model.BioTest
import com.takeonecompany.bp.model.LearnCategory
import com.takeonecompany.bp.model.TestResult
import com.takeonecompany.bp.model.Topic
import com.takeonecompany.bp.ui.components.ScreenBackground
import com.takeonecompany.bp.ui.learn.LearnScreen
import com.takeonecompany.bp.ui.learn.TopicDetailScreen
import com.takeonecompany.bp.ui.loading.LoadingScreen
import com.takeonecompany.bp.ui.nav.CogniviaBottomBar
import com.takeonecompany.bp.ui.nav.Tab
import com.takeonecompany.bp.ui.stats.StatsScreen
import com.takeonecompany.bp.ui.tests.ResultsScreen
import com.takeonecompany.bp.ui.tests.TestPlayScreen
import com.takeonecompany.bp.ui.tests.TestsScreen
import kotlinx.coroutines.delay

private sealed interface Route {
    object Loading : Route
    object Main : Route
    data class TopicDetail(val categoryId: String, val topicId: String) : Route
    data class Play(val testId: String, val runId: Long) : Route
    data class Results(val testId: String, val result: TestResult) : Route
}

@Composable
fun AppRoot() {
    val context = LocalContext.current
    val repo = remember { StatsRepository(context) }

    var route by remember { mutableStateOf<Route>(Route.Loading) }
    var currentTab by rememberSaveable { mutableStateOf(Tab.Learn) }

    LaunchedEffect(Unit) {
        if (route is Route.Loading) {
            delay(2000)
            route = Route.Main
        }
    }

    AnimatedContent(
        targetState = route,
        transitionSpec = {
            val forward = isForward(initialState, targetState)
            val enter = if (forward)
                slideInHorizontally { w -> w } + fadeIn()
            else
                slideInHorizontally { w -> -w } + fadeIn()
            val exit = if (forward)
                slideOutHorizontally { w -> -w } + fadeOut()
            else
                slideOutHorizontally { w -> w } + fadeOut()
            enter togetherWith exit
        },
        label = "root",
        modifier = Modifier.fillMaxSize()
    ) { target ->
        when (target) {
            Route.Loading -> LoadingScreen()
            Route.Main -> MainScaffold(
                currentTab = currentTab,
                onTabSelected = { currentTab = it },
                repo = repo,
                onStartTest = { test ->
                    route = Route.Play(test.id, System.currentTimeMillis())
                },
                onOpenTopic = { category, topic ->
                    route = Route.TopicDetail(category.id, topic.id)
                }
            )
            is Route.TopicDetail -> {
                val category = MockCategories.first { it.id == target.categoryId }
                val topic = category.topics.first { it.id == target.topicId }
                TopicDetailScreen(
                    category = category,
                    topic = topic,
                    onBack = { route = Route.Main }
                )
            }
            is Route.Play -> {
                val test = MockTests.first { it.id == target.testId }
                TestPlayScreen(
                    test = test,
                    onFinish = { result ->
                        repo.recordResult(result)
                        route = Route.Results(test.id, result)
                    },
                    onExit = { route = Route.Main }
                )
            }
            is Route.Results -> {
                val test = MockTests.first { it.id == target.testId }
                ResultsScreen(
                    test = test,
                    result = target.result,
                    onRetry = { route = Route.Play(test.id, System.currentTimeMillis()) },
                    onBack = { route = Route.Main }
                )
            }
        }
    }
}

private fun isForward(from: Route, to: Route): Boolean = when {
    from is Route.Loading -> true
    from is Route.Main && to is Route.Play -> true
    from is Route.Main && to is Route.TopicDetail -> true
    from is Route.Play && to is Route.Results -> true
    from is Route.Results && to is Route.Play -> true
    to is Route.Main -> false
    else -> true
}

@Composable
private fun MainScaffold(
    currentTab: Tab,
    onTabSelected: (Tab) -> Unit,
    repo: StatsRepository,
    onStartTest: (BioTest) -> Unit,
    onOpenTopic: (LearnCategory, Topic) -> Unit,
) {
    BackHandler(enabled = currentTab != Tab.Learn) {
        onTabSelected(Tab.Learn)
    }
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            CogniviaBottomBar(current = currentTab, onSelect = onTabSelected)
        }
    ) { inner ->
        ScreenBackground {
            Box(modifier = Modifier.padding(inner).fillMaxSize()) {
                AnimatedContent(
                    targetState = currentTab,
                    transitionSpec = {
                        (fadeIn() + slideInHorizontally { w -> w / 6 }) togetherWith
                                (fadeOut() + slideOutHorizontally { w -> -w / 6 })
                    },
                    label = "tab"
                ) { tab ->
                    when (tab) {
                        Tab.Learn -> LearnScreen(onOpenTopic = onOpenTopic)
                        Tab.Tests -> TestsScreen(onStartTest = onStartTest)
                        Tab.Stats -> StatsScreen(repo = repo)
                    }
                }
            }
        }
    }
}
