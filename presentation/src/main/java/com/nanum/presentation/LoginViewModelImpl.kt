package com.nanum.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.nanum.presentation.base.BaseViewModel
import com.nanum.presentation.base.SingleLiveEvent

interface LoginViewModel{
    fun clickLoginBtn()
    fun setLoginResult(state:Boolean)
}

class LoginViewModelImpl @ViewModelInject constructor() :BaseViewModel(),LoginViewModel{

    val loginLivedatas :LoginLiveDataCollection by lazy {
        LoginLiveDataCollection()
    }

    override fun clickLoginBtn() {
        setLoginResult(true)
    }

    override fun setLoginResult(state: Boolean) {
        loginLivedatas.setLoginResult(state)
    }

}



class LoginLiveDataCollection {

    private val _loginResult = SingleLiveEvent<Boolean>()
    val loginResult : LiveData<Boolean>
    get() = _loginResult


    fun setLoginResult(state:Boolean){
        _loginResult.value=state
    }
}