package com.namu.todo.observer

import android.content.Context
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import com.namu.todo.R
import com.namu.todo.base.BaseObserverCollections
import com.namu.todo.databinding.FragmentLoginBinding
import com.namu.todo.ext.findNavController

class LoginObservers(
    private val context: Context?,
    private val binding: ViewDataBinding
) : BaseObserverCollections<FragmentLoginBinding>(context, binding) {

    val loginResult = fun(fragment: Fragment): Observer<Boolean> {
       return Observer<Boolean> {
            fragment.findNavController().navigate(R.id.action_to_PostWrite)
        }
    }


}