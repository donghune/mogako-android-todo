package com.namu.todo.base

import android.content.Context
import android.content.SharedPreferences

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

    fun getString(key: String, value: String): String? {
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref?.getString(key, value)?:null
    }

    fun getInt(key: String, value: Int): Int?{
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref?.getInt(key, value)
    }

    fun getBoolean(key: String?, value: Boolean): Boolean? {
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref?.getBoolean(key, value)
    }

    fun setLong(key: String?, value: Long) {
        editor?.putLong(key, value)
        editor?.commit()
    }

    fun getLong(key: String, value: Long): Long? {
        pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref?.getLong(key, value)
    }


}