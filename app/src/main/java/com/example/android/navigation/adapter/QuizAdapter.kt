package com.example.android.navigation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.models.QuizData
import kotlinx.android.synthetic.main.question_item.view.*


@Suppress("DEPRECATION")
class QuizAdapter(var data: ArrayList<QuizData>) :
        RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                    R.layout.question_item, parent, false
            )
    )

    private var listener: ((Int, String) -> Unit)? = null

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    @SuppressLint("UseCompatLoadingForDrawables")
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.apply {
                answer_1.setOnClickListener {
                    listener?.invoke(adapterPosition, "A")
                }
                answer_2.setOnClickListener {
                    listener?.invoke(adapterPosition, "B")
                }
                answer_3.setOnClickListener {
                    listener?.invoke(adapterPosition, "C")
                }
                answer_4.setOnClickListener {
                    listener?.invoke(adapterPosition, "D")
                }


            }
        }

        @SuppressLint("ResourceAsColor")
        fun bind() {
            val d = data[adapterPosition]
            itemView.apply {
                question_text.text = d.question_text
                answer_text1.text = d.answer_1
                answer_text2.text = d.answer_2
                answer_text3.text = d.answer_3
                answer_text4.text = d.answer_4
                question_order.text = "Quiz: ${adapterPosition + 1}"
                score.text = d.score.toString()

                when (data[adapterPosition].selection) {
                    "A" -> {
                        answer_1.background = resources.getDrawable(R.drawable.button_chosen)
                        answer1.setTextColor(resources.getColor(R.color.colorWhite))
                        answer_text1.setTextColor(resources.getColor(R.color.colorWhite))

                        answer_2.background = resources.getDrawable(R.drawable.button_border_black)
                        answer2.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text2.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_3.background = resources.getDrawable(R.drawable.button_border_black)
                        answer3.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text3.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_4.background = resources.getDrawable(R.drawable.button_border_black)
                        answer4.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text4.setTextColor(resources.getColor(R.color.colorBlack))

                    }
                    "B" -> {
                        answer2.setTextColor(resources.getColor(R.color.colorWhite))
                        answer_2.background = resources.getDrawable(R.drawable.button_chosen)
                        answer_text2.setTextColor(resources.getColor(R.color.colorWhite))

                        answer_1.background = resources.getDrawable(R.drawable.button_border_black)
                        answer1.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text1.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_3.background = resources.getDrawable(R.drawable.button_border_black)
                        answer3.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text3.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_4.background = resources.getDrawable(R.drawable.button_border_black)
                        answer4.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text4.setTextColor(resources.getColor(R.color.colorBlack))
                    }
                    "C" -> {
                        answer3.setTextColor(resources.getColor(R.color.colorWhite))
                        answer_text3.setTextColor(resources.getColor(R.color.colorWhite))
                        answer_3.background = resources.getDrawable(R.drawable.button_chosen)
                        answer_2.background = resources.getDrawable(R.drawable.button_border_black)
                        answer2.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text2.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_1.background = resources.getDrawable(R.drawable.button_border_black)
                        answer1.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text1.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_4.background = resources.getDrawable(R.drawable.button_border_black)
                        answer4.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text4.setTextColor(resources.getColor(R.color.colorBlack))
                    }
                    "D" -> {
                        answer4.setTextColor(resources.getColor(R.color.colorWhite))
                        answer_text4.setTextColor(resources.getColor(R.color.colorWhite))
                        answer_4.background = resources.getDrawable(R.drawable.button_chosen)

                        answer_2.background = resources.getDrawable(R.drawable.button_border_black)
                        answer2.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text2.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_3.background = resources.getDrawable(R.drawable.button_border_black)
                        answer3.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text3.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_1.background = resources.getDrawable(R.drawable.button_border_black)
                        answer1.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text1.setTextColor(resources.getColor(R.color.colorBlack))
                    }
                    else -> {

                        answer_1.background = resources.getDrawable(R.drawable.button_border_black)
                        answer1.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text1.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_2.background = resources.getDrawable(R.drawable.button_border_black)
                        answer2.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text2.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_3.background = resources.getDrawable(R.drawable.button_border_black)
                        answer3.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text3.setTextColor(resources.getColor(R.color.colorBlack))

                        answer_4.background = resources.getDrawable(R.drawable.button_border_black)
                        answer4.setTextColor(resources.getColor(R.color.colorBlack))
                        answer_text4.setTextColor(resources.getColor(R.color.colorBlack))
                    }
                }
            }

        }
    }

    fun answerPressedListener(f: ((Int, String) -> Unit)?) {
        listener = f
    }

}