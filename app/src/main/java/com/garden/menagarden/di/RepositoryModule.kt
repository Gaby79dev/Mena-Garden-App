package com.garden.menagarden.di

import com.garden.menagarden.data.repository.MenuRepository
import com.garden.menagarden.data.repository.MenuRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMenuRepository(impl: MenuRepositoryImpl): MenuRepository
}
