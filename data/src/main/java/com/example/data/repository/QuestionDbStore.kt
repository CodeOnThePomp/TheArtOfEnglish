package com.example.data.repository

import com.example.data.entity.QuestionWithAnswersEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Artur on 12.09.2017.
 */
interface QuestionDbStore {
    fun getAllQuestions(): Single<List<QuestionWithAnswersEntity>>
    fun insertQuestions(questionWithAnswers: List<QuestionWithAnswersEntity>) : Completable
}