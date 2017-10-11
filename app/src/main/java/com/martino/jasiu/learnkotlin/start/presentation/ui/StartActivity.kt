package com.martino.jasiu.learnkotlin.start.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.martino.jasiu.learnkotlin.R
import com.martino.jasiu.learnkotlin.db.dao.WordDao
import com.martino.jasiu.learnkotlin.db.table.Word
import com.martino.jasiu.learnkotlin.general.presentation.CommonActivity
import com.martino.jasiu.learnkotlin.mainmenu.presentation.ui.MainMenuActivity
import com.martino.jasiu.learnkotlin.start.presentation.viewModel.StartActivityViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_start.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class StartActivity : CommonActivity<StartActivityViewModel>() {

    @Inject
    lateinit var dao: WordDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        initializeViews()

        viewModel.logIsWorking()

        dao.insertWord(Word("dupsko", "ass"))
        dao.insertWord(Word("dupsko1", "ass2"))
        dao.insertWord(Word("dupsko11", "ass"))
        dao.insertWord(Word("dupsko1", "ass"))
        dao.insertWord(Word("dupsko2", "ass"))
        dao.insertWord(Word("dupsko", "ass2"))
        dao.insertWord(Word("dupsko", "ass"))

        Observable.just(3)
                .observeOn(Schedulers.io())
                .delay(3, TimeUnit.SECONDS)
                .subscribe({
                    Log.d("elo", "dziala")
                    startActivity(Intent(this@StartActivity, MainMenuActivity::class.java))
                })
    }

    private fun initializeViews() {
        start_text.text = getString(R.string.start_text)
    }

}
