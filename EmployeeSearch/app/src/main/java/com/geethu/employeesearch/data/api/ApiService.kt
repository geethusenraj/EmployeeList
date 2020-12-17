package com.geethu.employeesearch.data.api

import com.geethu.employeesearch.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}