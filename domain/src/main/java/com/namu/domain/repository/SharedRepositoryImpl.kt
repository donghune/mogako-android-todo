package com.namu.domain.repository

import com.namu.data.datasource.SharedDataSource
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

interface SharedRepository {
    fun getUserNickName(key: String): Maybe<String>
    fun setUserNickName(key: String, value: String)
}

class SharedRepositoryImpl @Inject constructor(
    private val dataSource: SharedDataSource
) : SharedRepository {
    override fun getUserNickName(key: String): Maybe<String> {
        return dataSource.getString(key)
    }

    override fun setUserNickName(key: String, value: String) {
      return dataSource.setString(key,value)
    }
}