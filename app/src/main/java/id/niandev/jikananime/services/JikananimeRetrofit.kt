package id.niandev.jikananime.services

import com.google.gson.GsonBuilder
import id.niandev.jikananime.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Azhar Nian on 29/12/20.
 * NIANDEV
 * azharnian@gmail.com
 */

fun getApi(): Retrofit {
    val gson = GsonBuilder().create()
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .baseUrl(BuildConfig.BASE_URL)
        .build()

    return retrofit
}