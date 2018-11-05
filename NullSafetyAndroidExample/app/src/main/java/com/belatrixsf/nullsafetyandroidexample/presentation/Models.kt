package com.belatrixsf.nullsafetyandroidexample.presentation

/**
 * @author Luis Alonso Paulino Flores
 *
 */

data class Problem(val contestId: Int, val index: String, val name: String, val type: String)

data class GetProblemsResult(val problems: List<Problem>)

data class GetProblemsResponse(val status: String, val result: GetProblemsResult)