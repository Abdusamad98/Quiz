package com.example.android.navigation

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.adapte.QuestionStateAdapter
import com.example.android.navigation.adapter.QuizAdapter
import com.example.android.navigation.database.QuizzesDatabase
import com.example.android.navigation.databinding.FragmentQuizBinding
import com.example.android.navigation.models.QuizData
import com.example.android.navigation.models.Status
import com.example.android.navigation.utils.*
import com.example.android.navigation.viewmodels.TitleFragmentViewModel
import com.example.android.navigation.viewmodels.TitleFragmentViewModelFactory

class QuizFragment : Fragment() {

    lateinit var adapter: QuizAdapter
    lateinit var questions: ArrayList<QuizData>
    lateinit var adapter_status: QuestionStateAdapter
    lateinit var status_list: ArrayList<Status>
    private var questionIndex = 0
    var score: Int = 0
    lateinit var titleFragmentViewModel: TitleFragmentViewModel


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
                inflater, R.layout.fragment_quiz, container, false)

        val args = QuizFragmentArgs.fromBundle(requireArguments()).quizType

//
//        val application = requireNotNull(this.activity).application
//        var dataSource = QuizzesDatabase.getInstance(application).questionDataDao
//        val viewModelFactory = TitleFragmentViewModelFactory(dataSource, application)
//        titleFragmentViewModel = ViewModelProvider(this, viewModelFactory).get(TitleFragmentViewModel::class.java)
//

        questions = ArrayList()
        if (args == "Android") {
            questions.addAll(getAndroidQuizList())
        } else if (args == "Web")
            questions.addAll(getWebQuizList())

        binding.time.start()
        //Set Recycler View 1


        val gridLayoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        adapter = QuizAdapter(questions)
        binding.questionsList.adapter = adapter
        binding.questionsList.layoutManager = gridLayoutManager

        //  status_list = ArrayList()

        status_list = getStatuses(questions)
        val gridLayoutManager1 = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        adapter_status = QuestionStateAdapter(status_list)
        binding.statusList.adapter = adapter_status
        binding.statusList.layoutManager = gridLayoutManager1


        //Set SnapHelpers
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.questionsList)

        val snapHelper1 = LinearSnapHelper()
        snapHelper1.attachToRecyclerView(binding.statusList)

        //Find Scrolled item Position
        binding.questionsList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val centerView = snapHelper.findSnapView(gridLayoutManager)
                val pos = gridLayoutManager.getPosition(centerView!!)
                if (newState == RecyclerView.SCROLL_STATE_IDLE || (pos == 0 && newState == RecyclerView.SCROLL_STATE_DRAGGING)) {
                    gridLayoutManager1.scrollToPosition(pos)
                    Log.d("BINDING", "positionView SCROLL_STATE_IDLE: $pos")
                }
            }

        })

        adapter.answerPressedListener { position, selection ->
            questions[position].selection = selection
            questions[position].question_status = Status.CHECKED
            adapter.notifyDataSetChanged()

            status_list[position] = Status.CHECKED
            adapter_status.notifyDataSetChanged()
        }


        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        val timer = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {

                // view?.findNavController()?.navigate(QuizFragmentDirections.actionQuizFragmentToQuizResultFragment(convertArrayListToArray(checkedQuiz(questions)),binding.time.text.toString()))
                // binding.submit.callOnClick()

            }
        }
        timer.start()

        binding.submit.setOnClickListener { view: View ->
            binding.time.stop()
            view.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToQuizResultFragment(convertArrayListToArray(checkedQuiz(questions)), binding.time.text.toString()))
        }

        return binding.root
    }


    private fun checkedQuiz(questions: ArrayList<QuizData>): ArrayList<QuizData> {
        for (i in 0 until questions.size) {
            val item = questions[i]

            if (item.question_status == Status.CHECKED && item.selection == "A" && item.answer_1 == item.true_answer) {
                score += 5
                questions[i].question_status = Status.TRUE
            } else
                if (item.question_status == Status.CHECKED && item.selection == "A" && item.answer_1 != item.true_answer) {
                    questions[i].question_status = Status.WRONG
                }

            if (item.question_status == Status.CHECKED && item.selection == "B" && item.answer_2 == item.true_answer) {
                score += 5
                questions[i].question_status = Status.TRUE
            } else
                if (item.question_status == Status.CHECKED && item.selection == "B" && item.answer_2 != item.true_answer) {
                    questions[i].question_status = Status.WRONG
                }

            if (item.question_status == Status.CHECKED && item.selection == "C" && item.answer_3 == item.true_answer) {
                score += 5
                questions[i].question_status = Status.TRUE
            } else
                if (item.question_status == Status.CHECKED && item.selection == "C" && item.answer_3 != item.true_answer) {
                    questions[i].question_status = Status.WRONG
                }

            if (item.question_status == Status.CHECKED && item.selection == "D" && item.answer_4 == item.true_answer) {
                score += 5
                questions[i].question_status = Status.TRUE
            } else
                if (item.question_status == Status.CHECKED && item.selection == "D" && item.answer_4 != item.true_answer) {
                    questions[i].question_status = Status.WRONG
                }

        }
        return questions
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
    }

}
