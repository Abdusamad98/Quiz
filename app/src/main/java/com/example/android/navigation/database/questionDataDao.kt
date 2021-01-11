package com.example.android.navigation.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface questionDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll( videos: List<QuizzesData>)

    @Insert
    suspend fun insert(quizData: QuizzesData)

    @Update
    suspend fun update(quizData: QuizzesData)

    @Query("SELECT * from questions_table WHERE questionId = :key")
    suspend fun getQuizById(key: Long): QuizzesData?


    @Query("DELETE FROM questions_table")
    suspend fun clearAllQuizzes()

    @Query("SELECT * FROM questions_table WHERE subject_area=:subject ORDER BY questionId DESC")
    fun getAllQuizzes(subject:String): LiveData<List<QuizzesData>>

    //Actually i do not need this one
    @Query("SELECT * FROM questions_table ORDER BY questionId DESC LIMIT 1")
    suspend fun getQuizzes(): QuizzesData?



}