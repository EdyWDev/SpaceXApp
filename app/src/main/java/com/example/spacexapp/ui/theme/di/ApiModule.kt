package com.example.spacexapp.ui.theme.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
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

/*
    @Singleton
    @Provides
    fun provideHomeBarService(retrofit: Retrofit.Builder): RecipeService =
        retrofit
            .build()
            .create(RecipeService::class.java)


    //Hilt needs to know how to create an instance of DrinkDatabase. For that add another method below provideDao.
    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, DrinkDatabase::class.java, DRINK_DATABASE)
        .allowMainThreadQueries() // Tutaj raczej tego nie powinno byc, nie powinny calle do bazy danych leciec na glownym watku
        // jak sprobujesz to wykomentowac to najprawdopobniej dostaniesz crash przy probie zapisu albo poleci ostrzezenie w logach\
        // tak czy siak pasuje zebys sprobowala to usunac i sfixowac problem
        .addTypeConverter(DrinkEntitiesConverters(GsonParser(Gson())))
        .fallbackToDestructiveMigration()
        .build()
    //This annotation marks the method provideDao as a provider of drinkDoa.
    @Provides
    @Singleton
    fun provideDao(db: DrinkDatabase) = db.drinkDao()

    @Provides
    fun provideEntity() = DrinkEntity()*/

}