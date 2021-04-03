package com.namu.domain

import com.namu.domain.mapper.mapTo
import com.namu.domain.model.DomainPostModel
import com.namu.domain.repository.PostLocalRepository
import io.reactivex.Single
import javax.inject.Inject


interface PostWriteUsecase {
    fun savePost(item: DomainPostModel): Single<Long>
    fun getPostEach(id: Int): Single<DomainPostModel>
    fun getPostListAll(): Single<List<DomainPostModel>>
}

class PostWriteUsecaseImpl @Inject constructor(
        private val localRepo: PostLocalRepository
) : PostWriteUsecase {
    override fun savePost(item: DomainPostModel): Single<Long> {
        return localRepo.savePost(item)

    }


    override fun getPostEach(id: Int): Single<DomainPostModel> {
        return localRepo.getPostEach(id)
                .map {
                    it.mapTo()
                }
    }

    override fun getPostListAll(): Single<List<DomainPostModel>> {
        return localRepo.getPostListAll()
                .map {
                    ArrayList<DomainPostModel>().apply {
                        it.map {
                            this.add(it.mapTo())
                        }
                    }.also {
                        (this as List<DomainPostModel>)
                    }
                }
    }


}