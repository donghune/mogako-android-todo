package com.namu.domain.mapper

import com.example.entity.local.LocalDataPostModel
import com.namu.domain.model.DomainPostModel


fun LocalDataPostModel.mapTo(): DomainPostModel {
    return DomainPostModel(
        id = id,
        title = title,
        contents = contents,
        regestDate = regestDate,
        modifyDate = modifyDate,
        author = author,
        readCount = readCount,
        likeCount = likeCount,
        disLikeCount = disLikeCount
    )
}


fun DomainPostModel.mapTo(): LocalDataPostModel {
    return LocalDataPostModel(
        id = id,
        title = title,
        contents = contents,
        regestDate = regestDate,
        modifyDate = modifyDate,
        author = author,
        readCount = readCount,
        likeCount = likeCount,
        disLikeCount = disLikeCount
    )
}
