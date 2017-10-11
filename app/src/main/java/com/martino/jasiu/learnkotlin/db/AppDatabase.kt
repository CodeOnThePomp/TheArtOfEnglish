package com.martino.jasiu.learnkotlin.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.martino.jasiu.learnkotlin.db.dao.WordDao
import com.martino.jasiu.learnkotlin.db.table.Word


@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

}