package com.martino.jasiu.learnkotlin.general.injection.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.data.database.EngusDatabase
import com.example.data.database.dao.QuestionDao
import com.example.data.di.qualifier.ApplicationContext
import com.example.data.di.scope.ApplicationScope
import com.example.data.entity.mapper.QuestionEntityMapper
import com.example.data.executor.JobExecutor
import com.example.data.source.QuestionDataRepository
import com.example.data.source.factory.QuestionsDataFactory
import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import com.example.domain.interactor.base.SingleUseCase
import com.example.domain.interactor.questions.GetQuestionList
import com.example.domain.model.QuestionWithAnswers
import com.example.domain.repository.QuestionRepository
import com.martino.jasiu.learnkotlin.UiThread
import com.martino.jasiu.learnkotlin.db.dao.WordDao
import com.martino.jasiu.learnkotlin.mainmenu.injection.component.MainMenuActivityComponent
import com.martino.jasiu.learnkotlin.mainmenu.presentation.ui.MainMenuActivity
import com.martino.jasiu.learnkotlin.manage.injection.component.ManageActivityComponent
import com.martino.jasiu.learnkotlin.start.injection.StartActivityComponent
import dagger.Module
import javax.inject.Singleton
import dagger.Provides



@Module(subcomponents = arrayOf(
        StartActivityComponent :: class,
        MainMenuActivityComponent :: class,
        ManageActivityComponent :: class
))
class ApplicationModule{

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }



    @Provides
    @ApplicationScope
    internal fun provideDataQuestionRepository(factory: QuestionsDataFactory,
                                               mapper: QuestionEntityMapper
    ): QuestionRepository {
        return QuestionDataRepository(factory, mapper)
    }

    @Provides
    @ApplicationScope
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @ApplicationScope
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @ApplicationScope
    @Provides
    internal fun provideDatabase(@ApplicationContext context: Context): EngusDatabase
            = Room.databaseBuilder(context, EngusDatabase::class.java, "sample.db").build()

    @ApplicationScope
    @Provides
    internal fun provideQuestionDao(db: EngusDatabase): QuestionDao = db.questionDao()


    @ApplicationScope
    @Provides
    internal fun provideGetQuestionUseCase(questionRepository: QuestionRepository,
                                           threadExecutor: ThreadExecutor,
                                           postExecutionThread: PostExecutionThread): SingleUseCase<List<QuestionWithAnswers>, Void?> {
        return GetQuestionList(questionRepository, threadExecutor, postExecutionThread)
    }

}
