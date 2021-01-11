package com.example.android.navigation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.models.QuizData
import com.example.android.navigation.models.Status
import kotlinx.android.synthetic.main.result_item.view.*


@Suppress("DEPRECATION")
class ResultAdapter(var data: Array<QuizData>) :
        RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                    R.layout.result_item, parent, false
            )
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    @SuppressLint("UseCompatLoadingForDrawables")
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.apply {
            }
        }


        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun bind() {
            val d = data[adapterPosition]
            itemView.apply {
                when (d.question_status) {
                    Status.TRUE -> {
                        result_icon.background = resources.getDrawable(R.drawable.circle_status_3)
                        point.text = d.score.toString() + " coins"
                        result_order.text = (adapterPosition + 1).toString()
                    }
                    Status.WRONG -> {
                        point.text = context.getString(R.string.zero_coins)
                        result_order.text = (adapterPosition + 1).toString()
                        result_icon.background = resources.getDrawable(R.drawable.circle_status_4)
                    }
                    else -> {
                        point.text =context.getString(R.string.not_try)
                        result_order.text = (adapterPosition + 1).toString()
                        result_icon.background = resources.getDrawable(R.drawable.circle_status_2)
                    }
                }
            }


        }
    }
}