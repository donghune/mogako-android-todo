package com.namu.data.datasource

import com.namu.data.SharedPreferenceBase
import io.reactivex.Maybe

class SharedDataSourceImpl(
    private val sharedInstance : SharedPreferenceBase
) : SharedDataSource {
    override fun setString(key: String, value: String) {
        sharedInstance.setString(key,value)
    }

    override fun getString(key: String): Maybe<String> {
        return sharedInstance.getString(key)
    }

    override fun setLong(key: String, value: Long) {
        sharedInstance.setLong(key,value)
    }

    override fun getLong(key: String): Maybe<Long> {
        return  sharedInstance.getLong(key)
    }

    override fun setInt(key: String, value: Int) {
        sharedInstance.setInt(key,value)
    }

    override fun getInt(key: String): Maybe<Int> {
        return sharedInstance.getInt(key)
    }

    override fun setBoolean(key: String, value: Boolean) {
        sharedInstance.setBoolean(key,value)
    }

    override fun getBoolean(key: String): Maybe<Boolean> {
        return sharedInstance.getBoolean(key)
    }
}


interface SharedDataSource{
    fun setString(key:String,value:String)
    fun getString(key:String): Maybe<String>

    fun setLong(key:String,value:Long)
    fun getLong(key:String):Maybe<Long>

    fun setInt(key:String,value:Int)
    fun getInt(key:String):Maybe<Int>

    fun setBoolean(key:String,value:Boolean)
    fun getBoolean(key:String):Maybe<Boolean>

}