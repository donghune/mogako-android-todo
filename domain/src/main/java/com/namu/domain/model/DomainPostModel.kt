package com.namu.domain.model

data class DomainPostModel(
    val id :Int,
    val title:String,
    val contents:String,
    val regestDate:String,
    val modifyDate:String,
    val author :String,
    val readCount :Int,
    val likeCount:Int,
    val disLikeCount:Int
)
