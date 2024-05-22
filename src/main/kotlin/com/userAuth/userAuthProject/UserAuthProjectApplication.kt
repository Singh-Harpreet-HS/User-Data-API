package com.userAuth.userAuthProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.userAuth.userAuthProject.repository"])
class UserAuthProjectApplication

fun main(args: Array<String>) {
	runApplication<UserAuthProjectApplication>(*args)
}
