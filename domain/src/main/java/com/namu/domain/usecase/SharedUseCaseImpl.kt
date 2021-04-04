package com.namu.domain.usecase

import com.namu.domain.repository.SharedRepository
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class SharedUseCaseImpl @Inject constructor(
    private val repo : SharedRepository
) : SharedUseCase{
    override fun setUserNickName(key: String, value: String) {
        return repo.setUserNickName(key,value)
    }

    override fun getUserNickName(key: String): Maybe<String> {
        return repo.getUserNickName(key)
    }
}


interface SharedUseCase{

    fun setUserNickName(key:String,value:String)
    fun getUserNickName(key:String):Maybe<String>
}
