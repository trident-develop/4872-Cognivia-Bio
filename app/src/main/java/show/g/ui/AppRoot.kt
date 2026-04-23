package show.g.ui

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
import show.g.data.MockCategories
import show.g.data.MockTests
import show.g.data.StatsRepository
import show.g.model.BioTest
import show.g.model.LearnCategory
import show.g.model.Topic
import show.g.ui.components.ScreenBackground
import show.g.ui.learn.LearnScreen
import show.g.ui.learn.TopicDetailScreen
import show.g.ui.loading.LoadingScreen
import show.g.ui.nav.CogniviaBottomBar
import show.g.ui.nav.Tab
import show.g.ui.stats.StatsScreen
import show.g.ui.tests.ResultsScreen
import show.g.ui.tests.TestPlayScreen
import show.g.ui.tests.TestsScreen
import kotlinx.coroutines.delay

private sealed interface Route {
    object Loading : Route
    object Main : Route
    data class TopicDetail(val categoryId: String, val topicId: String) : Route
    data class Play(val testId: String, val runId: Long) : Route
    data class Results(val testId: String, val result: show.g.model.TestResult) : Route
}

@Composable
fun AppRoot() {
    val context = LocalContext.current
    val repo = remember { StatsRepository(context) }

    var route by remember { mutableStateOf<show.g.ui.Route>(_root_ide_package_.show.g.ui.Route.Loading) }
    var currentTab by rememberSaveable { mutableStateOf(_root_ide_package_.show.g.ui.nav.Tab.Learn) }

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
            Route.Loading -> _root_ide_package_.show.g.ui.loading.LoadingScreen()
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
                val category = _root_ide_package_.show.g.data.MockCategories.first { it.id == target.categoryId }
                val topic = category.topics.first { it.id == target.topicId }
                _root_ide_package_.show.g.ui.learn.TopicDetailScreen(
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
                val test = _root_ide_package_.show.g.data.MockTests.first { it.id == target.testId }
                _root_ide_package_.show.g.ui.tests.ResultsScreen(
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
    currentTab: show.g.ui.nav.Tab,
    onTabSelected: (show.g.ui.nav.Tab) -> Unit,
    repo: show.g.data.StatsRepository,
    onStartTest: (show.g.model.BioTest) -> Unit,
    onOpenTopic: (show.g.model.LearnCategory, show.g.model.Topic) -> Unit,
) {
    BackHandler(enabled = currentTab != _root_ide_package_.show.g.ui.nav.Tab.Learn) {
        onTabSelected(_root_ide_package_.show.g.ui.nav.Tab.Learn)
    }
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            _root_ide_package_.show.g.ui.nav.CogniviaBottomBar(
                current = currentTab,
                onSelect = onTabSelected
            )
        }
    ) { inner ->
        _root_ide_package_.show.g.ui.components.ScreenBackground {
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
                        _root_ide_package_.show.g.ui.nav.Tab.Learn -> LearnScreen(onOpenTopic = onOpenTopic)
                        _root_ide_package_.show.g.ui.nav.Tab.Tests -> _root_ide_package_.show.g.ui.tests.TestsScreen(
                            onStartTest = onStartTest
                        )

                        _root_ide_package_.show.g.ui.nav.Tab.Stats -> _root_ide_package_.show.g.ui.stats.StatsScreen(
                            repo = repo
                        )
                    }
                }
            }
        }
    }
}
