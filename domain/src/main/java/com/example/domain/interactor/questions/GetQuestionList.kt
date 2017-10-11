package com.example.domain.interactor.questions

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import com.example.domain.interactor.base.SingleUseCase
import com.example.domain.model.Question
import com.example.domain.model.QuestionWithAnswers
import com.example.domain.repository.QuestionRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Artur on 27.08.2017.
 */

class GetQuestionList @Inject constructor(private val questionRepository: QuestionRepository,
                                          threadExecutor: ThreadExecutor,
                                          postExecutionThread: PostExecutionThread):
SingleUseCase<List<QuestionWithAnswers>, Void?>(threadExecutor, postExecutionThread) {
    override fun build(params: Void?): Single<List<QuestionWithAnswers>> {
      return questionRepository.getQuestions()
    }
}