package com.example.spacexapp.ui.theme.di

import android.content.Context
import com.example.spacexapp.ui.theme.service.SpaceXService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import javax.inject.Singleton

/*@Module
@InstallIn
object ApiModule{
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson =
        GsonBuilder()
            .create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create(gson))

   @Singleton
    @Provides
    fun provideSpaceXService(retrofit: Retrofit.Builder): SpaceXService =
        retrofit.build()
            .create(SpaceXService::class.java)

  *//*  val api: SpaceXApi by lazy {
        retrofit2.create(SpaceXApi::class.java)
    }*//*

}*/

object SpaceXService {
    private const val BASE_URL = "https://api.spacexdata.com/v3"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SpaceXApi by lazy {
        retrofit.create(SpaceXApi::class.java)
    }
}
interface SpaceXApi {
    @GET("/capsules")
    suspend fun getCapsules(): List<Capsule>

    @GET("/rockets")
    suspend fun getRockets(): List<Rocket>
}

data class Capsule(
    val capsuleId: String,
    val serial: String,
)

data class Rocket(
    val rocketId: String,
    val name: String,
)