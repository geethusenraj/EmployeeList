package com.geethu.employeesearch.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.geethu.employeesearch.model.User


@Entity(
    tableName = "UserTable",
    primaryKeys = ["ID"]
)
class UserEntity {
    constructor(user: User) : this() {
        this.id = user.id.toLong()
        this.name = user.name
        this.username = user.username
        this.email = user.email
        this.profileImage = user.profile_image
        this.phone = user.phone
        this.website = user.website

    }

    constructor()

    @ColumnInfo(name = "ID")
    var id: Long = 0
    var name: String? = null
    var username: String? = null
    var email: String? = null
    var profileImage: String? = null
    var phone: String? = null
    var website: String? = null

}