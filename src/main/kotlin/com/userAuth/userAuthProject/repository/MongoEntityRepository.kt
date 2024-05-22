package com.userAuth.userAuthProject.repository

import com.userAuth.userAuthProject.models.MongoUser
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoEntityRepository: MongoRepository<MongoUser,String> {
    fun findByEmail(email: String): MongoUser?
}