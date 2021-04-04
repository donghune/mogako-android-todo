package com.nanum.presentation.model

data class PresentPostModel(
    val id: Int = 0,
    val title: String,
    val contents: String,
    val registDate: String,
    val modifyDate: String,
    var author: String,
    val readCount: Int = 0,
    val likeCount: Int = 0,
    val disLikeCount: Int = 0
) {

    fun compareDateRegistedOrModify(): String {
        if (modifyDate.isNotEmpty() && registDate.isNotEmpty()) {
            if (registDate > modifyDate)
                return registDate

            return modifyDate
        }

        if (modifyDate.isNotEmpty())
            return modifyDate

        if (registDate.isNotEmpty())
            return registDate

        return "날짜 미 지정"
    }
}
