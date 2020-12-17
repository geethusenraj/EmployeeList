package com.geethu.employeesearch.ui.screens.employeeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.geethu.employeesearch.data.repository.MainRepository
import com.geethu.employeesearch.model.User
import com.geethu.employeesearch.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EmployeeListViewModel(private val mainRepository: MainRepository) :
    ViewModel() {


    fun getUsers() =
//        if (!checkDataAvailInDb())
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = mainRepository.getUsers()))
            } catch (exception: Exception) {
                emit(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!"
                    )
                )
            }
        }
//        else

//    private fun checkDataAvailInDb(): Any {
//        viewModelScope.launch(Dispatchers.IO) {
//            mainRepository.getUserCount()
//        }
//    }

    fun updateDataToDb(users: List<User>) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.saveUserData(users)
        }
    }
}