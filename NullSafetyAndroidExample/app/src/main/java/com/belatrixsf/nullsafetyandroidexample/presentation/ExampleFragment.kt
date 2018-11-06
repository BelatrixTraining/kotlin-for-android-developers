package com.belatrixsf.nullsafetyandroidexample.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.belatrixsf.nullsafetyandroidexample.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Luis Alonso Paulino Flores
 *
 */

class ExampleFragment: Fragment(), Callback<GetProblemsResponse> {

    lateinit var progressBar: ProgressBar
    lateinit var problemsListView: RecyclerView

    companion object {
        fun newInstance(username: String): ExampleFragment {
            return ExampleFragment().apply {
                arguments = Bundle().also {
                    it.putString(Constants.ARG_USERNAME, username)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progressBar)
        problemsListView = view.findViewById(R.id.problemsListView)

        val username: String? = arguments?.getString(Constants.ARG_USERNAME)

        username?.let {
            progressBar.visibility = View.VISIBLE

            RetrofitFactory.create(CodeforcesApi::class.java).getProblems().enqueue(this)
        }
    }

    override fun onResponse(call: Call<GetProblemsResponse>, response: Response<GetProblemsResponse>) {
        if (isAdded) {
            progressBar.visibility = View.GONE

            if (response.isSuccessful) {
                response.body()?.result?.problems?.takeIf {
                    it.isNotEmpty()
                }?.let {
                    problemsListView.layoutManager = LinearLayoutManager(context)
                    problemsListView.adapter = ProblemsAdapter(it)
                }
            } else {
                Toast.makeText(context, "Something went wrong :(", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onFailure(call: Call<GetProblemsResponse>, t: Throwable) {
        if (isAdded) {
            progressBar.visibility = View.GONE
            Toast.makeText(context, "Something went wrong :(", Toast.LENGTH_SHORT).show()
        }
    }
}
