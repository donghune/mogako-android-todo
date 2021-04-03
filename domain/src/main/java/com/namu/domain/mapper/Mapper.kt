package com.namu.domain.mapper

import com.example.entity.local.LocalDataPostModel
import com.namu.domain.model.DomainPostModel

object Mapper {


    fun mapTo(item: LocalDataPostModel): DomainPostModel {
        return DomainPostModel(
                id = item.id,
                title = item.title,
                contents = item.contents,
                regestDate = item.regestDate,
                modifyDate = item.modifyDate,
                author = item.author,
                readCount = item.readCount,
                likeCount = item.likeCount,
                disLikeCount = item.disLikeCount
        )
    }
}