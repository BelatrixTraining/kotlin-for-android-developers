package com.belatrixsf.nullsafetyandroidexample.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.belatrixsf.nullsafetyandroidexample.R

/**
 * @author Luis Alonso Paulino Flores
 *
 */

class ProblemsAdapter(val problems: List<Problem>): RecyclerView.Adapter<ProblemsAdapter.ProblemViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProblemViewHolder {
        return ProblemViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_problem, p0, false))
    }

    override fun onBindViewHolder(p0: ProblemViewHolder, p1: Int) {
        p0.bind(problems[p1])
    }

    override fun getItemCount(): Int = problems.size

    class ProblemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        lateinit var problemNameTextView: TextView
        lateinit var problemContestIdTextView: TextView
        lateinit var problemIndexTextView: TextView

        fun bind(problem: Problem) {
            with(itemView) {
                problemNameTextView = findViewById(R.id.problemNameTextView)
                problemContestIdTextView = findViewById(R.id.problemContestIdTextView)
                problemIndexTextView = findViewById(R.id.problemIndexTextView)
            }

            with(problem) {
                problemNameTextView.text = name
                problemContestIdTextView.text = contestId.toString()
                problemIndexTextView.text = problem.index
            }
        }
    }
}