package com.example.domain.model

import java.io.Serializable


data class Question(val title: String?) : Serializable

class QuestionWithAnswers(val question: Question?, val answers: List<Answer>?) : Serializable


data class Answer(val description: String?, val correct: Boolean?) : Serializable