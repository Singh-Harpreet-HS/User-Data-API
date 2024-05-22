package com.userAuth.userAuthProject

import com.userAuth.userAuthProject.dao.UserDao
import com.userAuth.userAuthProject.repository.MongoEntityRepository
import com.userAuth.userAuthProject.repository.MongoUserDao
import com.userAuth.userAuthProject.repository.MySQLUserDao
import com.userAuth.userAuthProject.repository.UserRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.userAuth.userAuthProject.repository"])
class UserAuthProjectApplication

fun main(args: Array<String>) {
	runApplication<UserAuthProjectApplication>(*args)
}

@Configuration
class ApplicationConfiguration {

	@Bean
	@ConditionalOnProperty(name = ["db.type"], havingValue ="SQL" , matchIfMissing = true)
	fun mySqlPeristence(userRepository: UserRepository): UserDao {
		return MySQLUserDao(userRepository)
	}

	@Bean
	@ConditionalOnProperty(name = ["db.type"], havingValue ="MONGO")
	fun mongoPeristence(mongoEntityRepository: MongoEntityRepository): UserDao {
		return MongoUserDao(mongoEntityRepository)
	}
}

