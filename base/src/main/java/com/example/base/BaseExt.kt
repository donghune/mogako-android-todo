package com.example.base

import android.util.Log
import timber.log.Timber

fun makeLogD(msg: String?) {

    if (BuildConfig.DEBUG) {
        Timber.e(" -----> [${msg}]")
    }
}
