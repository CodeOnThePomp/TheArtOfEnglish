package com.example.data.source.factory

import com.example.data.repository.QuestionDbStore
import javax.inject.Inject

/**
 * Created by Artur on 12.09.2017.
 */
class QuestionsDataFactory @Inject constructor(private  val questionDbDataStore : QuestionDbDataStore) {
    fun retrieveDbDataStore() : QuestionDbStore {
        return questionDbDataStore
    }
}