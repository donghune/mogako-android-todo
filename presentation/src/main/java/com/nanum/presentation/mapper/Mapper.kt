package com.nanum.presentation.mapper

import com.namu.domain.model.DomainPostModel
import com.nanum.presentation.model.PresentPostModel


fun DomainPostModel.mapTo(): PresentPostModel {
    return PresentPostModel(
        id = id,
        title = title,
        contents = contents,
        registDate = registDate,
        modifyDate = modifyDate,
        author = author,
        readCount = readCount,
        likeCount = likeCount,
        disLikeCount = disLikeCount
    )
}


fun PresentPostModel.mapTo(): DomainPostModel {
    return DomainPostModel(
        id = id,
        title = title,
        contents = contents,
        registDate = registDate,
        modifyDate = modifyDate,
        author = author,
        readCount = readCount,
        likeCount = likeCount,
        disLikeCount = disLikeCount
    )
}
