package com.nanum.presentation

interface InputTextChaneListener {
    fun onChange(type:ChangeType,data:String)
}

enum class ChangeType{
    POST_WRITE_TITLE,POST_WRITE_CONTENTS;
}