package com.namu.domain.repository

import com.namu.domain.mapper.mapTo
import com.namu.domain.model.DomainPostModel
import io.reactivex.Single
import javax.inject.Inject

class PostDeleteUseCaseImpl @Inject constructor(
    private val repository: PostLocalRepository
) : PostDeleteUseCase {
    override fun deletePostEach(item: DomainPostModel): Single<Int> {
        return repository.deletePostEach(item.mapTo())
    }
}


interface PostDeleteUseCase {
    fun deletePostEach(item: DomainPostModel): Single<Int>
}