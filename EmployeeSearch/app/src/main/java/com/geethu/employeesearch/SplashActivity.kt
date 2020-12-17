package com.geethu.employeesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geethu.employeesearch.ui.screens.EmployeeListActivity
import com.geethu.employeesearch.utils.openActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openActivity(EmployeeListActivity::class.java);
    }
}