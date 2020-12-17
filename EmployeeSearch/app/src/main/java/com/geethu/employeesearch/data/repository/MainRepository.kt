package com.geethu.employeesearch.data.repository

import android.app.Application
import com.geethu.employeesearch.data.api.ApiHelper
import com.geethu.employeesearch.data.db.AppDataBase
import com.geethu.employeesearch.data.db.entities.UserEntity
import com.geethu.employeesearch.model.User

class MainRepository(private val apiHelper: ApiHelper, application: Application) {
    private val userDao = AppDataBase.getDatabase(application).getUserDao()
    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun saveUserData(users: List<User>) {
        users.map { it ->
            userDao.insertAll(UserEntity(it))
        }
    }

    suspend fun getUserCount(): Long {
        return userDao.getRowCount()
    }
}