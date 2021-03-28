package com.namu.todo

import com.example.base.BaseFragment
import com.namu.todo.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {
    override fun bindView() {

    }

    override fun setObserver() {
    }

    override fun initData() {
        setListener()
    }


    fun setListener(){
        binding.btnNextpage.setOnClickListener{
            activity?.let {
                ( it as MainActivity).moveFragment(R.id.action_to_input)
            }
        }
    }
}