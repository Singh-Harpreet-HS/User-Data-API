package com.userAuth.userAuthProject.models

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "users")
data class MongoUser(
    @Id
    val userId:Long?=null,
    val firstName:String="",
    val lastName:String="",
    val email:String,
    val password:String,
//    val createdAt: LocalDateTime? = null,
//    val updatedAt: LocalDateTime? = null
)