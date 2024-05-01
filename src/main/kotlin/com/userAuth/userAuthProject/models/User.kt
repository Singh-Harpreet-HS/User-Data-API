package com.userAuth.userAuthProject.models


import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User (
    @Id
    val userId:Long?=null,
    val firstName:String,
    val lastName:String,
    val email:String,
    val password:String,
    val createdAt:LocalDateTime? = null,
    val updatedAt:LocalDateTime? = null

)