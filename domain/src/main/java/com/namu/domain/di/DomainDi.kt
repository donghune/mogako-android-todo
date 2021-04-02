package com.namu.domain.di

import com.namu.data.datasource.PostLocalDataSource
import com.namu.domain.PostWriteUsecase
import com.namu.domain.PostWriteUsecaseImpl
import com.namu.domain.repository.PostLocalRepository
import com.namu.domain.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainDi {

    @Provides
    @Reusable
    fun provicePostLocalRepository(datasource:PostLocalDataSource):PostLocalRepository{
        return PostRepositoryImpl(datasource)
    }


    @Provides
    @Reusable
    fun provicePostLocalUsecase(repository: PostLocalRepository): PostWriteUsecase{
        return PostWriteUsecaseImpl(repository)
    }
}