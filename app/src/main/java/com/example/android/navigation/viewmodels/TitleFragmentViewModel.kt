package com.example.android.navigation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.navigation.database.QuizzesData
import com.example.android.navigation.database.questionDataDao
import com.example.android.navigation.models.QuizData
import kotlinx.coroutines.launch

class TitleFragmentViewModel(
        val database: questionDataDao,
        application: Application
) : AndroidViewModel(application) {


    //val calculations = database.getAllQuizzes(st:St)

    private suspend fun insert(quizzesData: QuizzesData) {
        database.insert(quizzesData)
    }

    private suspend fun insertAll(quizzesData: List<QuizzesData>) {
        database.insertAll(quizzesData)
    }

    private suspend fun clear() {
        database.clearAllQuizzes()
    }




    fun getAllQuizes(subject:String): LiveData<List<QuizzesData>> {
        return database.getAllQuizzes(subject)
    }






    fun onSaveData(subject:String,quizzesDatas: ArrayList<QuizData>) {

        var arrayList = ArrayList<QuizzesData>()

        for (i in 0 until quizzesDatas.size) {
             arrayList.add(QuizzesData(
                     0,
                     subject,
                     quizzesDatas[i].question_text,
                     quizzesDatas[i].answer_1,
                     quizzesDatas[i].answer_2,
                     quizzesDatas[i].answer_3,
                     quizzesDatas[i].answer_4,
                     quizzesDatas[i].true_answer,
                     quizzesDatas[i].selection,
                     quizzesDatas[i].score.toString()
             ))
        }
            viewModelScope.launch {
                insertAll(arrayList)
            }
    }


    fun onClearAll() {
        viewModelScope.launch {
            clear()
        }
    }


}