package com.example.test.modules.services

import com.example.test.commons.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {


    companion object{
        private val interceptor1 = HttpLoggingInterceptor()
        private val client1: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptor(interceptor1)
        private val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        fun <S> createService(serviceClass: Class<S>?): S {
            interceptor1.setLevel(HttpLoggingInterceptor.Level.BODY)
            val retrofit1 = builder.client(client1.build()).build()
            return retrofit1.create(serviceClass)
        }
    }


}