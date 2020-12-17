package com.geethu.employeesearch.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geethu.employeesearch.data.db.dao.UserDao
import com.geethu.employeesearch.data.db.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        @Volatile
        private var instance: AppDataBase? = null
        private val LOCK = Any()

        fun getDatabase(context: Context): AppDataBase {
            if (instance != null) {
                return instance!!
            }
            synchronized(LOCK) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
            return instance!!

        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "EmployeeDatabase.db"
            ).build()
    }
}

