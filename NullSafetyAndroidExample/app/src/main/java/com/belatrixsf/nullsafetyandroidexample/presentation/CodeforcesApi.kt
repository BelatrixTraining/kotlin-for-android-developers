package com.belatrixsf.nullsafetyandroidexample.presentation

import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Luis Alonso Paulino Flores
 *
 */

interface CodeforcesApi {

    @GET("problemset.problems?tags=graphs")
    fun getProblems(): Call<GetProblemsResponse>
}