package com.example.data.entity.mapper


import com.example.data.entity.AnswerEntity
import com.example.data.entity.QuestionEntity
import com.example.data.entity.QuestionWithAnswersEntity
import com.example.domain.model.Answer
import com.example.domain.model.Question
import com.example.domain.model.QuestionWithAnswers
import javax.inject.Inject

/**
 * Created by Artur on 31.08.2017.
 */
class QuestionEntityMapper @Inject constructor() : Mapper<QuestionWithAnswersEntity, QuestionWithAnswers> {
    override fun mapFromEntity(type: QuestionWithAnswersEntity): QuestionWithAnswers {
        return QuestionWithAnswers(transformToQuestion(type.question), transformToAnswers(type.answers))
    }

    override fun mapToEntity(type: QuestionWithAnswers): QuestionWithAnswersEntity {
        val entity = QuestionWithAnswersEntity()
        entity.answers = transformToAnswersEntity(type.answers)
        entity.question = transformToQuestionEntity(type.question)
        return entity
    }


    private fun transformToAnswers(answersEntity: List<AnswerEntity>?): ArrayList<Answer> {
        val answers = ArrayList<Answer>()
        answersEntity?.forEach {
            answers.add(Answer(it.description, it.correct))
        }
        return answers
    }

    private fun transformToQuestion(questionEntity: QuestionEntity?): Question {
        return Question(questionEntity?.title)
    }

    private fun transformToAnswersEntity(answers: List<Answer>?): List<AnswerEntity>? {
        val answersEntity = ArrayList<AnswerEntity>()
        answers?.forEach {


            answersEntity.add(AnswerEntity(description = it.description!!, correct = it.correct!!))
        }
        return answersEntity
    }

    private fun transformToQuestionEntity(question: Question?): QuestionEntity {
        val entity = QuestionEntity()
        entity.title = question?.title!!
        return entity
    }
}