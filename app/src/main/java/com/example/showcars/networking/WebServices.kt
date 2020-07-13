package com.example.showcars.networking


import com.example.showcars.data.CarsResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private const val BASE_URL = "http://demo1286023.mockable.io/api/v1/"

@JvmSuppressWildcards
interface WebService {

    @GET("cars")
    suspend fun getCars(
            @Query("page") page: Int
    ): Response<CarsResponse>

    companion object {

        operator fun invoke(
                networkConnectionInterceptor: NetworkConnectionInterceptor

        ): WebService {

            // adding interceptor to retrofit
            val okHttpClint = OkHttpClient.Builder()
                    .addInterceptor(networkConnectionInterceptor)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClint)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WebService::class.java)
        }
    }
}