package com.namu.data.datasource

import com.example.entity.local.LocalDataPostModel
import com.namu.data.dao.PostDao
import io.reactivex.Single
import javax.inject.Inject

interface PostLocalDataSource {
    fun savePost(item: LocalDataPostModel):Single<Int>
    fun getPostEach(id: Int):  Single<LocalDataPostModel>
    fun getPostListAll(): Single<List<LocalDataPostModel>>
}

class PostLocalDataSourceImpl @Inject constructor(
    private val dao: PostDao
) : PostLocalDataSource {
    override fun savePost(item:LocalDataPostModel):Single<Int> {
        return dao.savePost(item)
    }

    override fun getPostEach(id: Int): Single<LocalDataPostModel> {
       return dao.getPostEach(id)
    }

    override fun getPostListAll(): Single<List<LocalDataPostModel>> {
        return dao.getPostListAll()
    }


}