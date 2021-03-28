package com.namu.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.namu.todo.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.navigation_login
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun viewBind() {
        binding.lifecycleOwner = this
    }

    override fun setObserver() {
    }

    override fun initData() {
    }


    fun moveFragment(actionId:Int){
        navController.navigate(actionId)
    }

    companion object {
        fun startActivitiy(context: Context) {
            Intent(context, MainActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }
}