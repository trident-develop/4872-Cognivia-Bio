package show.g.data

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateMapOf
import show.g.model.TestStats

class StatsRepository(context: Context) {

    private val prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val cache = mutableStateMapOf<String, show.g.model.TestStats>()

    init {
        MockTests.forEach { test ->
            cache[test.id] = readStats(test.id)
        }
    }

    val statsFlow: Map<String, show.g.model.TestStats> get() = cache

    fun statsFor(testId: String): show.g.model.TestStats = cache[testId] ?: TestStats(
        testId
    )

    fun totalTimeSpent(): Int = prefs.getInt(KEY_TOTAL_TIME, 0)

    fun totalCompleted(): Int = cache.values.sumOf { it.attempts }

    fun averageScore(): Int {
        val attempted = cache.values.filter { it.attempts > 0 }
        if (attempted.isEmpty()) return 0
        return attempted.sumOf { it.bestScore } / attempted.size
    }

    fun bestResult(): Int = cache.values.maxOfOrNull { it.bestScore } ?: 0

    fun recordResult(result: show.g.model.TestResult) {
        val prev = statsFor(result.testId)
        val updated = prev.copy(
            attempts = prev.attempts + 1,
            bestScore = maxOf(prev.bestScore, result.percent),
            lastScore = result.percent,
            completed = true,
            totalTimeSeconds = prev.totalTimeSeconds + result.timeSpentSeconds,
        )
        cache[result.testId] = updated
        writeStats(updated)
        val newTotal = totalTimeSpent() + result.timeSpentSeconds
        prefs.edit().putInt(KEY_TOTAL_TIME, newTotal).apply()
    }

    private fun readStats(testId: String): show.g.model.TestStats {
        val prefix = "test_${testId}_"
        return TestStats(
            testId = testId,
            attempts = prefs.getInt(prefix + "attempts", 0),
            bestScore = prefs.getInt(prefix + "best", 0),
            lastScore = prefs.getInt(prefix + "last", 0),
            completed = prefs.getBoolean(prefix + "completed", false),
            totalTimeSeconds = prefs.getInt(prefix + "time", 0),
        )
    }

    private fun writeStats(stats: show.g.model.TestStats) {
        val prefix = "test_${stats.testId}_"
        prefs.edit()
            .putInt(prefix + "attempts", stats.attempts)
            .putInt(prefix + "best", stats.bestScore)
            .putInt(prefix + "last", stats.lastScore)
            .putBoolean(prefix + "completed", stats.completed)
            .putInt(prefix + "time", stats.totalTimeSeconds)
            .apply()
    }

    companion object {
        private const val PREFS_NAME = "cognivia_bion_stats"
        private const val KEY_TOTAL_TIME = "total_time_seconds"
    }
}
