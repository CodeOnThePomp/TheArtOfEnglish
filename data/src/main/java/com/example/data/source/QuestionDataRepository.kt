package com.example.data.source


import com.example.data.entity.mapper.QuestionEntityMapper
import com.example.data.source.factory.QuestionsDataFactory
import com.example.domain.model.QuestionWithAnswers
import com.example.domain.repository.QuestionRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


class QuestionDataRepository @Inject constructor(private val questionsDataFactory: QuestionsDataFactory,
                                                 private val questionMapper: QuestionEntityMapper) : QuestionRepository {
    override fun addQuestions(questions: List<QuestionWithAnswers>): Completable {
        val dataStore = questionsDataFactory.retrieveDbDataStore()
        return dataStore.insertQuestions(questions.map { questionMapper.mapToEntity(it) })
    }

    override fun getQuestions(): Single<List<QuestionWithAnswers>> {
        val dataStore = questionsDataFactory.retrieveDbDataStore()
        return dataStore.getAllQuestions()
                .flatMap {
                    val questions = mutableListOf<QuestionWithAnswers>()
                    it.map { questions.add(questionMapper.mapFromEntity(it)) }
                    Single.just(questions)
                }
    }

}
