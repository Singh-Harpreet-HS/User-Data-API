package com.userAuth.userAuthProject.services

import com.userAuth.userAuthProject.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository:UserRepository

    fun registerNewUserServiceMethod(fname:String, lname:String, email:String, password:String) : Int{
        return userRepository.registerNewUser(fname,lname,email,password)
    }
}

