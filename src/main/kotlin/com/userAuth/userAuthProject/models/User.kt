package com.userAuth.userAuthProject.models


import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "newusers")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val userId:Long?=null,
    @Column(name = "firstName", nullable = false)
    val firstName:String="",
    @Column(name = "lastName", nullable = false)
    val lastName:String="",
    @Column(name = "email", nullable = false)
    val email:String,
    @Column(name = "password", nullable = false)
    val password:String,
//    @CreationTimestamp
//    val createdAt:LocalDateTime? = null,
//    @UpdateTimestamp
//    val updatedAt:LocalDateTime? = null
)