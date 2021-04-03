package com.namu.domain.repository

import com.example.entity.local.LocalDataPostModel
import com.namu.data.datasource.PostLocalDataSource
import com.namu.domain.mapper.mapTo
import com.namu.domain.model.DomainPostModel
import io.reactivex.Single
import javax.inject.Inject


interface PostLocalRepository{
    fun savePost(item: DomainPostModel):Single<Long>
    fun getPostEach(id: Int):  Single<LocalDataPostModel>
    fun getPostListAll(): Single<List<LocalDataPostModel>>
}

class PostRepositoryImpl @Inject constructor(
    private val localDataSource : PostLocalDataSource
) :PostLocalRepository{
    override fun savePost(item:DomainPostModel):Single<Long> {
        return Single.just(item)
                .map {
                    it.mapTo()
                }
                .flatMap {
                    localDataSource.savePost(it)
                }


    }

    override fun getPostEach(id: Int):Single<LocalDataPostModel> {
        return localDataSource.getPostEach(id)
    }

    override fun getPostListAll(): Single<List<LocalDataPostModel>> {
        return localDataSource.getPostListAll()
    }


}