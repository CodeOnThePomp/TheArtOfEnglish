package com.martino.jasiu.learnkotlin.db.table

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "word")
data class Word(@ColumnInfo(name = "body") var body: String, @ColumnInfo(name = "translation") var translation: String) {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0;

}