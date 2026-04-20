package com.takeonecompany.bp.model

data class Topic(
    val id: String,
    val title: String,
    val summary: String,
    val keyPoints: List<String> = emptyList(),
    val deepDive: String = "",
)

data class LearnCategory(
    val id: String,
    val title: String,
    val subtitle: String,
    val iconKey: String,
    val topics: List<Topic>,
)

data class Question(
    val prompt: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String = "",
)

data class BioTest(
    val id: String,
    val title: String,
    val description: String,
    val iconKey: String,
    val questions: List<Question>,
) {
    val questionCount: Int get() = questions.size
    val timeLimitSeconds: Int = 300
}

data class TestResult(
    val testId: String,
    val correct: Int,
    val wrong: Int,
    val total: Int,
    val percent: Int,
    val timeSpentSeconds: Int,
)

data class TestStats(
    val testId: String,
    val attempts: Int = 0,
    val bestScore: Int = 0,
    val lastScore: Int = 0,
    val completed: Boolean = false,
    val totalTimeSeconds: Int = 0,
)
