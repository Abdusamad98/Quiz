package com.example.android.navigation.adapte

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.models.Status
import kotlinx.android.synthetic.main.status_item.view.*


@Suppress("DEPRECATION")
class QuestionStateAdapter(var data: ArrayList<Status>) :
        RecyclerView.Adapter<QuestionStateAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                    R.layout.status_item, parent, false
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


        @SuppressLint("ResourceAsColor")
        fun bind() {
            val d = data[adapterPosition]
            itemView.apply {
                when (d) {
                    Status.NOT_CHECKED -> {
                        status_text.text = (adapterPosition + 1).toString()
                        status_icon.background = resources.getDrawable(R.drawable.circle_status_1)
                    }
                    Status.CHECKED -> {
                        status_text.text =""
                        status_icon.background = resources.getDrawable(R.drawable.circle_status_6)
                    }
                    Status.CURRENT -> {
                        status_text.text = (adapterPosition + 1).toString()
                        status_icon.background = resources.getDrawable(R.drawable.circle_status_5)
                    }
                    Status.TRUE -> TODO()
                    Status.WRONG -> TODO()
                }

            }


        }
    }
}