package com.martino.jasiu.learnkotlin.general.presentation.dialog

import io.reactivex.subjects.Subject


class NewWordLayoutSettings {

    protected constructor()

    val header: String = ""
    val wordHint: String = ""
    val translationHint: String = ""
    val leftButtonText: String = ""
    val rightButtonText: String = ""

    val leftButtonClick: Subject<Object>? = null
    val rightButtonClick: Subject<Object>? = null
}