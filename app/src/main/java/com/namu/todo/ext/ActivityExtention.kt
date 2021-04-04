package com.namu.todo.ext

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.namu.todo.BuildConfig
import com.namu.todo.R


fun Context.showToast(msg: Any?) {
    var stringData: String? = null
    msg?.let {
        when (msg) {
            is String -> {
                stringData = msg
            }
            is Int -> {
                stringData = this.resources.getString(msg)
            }
            else -> {
                throw Exception("Need to Type ( Int Or String)")
            }
        }
    }

    stringData?.let {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}


fun Any.makeLog(tag: String?, msg: String) {
    if (BuildConfig.DEBUG) {
        Log.e(tag, msg)
    }
}

fun Fragment.findNavController(): NavController {
    return NavHostFragment.findNavController(this)
}

