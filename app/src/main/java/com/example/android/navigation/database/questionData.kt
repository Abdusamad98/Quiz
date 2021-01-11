package com.example.android.navigation.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.navigation.models.Status

@Entity(tableName = "questions_table")

class QuizzesData(
        @PrimaryKey(autoGenerate = true)
        var questionId: Long = 0L,

        @ColumnInfo(name = "subject_area")
        var subject_area: String = "",

        @ColumnInfo(name = "question_text")
        var question_text: String = "",

        @ColumnInfo(name = "answer_1")
        var answer_1: String = "",

        @ColumnInfo(name = "answer_2")
        var answer_2: String = "",

        @ColumnInfo(name = "answer_3")
        var answer_3: String = "",

        @ColumnInfo(name = "answer_4")
        var answer_4: String = "",

        @ColumnInfo(name = "true_answer")
        var true_answer: String = "",

        @ColumnInfo(name = "question_status")
        var question_status: String = "NOT_CHECKED",

        @ColumnInfo(name = "selection")
        var selection: String = "",

        @ColumnInfo(name = "score")
        var score: Int = 3
)

