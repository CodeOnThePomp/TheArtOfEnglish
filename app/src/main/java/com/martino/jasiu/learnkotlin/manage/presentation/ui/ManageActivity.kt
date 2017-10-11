package com.martino.jasiu.learnkotlin.manage.presentation.ui

import android.os.Bundle
import com.martino.jasiu.learnkotlin.R
import com.martino.jasiu.learnkotlin.general.presentation.CommonActivity
import com.martino.jasiu.learnkotlin.manage.presentation.viewmodel.ManageActivityViewModel

class ManageActivity : CommonActivity<ManageActivityViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)
    }
}
