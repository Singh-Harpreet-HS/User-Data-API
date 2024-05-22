package com.userAuth.userAuthProject.repository

import com.userAuth.userAuthProject.dao.UserDao
import com.userAuth.userAuthProject.models.User
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int>{

    @Transactional
    @Modifying
    @Query(value="INSERT INTO newusers(firstName,lastName,email,password) VALUE(:firstName, :lastName, :email, :password)", nativeQuery = true)
    fun registerNewUser(
        @Param("firstName") firstName:String,
        @Param("lastName") lastName:String,
        @Param("email") email:String,
        @Param("password") password:String
        ):Int
}

class MySQLUserDao(private val userRepository: UserRepository): UserDao {
    override fun save(user: com.userAuth.userAuthProject.dao.User): String {
        userRepository.registerNewUser(......)
    }
}
