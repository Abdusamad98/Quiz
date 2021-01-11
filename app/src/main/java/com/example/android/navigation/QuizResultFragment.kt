
package com.example.android.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.navigation.adapter.ResultAdapter
import com.example.android.navigation.databinding.FragmentQuizResultBinding
import com.example.android.navigation.models.QuizData
import com.example.android.navigation.models.Status


class QuizResultFragment : Fragment() {

    lateinit var adapter: ResultAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentQuizResultBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_quiz_result, container, false)


      //  activity?.actionBar!!.hide()

        val args = QuizResultFragmentArgs.fromBundle(requireArguments()).dataList as Array<QuizData>
        val time = QuizResultFragmentArgs.fromBundle(requireArguments()).time

        val gridLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        adapter = ResultAdapter(args)
        binding.resultList.adapter = adapter
        binding.resultList.layoutManager = gridLayoutManager


        var trues_count = 0
        var false_count = 0
        var total_score = 0
        for (item in args) {
            when (item.question_status) {
                Status.TRUE -> {
                    total_score += item.score
                    trues_count++
                }
                Status.WRONG -> {
                    false_count++
                }
                //Here I dont need these
                //Status.CURRENT -> TODO()
                //Status.CHECKED -> TODO()
                //Status.NOT_CHECKED -> TODO()
            }
        }

        binding.countFalseAnswers.text = "Wrong answers: $false_count"
        binding.countTrueAnswers.text = "True answers: $trues_count"
        binding.totalScore.text = "Total score: $total_score"
        binding.spentTime.text = "Spent time: $time"


        binding.goCategories.setOnClickListener { view ->
            view.findNavController().navigate(QuizResultFragmentDirections.actionQuizResultFragmentToTitleFragment())
        }
        return binding.root
    }
}
