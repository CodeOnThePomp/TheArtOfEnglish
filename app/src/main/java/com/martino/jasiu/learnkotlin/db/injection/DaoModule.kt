package com.martino.jasiu.learnkotlin.db.injection

import android.arch.persistence.room.Room
import android.content.Context
import com.martino.jasiu.learnkotlin.db.AppDatabase
import com.martino.jasiu.learnkotlin.mainmenu.injection.component.MainMenuActivityComponent
import com.martino.jasiu.learnkotlin.start.injection.StartActivityComponent
import dagger.Module
import dagger.Provides


@Module(subcomponents = arrayOf(
        StartActivityComponent :: class,
        MainMenuActivityComponent :: class
))
class DaoModule {

    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-database")
                    .allowMainThreadQueries()
                    .build()

    @Provides
    fun provideWordDao(database: AppDatabase) = database.wordDao()

}