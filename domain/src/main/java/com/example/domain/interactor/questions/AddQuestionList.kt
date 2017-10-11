package com.example.domain.interactor.questions

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import com.example.domain.interactor.base.CompletableUseCase
import com.example.domain.repository.QuestionRepository
import io.reactivex.Completable
import javax.inject.Inject
import com.example.domain.model.QuestionWithAnswers
/**
 * Created by Artur on 12.09.2017.
 */
class AddQuestionList @Inject constructor(private val questionRepository: QuestionRepository,
                                          threadExecutor: ThreadExecutor,
                                          postExecutionThread: PostExecutionThread) :
        CompletableUseCase<List<QuestionWithAnswers>>(threadExecutor, postExecutionThread) {
    override fun build(params: List<QuestionWithAnswers>): Completable {
        return questionRepository.addQuestions(params)
    }

}