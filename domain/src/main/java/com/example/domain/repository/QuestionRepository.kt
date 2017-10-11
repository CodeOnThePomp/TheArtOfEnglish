package com.example.domain.repository

import com.example.domain.model.Question
import com.example.domain.model.QuestionWithAnswers
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Artur on 27.08.2017.
 */
interface QuestionRepository{
    fun getQuestions() : Single<List<QuestionWithAnswers>>
    fun addQuestions(questions : List<QuestionWithAnswers>) : Completable

}