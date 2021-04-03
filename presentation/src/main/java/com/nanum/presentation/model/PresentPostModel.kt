package com.nanum.presentation.model

data class PresentPostModel(
    val id :Int=0,
    val title:String,
    val contents:String,
    val regestDate:String,
    val modifyDate:String,
    val author :String,
    val readCount :Int=0,
    val likeCount:Int=0,
    val disLikeCount:Int=0
)
