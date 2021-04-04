package com.namu.data.datasource

import com.example.entity.local.LocalDataPostModel
import com.namu.data.dao.PostDao
import io.reactivex.Single
import javax.inject.Inject

interface PostLocalDataSource {
    fun savePost(item: LocalDataPostModel):Single<Long>
    fun getPostEach(id: Int):  Single<LocalDataPostModel>
    fun getPostListAll(): Single<List<LocalDataPostModel>>
    fun deletePostEach(item:LocalDataPostModel):Single<Int>
}

class PostLocalDataSourceImpl @Inject constructor(
    private val dao: PostDao
) : PostLocalDataSource {
    override fun savePost(item:LocalDataPostModel):Single<Long> {
        return dao.savePost(item)
    }

    override fun getPostEach(id: Int): Single<LocalDataPostModel> {
       return dao.getPostEach(id)
    }

    override fun getPostListAll(): Single<List<LocalDataPostModel>> {
        return dao.getPostListAll()
    }

    override fun deletePostEach(item: LocalDataPostModel): Single<Int> {
        return dao.deletePostEach(item)
    }


}