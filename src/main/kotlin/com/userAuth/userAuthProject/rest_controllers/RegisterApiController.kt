package com.userAuth.userAuthProject.rest_controllers

import com.userAuth.userAuthProject.services.UserService
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class RegisterApiController(private val userService: UserService) {

    @PostMapping("/user/register")
    fun registerUser(
        @RequestBody registerUserRequest: RegisterUserRequest
    ):ResponseEntity<Map<String, String>> {

        if(registerUserRequest.firstName.isEmpty() || registerUserRequest.lastName.isEmpty() || registerUserRequest.email.isEmpty() || registerUserRequest.password.isEmpty()){
            return ResponseEntity.badRequest().body(
                mapOf("message" to "Please complete all fields")
            )
        }

        val hashedPassword:String=BCrypt.hashpw(registerUserRequest.password, BCrypt.gensalt())

        //Register New User

        val result=userService.registerNewUserServiceMethod(registerUserRequest.firstName,registerUserRequest.lastName, registerUserRequest.email,hashedPassword)

        val message = if (result == 1) {
            "Successfully Registered"
        } else {
            "Failed to Register"
        }

        return ResponseEntity.ok(mapOf("message" to message))
    }
}

data class RegisterUserRequest (
    val firstName:String,
    val lastName:String,
    val email:String,
    val password:String,
)

