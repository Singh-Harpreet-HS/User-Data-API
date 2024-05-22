package com.userAuth.userAuthProject.dao

interface UserDao {

    fun save(user: User) : String
}

data class User(val firstName:String,
                val lastName:String,
                val email:String,
                val password:String)
