package com.namu.domain.usecase

import com.namu.domain.mapper.mapTo
import com.namu.domain.model.DomainPostModel
import com.namu.domain.repository.PostLocalRepository
import io.reactivex.Single
import javax.inject.Inject

interface PostReadUseCase{
    fun getPostListAll():Single<List<DomainPostModel>>
    fun getPostEach(id:Int):Single<DomainPostModel>
}

class PostReadUseCaseImpl @Inject constructor(
    val local : PostLocalRepository
): PostReadUseCase{
    override fun getPostListAll(): Single<List<DomainPostModel>> {
        return local.getPostListAll()
            .map {
                val result = ArrayList<DomainPostModel>()
                it.map {
                    result.add(it.mapTo())
                }
                result
            }
    }

    override fun getPostEach(id: Int): Single<DomainPostModel> {
        return local.getPostEach(id)
            .map {
                it.mapTo()
            }
    }
}