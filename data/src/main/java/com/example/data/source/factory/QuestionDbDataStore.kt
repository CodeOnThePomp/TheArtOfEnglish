package com.example.data.source.factory


import com.example.data.database.dao.QuestionDao
import com.example.data.entity.QuestionWithAnswersEntity
import com.example.data.repository.QuestionDbStore

import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Artur on 09.09.2017.
 */

open class QuestionDbDataStore @Inject constructor(private val dbHelper: QuestionDao) : QuestionDbStore {
    override fun insertQuestions(questionWithAnswers: List<QuestionWithAnswersEntity>): Completable {
       return  Completable.fromCallable {
        questionWithAnswers.map {
            val id = dbHelper.insertQuestion(it.question)
            it.answers?.map {
                it.questionId = id.toInt()
            }
            dbHelper.insertAnswers(it.answers)
        }

       }
    }

    override fun getAllQuestions(): Single<List<QuestionWithAnswersEntity>> {
        return dbHelper.getAllQuestions()

    }


}