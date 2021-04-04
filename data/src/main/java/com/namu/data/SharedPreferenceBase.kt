package com.namu.data

import android.content.Context
import android.content.SharedPreferences
import io.reactivex.Maybe

class SharedPreferenceBase(
    private val context: Context?
) {

    var pref: SharedPreferences? = null
        private set
    var editor: SharedPreferences.Editor? = null
        private set

    init {
        context?.let { context ->
            pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
            pref?.let { pref ->
                editor = pref.edit()
            }

        }


    }


    fun clearAllData() {
        editor?.clear()
        editor?.commit()
    }


    fun setString(key: String, value: String) {
        editor?.putString(key, value)
        editor?.commit()
    }

    fun setBoolean(key: String, value: Boolean) {
        editor?.putBoolean(key, value)
        editor?.commit()
    }

    fun setInt(key: String, value: Int) {
        editor?.putInt(key, value)
        editor?.commit()
    }

    fun getString(key: String):Maybe<String> {
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return Maybe.just(pref?.getString(key, null))
    }

    fun getInt(key: String): Maybe<Int>{
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return Maybe.just(pref?.getInt(key,0))
    }

    fun getBoolean(key: String?): Maybe<Boolean> {
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return Maybe.just(pref?.getBoolean(key, false))
    }

    fun setLong(key: String?, value: Long) {
        editor?.putLong(key, value)
        editor?.commit()
    }

    fun getLong(key: String): Maybe<Long> {
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return Maybe.just(pref?.getLong(key,0))
    }


}