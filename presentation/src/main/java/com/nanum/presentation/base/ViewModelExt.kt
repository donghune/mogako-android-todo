package com.nanum.presentation.base

import androidx.lifecycle.ViewModel


fun ViewModel.isNotOrEmpty(vararg items:String?){

    items.forEach {
        if(items.isNullOrEmpty()){
            throw Exception("Check For value!!")
        }
    }
}