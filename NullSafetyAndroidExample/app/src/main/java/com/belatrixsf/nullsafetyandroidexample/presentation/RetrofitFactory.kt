package com.belatrixsf.nullsafetyandroidexample.presentation

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Luis Alonso Paulino Flores
 *
 */

class RetrofitFactory {

    companion object {
        fun <T> create(clazz: Class<T>): T {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://codeforces.com/api/")
                    .client(OkHttpClient.Builder().addInterceptor(
                            HttpLoggingInterceptor()
                    ).build()).build()

            return retrofit.create(clazz)
        }
    }
}