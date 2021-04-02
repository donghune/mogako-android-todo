package com.namu.data.datasource

import com.example.entity.local.LocalDataPostModel
import com.namu.data.PostDao
import javax.inject.Inject

interface PostLocalDataSource {
    fun savePost(item: LocalDataPostModel)

}

class PostLocalDataSourceImpl @Inject constructor(
    private val dao: PostDao
) : PostLocalDataSource {
    override fun savePost(item:LocalDataPostModel) {
        return dao.savePost(item)
    }


}