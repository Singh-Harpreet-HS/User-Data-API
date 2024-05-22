package com.userAuth.userAuthProject.services

import com.userAuth.userAuthProject.dao.User
import com.userAuth.userAuthProject.dao.UserDao
import com.userAuth.userAuthProject.models.MongoUser
import com.userAuth.userAuthProject.repository.MongoEntityRepository
import com.userAuth.userAuthProject.repository.MongoUserDao
import com.userAuth.userAuthProject.repository.MySQLUserDao
import com.userAuth.userAuthProject.repository.UserRepository
import com.userAuth.userAuthProject.rest_controllers.RegisterApiController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

//

@Service
class UserService(@Value("\${db.type}") private val dbType: String, private val sqlUserDao: MySQLUserDao,private val mongouserDao: MongoUserDao
) {


    fun registerNewUserServiceMethod(
        fname:String,
        lname:String,
        email:String,
        password:String
    ) : Int{
        // Save user to SQL

        if(dbType == "SQL") {

            val sqlUser = User(
                firstName = fname,
                lastName = lname,
                email = email,
                password = password,
            )

            sqlUserDao.save(sqlUser)

        }else {

            val mongodbUser = User(
                firstName = fname,
                lastName = lname,
                email = email,
                password = password,
            )
            mongouserDao.save(mongodbUser)
        }

        return 1
    }
}

//@Service
//class UserService(@Value("\${db.type}") private val dbType: String,
//                  private val userRepository:UserRepository,
//                  private val mongoUserRepository: MongoEntityRepository
//) {
//
//    fun registerUser(registerUserRequest: RegisterApiController.RegisterUserRequest) {
//
//    }
//
//    fun registerNewUserServiceMethod(
//        fname:String,
//        lname:String,
//        email:String,
//        password:String
//    ) : Int{
//        // Save user to SQL
//
//        if(dbType == "SQL") {
//
//            val sqlUser = User(
//                firstName = fname,
//                lastName = lname,
//                email = email,
//                password = password,
//            )
//            userRepository.save(sqlUser)
//        } else if( dbType == "POSTGRESQL") {
//
//        }
//        else {
//
//            // Save user to MongoDB
//            val mongoUser = MongoUser(
//                firstName = fname,
//                lastName = lname,
//                email = email,
//                password = password,
//            )
//            mongoUserRepository.save(mongoUser)
//        }
//        return 1
//    }
//}

