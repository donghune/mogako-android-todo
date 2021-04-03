package com.nanum.presentation.model

data class PresentPostModel(
    val id: Int = 0,
    val title: String,
    val contents: String,
    val regestDate: String,
    val modifyDate: String,
    val author: String,
    val readCount: Int = 0,
    val likeCount: Int = 0,
    val disLikeCount: Int = 0
) {

    fun compareDateRegistedOrModify(): String {
        if (modifyDate.isNotEmpty() && regestDate.isNotEmpty()) {
            if (regestDate.compareTo(modifyDate) > 0)
                return regestDate

            return modifyDate
        }

        if (modifyDate.isNotEmpty())
            return modifyDate

        if (regestDate.isNotEmpty())
            return regestDate

        return "날짜 미 지정"
    }
}
