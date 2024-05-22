package com.userAuth.userAuthProject.repository

import com.userAuth.userAuthProject.dao.UserDao
import com.userAuth.userAuthProject.models.MongoUser
import com.userAuth.userAuthProject.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoEntityRepository: MongoRepository<MongoUser,String> {
    fun findByEmail(email: String): MongoUser?
}

class MongoUserDao(private val mongoEntityRepository: MongoEntityRepository): UserDao {

    override fun save(user: com.userAuth.userAuthProject.dao.User): String {

        val mongoUser = MongoUser(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            password = user.password,
        )
        mongoEntityRepository.save(mongoUser)

        return "Success"
    }
}
