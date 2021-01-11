package com.example.android.navigation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuizData(val question_text: String, val answer_1: String, val answer_2: String, val answer_3: String, val answer_4: String, val true_answer: String, var question_status: Status, var selection: String = "", var score: Int = 5) : Parcelable
