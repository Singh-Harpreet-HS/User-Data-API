package com.userAuth.userAuthProject.rest_controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserApiController {

    @GetMapping("/test")
    fun testEndPoint(): String {
        return "Test End Point is Working"
    }
}