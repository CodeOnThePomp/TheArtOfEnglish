package com.example.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.data.entity.AnswerEntity
import com.example.data.entity.QuestionEntity
import com.example.data.entity.QuestionWithAnswersEntity
import io.reactivex.Single

@Dao
interface QuestionDao {
    @Query("SELECT * FROM QuestionEntity")
    fun getAllQuestions(): Single<List<QuestionWithAnswersEntity>>

    @Insert
    fun insertQuestions(question: QuestionEntity?, answers: List<AnswerEntity>?)

    @Insert
    fun insertQuestion(question: QuestionEntity?) : Long
    @Insert
    fun insertAnswers(answers: List<AnswerEntity>?)

//    @Update
//    fun updateQuestion(question: QuestionEntity) : Completable
//
//    @Delete
//    fun deleteQuestion(question: QuestionEntity) : Completable
//
}