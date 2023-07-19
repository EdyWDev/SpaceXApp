package com.example.spacexapp.ui.theme.di

import com.example.spacexapp.ui.theme.service.SpaceXRepository
import com.example.spacexapp.ui.theme.service.SpaceXService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSpaceXRepository(
        spaceXService: SpaceXService
    ): SpaceXRepository =
        SpaceXRepository(spaceXService)
}