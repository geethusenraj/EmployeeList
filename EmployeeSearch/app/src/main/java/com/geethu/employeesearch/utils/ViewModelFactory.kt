package com.geethu.employeesearch.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geethu.employeesearch.data.api.ApiHelper
import com.geethu.employeesearch.data.repository.MainRepository
import com.geethu.employeesearch.ui.screens.employeeList.EmployeeListViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmployeeListViewModel::class.java)) {
            return EmployeeListViewModel(MainRepository(apiHelper, application)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

