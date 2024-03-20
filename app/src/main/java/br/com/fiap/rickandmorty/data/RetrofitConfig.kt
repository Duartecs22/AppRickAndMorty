package br.com.fiap.rickandmorty.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitConfig {
    companion object{
        val client: Retrofit?
            get() {
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

                var loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                val okHttpClient = OkHttpClient.Builder()
                okHttpClient.addInterceptor(loggingInterceptor)

                return Retrofit.Builder()
                    .baseUrl("https://rickandmortyapi.com/api/")
                    .client(okHttpClient.build())
                    .addConverterFactory((MoshiConverterFactory.create(moshi)))
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
            }
    }
}
