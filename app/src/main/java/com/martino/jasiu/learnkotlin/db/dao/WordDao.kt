package com.martino.jasiu.learnkotlin.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.martino.jasiu.learnkotlin.db.table.Word


@Dao
interface WordDao {

    @Query("select * from word")
    fun findAllWords(): List<Word>

    @Query("select * from word where id = :id")
    fun findWordById(id: Long): Word

    @Insert(onConflict = REPLACE)
    fun insertWord(word: Word)

    @Delete
    fun deleteWord(word: Word)
}