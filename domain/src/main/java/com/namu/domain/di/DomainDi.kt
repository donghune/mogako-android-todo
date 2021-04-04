package com.namu.domain.di

import com.namu.data.datasource.PostLocalDataSource
import com.namu.data.datasource.SharedDataSource
import com.namu.domain.PostWriteUsecase
import com.namu.domain.PostWriteUsecaseImpl
import com.namu.domain.repository.*
import com.namu.domain.usecase.PostReadUseCase
import com.namu.domain.usecase.PostReadUseCaseImpl
import com.namu.domain.usecase.SharedUseCase
import com.namu.domain.usecase.SharedUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainDi {

    @Provides
    fun provicePostLocalRepository(datasource:PostLocalDataSource):PostLocalRepository{
        return PostRepositoryImpl(datasource)
    }

    @Provides
    fun provideSharedRepository(dataSource:SharedDataSource):SharedRepository{
        return SharedRepositoryImpl(dataSource)
    }


    @Provides
    fun provicePostLocalUsecase(repository: PostLocalRepository): PostWriteUsecase{
        return PostWriteUsecaseImpl(repository)
    }
    @Provides
    fun providePostListUsecase(repository: PostLocalRepository):PostReadUseCase{
        return PostReadUseCaseImpl(repository)
    }

    @Provides
    fun providePostDeleteUseCae(repository: PostLocalRepository):PostDeleteUseCase{
        return PostDeleteUseCaseImpl(repository)
    }

    @Provides
    fun provideSharedUseCase(repository:SharedRepository): SharedUseCase{
        return SharedUseCaseImpl(repository)
    }
}