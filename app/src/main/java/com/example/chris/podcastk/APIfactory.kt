package com.example.chris.podcastk

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object APIfactory {
        private val authInterceptor = Interceptor { chain ->
            val newUrl = chain.request().url()
                    .newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build()

            val newRequest = chain.request()
                    .newBuilder()
                    .url(newUrl)
                    .build()

            chain.proceed(newRequest)

        }

    //OkhttpClient for building http request url
    private val listenClient = OkHttpClient().newBuilder()
            .addInterceptor(APIfactory.authInterceptor)
            .build()



    fun retrofit() : Retrofit = Retrofit.Builder()
            .client(listenClient)
            .baseUrl("https://listen-api.listennotes.com/api/v2")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()


    val listenApi : ListenAPI = retrofit().create(ListenAPI::class.java)

}