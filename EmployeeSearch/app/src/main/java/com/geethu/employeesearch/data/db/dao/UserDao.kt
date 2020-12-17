package com.geethu.employeesearch.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geethu.employeesearch.data.db.entities.UserEntity


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: UserEntity)

    @Query("SELECT COUNT(*) FROM UserTable")
    suspend fun getRowCount(): Long
}