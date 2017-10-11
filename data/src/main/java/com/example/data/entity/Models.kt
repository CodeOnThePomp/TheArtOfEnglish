package com.example.data.entity

import android.arch.persistence.room.*


/**
 * Created by Artur on 27.08.2017.
 */
//@Entity(tableName = "Questions")
//data class QuestionEntity constructor(
//        @PrimaryKey(autoGenerate = true)
//        var id: Int?,
//        var title: String
//)
//@Entity(foreignKeys = arrayOf(ForeignKey(
//        entity = QuestionEntity::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("questionId"))
//
//))
//data class AnswerEntity constructor(
//        @PrimaryKey(autoGenerate = true)
//        var id: Int?,
//        var questionId: Int,
//        var description: String,
//        var correct: Boolean)
@Entity
class QuestionEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var title: String = ""
}
@Entity
data class AnswerEntity constructor(
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,
        var questionId: Int = 0,
        var description: String,
        var correct: Boolean)

class QuestionWithAnswersEntity {
    @Embedded
   var  question : QuestionEntity? = null
    @Relation(parentColumn = "id", entityColumn = "questionId", entity = AnswerEntity::class)
    var answers: List<AnswerEntity>? = null
}