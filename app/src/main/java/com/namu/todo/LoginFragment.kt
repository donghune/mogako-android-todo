package com.namu.todo

import androidx.fragment.app.viewModels
import com.namu.todo.base.BaseFragment
import com.namu.todo.databinding.FragmentLoginBinding
import com.namu.todo.observer.LoginObservers
import com.nanum.presentation.LoginViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    val loginViewModel: LoginViewModelImpl by viewModels()
    private val observers: LoginObservers by lazy {
        LoginObservers(
            context,
            binding
        )
    }

    override fun bindView() {
        binding.viewmodel = loginViewModel
    }

    override fun setObserver() {
        loginViewModel.loginLivedatas.loginResult.observe(
            viewLifecycleOwner,
            observers.loginResult(this)
        )


    }

    override fun initData() {
    }


}