package com.nanum.presentation.mapper

import com.namu.domain.model.DomainPostModel
import com.nanum.presentation.model.PresentPostModel

object Mapper {


    fun mapTo(item: DomainPostModel): PresentPostModel {
        return PresentPostModel(
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

    fun mapToList(items : List<DomainPostModel>):ArrayList<PresentPostModel>{
       return ArrayList<PresentPostModel>().apply {
            items.map {
                this.add(Mapper.mapTo(it))
            }
        }
    }

    fun mapTo(item: PresentPostModel): DomainPostModel {
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