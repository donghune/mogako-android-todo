package com.namu.domain

import com.example.entity.local.LocalDataPostModel
import com.namu.domain.repository.PostLocalRepository
import javax.inject.Inject


interface PostWriteUsecase {
    fun savePost(item: LocalDataPostModel)
    fun getPostEach()
    fun getPostListAll()
}

class PostWriteUsecaseImpl @Inject constructor(
    private val localRepo : PostLocalRepository
)  : PostWriteUsecase{
    override fun savePost(item:LocalDataPostModel) {
        localRepo.savePost(item)
    }

    override fun getPostEach() {
        TODO("Not yet implemented")
    }

    override fun getPostListAll() {
        TODO("Not yet implemented")
    }
}