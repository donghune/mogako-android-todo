package com.namu.todo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.namu.todo.R
import com.namu.todo.base.BaseActivity
import com.namu.todo.databinding.ActivityMainBinding
import com.nanum.presentation.HomeViewModelImpl
import com.nanum.presentation.ToolbarViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    val toolbarViewModel: ToolbarViewModelImpl by viewModels()
    val homeViewModelImpl: HomeViewModelImpl by viewModels()


    val nickNameialog : DialogInputName by lazy {
        val callback = object : ResultInputNickName{
            override fun onResult(value: String?) {
                homeViewModelImpl.setUserNickName(value)
            }
        }
        DialogInputName.newInstance(callback)
    }
    private val appBarConfiguration = AppBarConfiguration(
        setOf(
            R.id.navigation_read, R.id.navigation_postWrite
        )
    )

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setupActionBarWithNavController(navController,appBarConfiguration)

        binding.navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment_container).navigateUp(appBarConfiguration)
    }

    override fun viewBind() {
        binding.toolbarVm = toolbarViewModel
        binding.lifecycleOwner = this
    }

    override fun onResume() {
        super.onResume()
    }

    override fun setObserver() {
        homeViewModelImpl.userNickName.observe(this, Observer {
            checkNickName()
        })
        toolbarViewModel.livedatas.clickBackBtn.observe(this, Observer {
            onBackPressed()
        })
    }

    override fun initData() {

    }


    override fun onBackPressed() {
        super.onBackPressed()

    }

    fun checkNickName() {

        homeViewModelImpl.userNickName.value?.let {
            if (it.isEmpty()) {
                showNickNameDialog()
            }
        } ?: kotlin.run {
            showNickNameDialog()
        }
    }

    fun showNickNameDialog(){
        nickNameialog.show(supportFragmentManager,nickNameialog.javaClass.simpleName)
    }

    companion object {
        fun startActivitiy(context: Context) {
            Intent(context, MainActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }
}