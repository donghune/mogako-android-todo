package com.namu.domain.repository

import com.example.entity.local.LocalDataPostModel
import com.namu.data.datasource.PostLocalDataSource
import javax.inject.Inject


interface PostLocalRepository{
    fun savePost(item: LocalDataPostModel)

}

class PostRepositoryImpl @Inject constructor(
    private val localDataSource : PostLocalDataSource
) :PostLocalRepository{
    override fun savePost(item:LocalDataPostModel) {
        return localDataSource.savePost(item)
    }


}