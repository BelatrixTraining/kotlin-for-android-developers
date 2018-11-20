package com.kotlin.samples.modules.knotes.ui.data

import com.kotlin.samples.modules.knotes.model.NoteEntity
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.io.File
import java.util.*

class ApiClient {

    companion object {
        private var servicesApiInterface: ServicesApiInterface? = null
        private val API_BASE_URL = "https://agile-scrubland-67451.herokuapp.com"
        private fun interceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return httpLoggingInterceptor
        }

        private fun defaultCache():Cache{
            val cacheSize:Long=10 * 1024 * 1024;
            val cacheDir = File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString())
            val cache:Cache= Cache(cacheDir,cacheSize)
            return  cache
        }

        fun getMyApiClient(): ServicesApiInterface {
            var builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
            var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor())
            httpClient.cache(defaultCache())
            var retrofit: Retrofit = builder.client(httpClient.build()).build()
            servicesApiInterface = retrofit.create(
                ServicesApiInterface::class.java)
            return servicesApiInterface as ServicesApiInterface
        }
    }

    interface ServicesApiInterface {
        @Headers("Content-Type: application/json")
        @GET("/api/notes")
        fun notes(): Call<List<NoteEntity>>


        @Headers("Content-Type: application/json")
        @GET("/api/users")
        fun users(): Call<List<Any>>
    }
}