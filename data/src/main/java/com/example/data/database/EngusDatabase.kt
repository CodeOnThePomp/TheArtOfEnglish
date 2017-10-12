package com.example.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.data.database.dao.QuestionDao
import com.example.data.entity.AnswerEntity
import com.example.data.entity.QuestionEntity


/**
 * Created by Artur on 09.09.2017.
 */
@Database(entities = arrayOf(

        QuestionEntity::class,
        AnswerEntity::class
), version = 2, exportSchema = false)
abstract class EngusDatabase : RoomDatabase() {
    abstract fun questionDao() : QuestionDao
}