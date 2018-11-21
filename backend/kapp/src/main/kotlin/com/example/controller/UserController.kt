package com.example.controller

import com.example.entity.UserBody
import com.example.entity.UserEntity
import com.example.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class UserController(){

    @Autowired
    @Qualifier("userRepository")
    private lateinit var userRepository: UserRepository

    @GetMapping("/api/users")
    fun findAll() = userRepository.findAll()

    @GetMapping("/api/users/{username}")
    fun findByLastName(@PathVariable username:String)
            = userRepository.findByUsername(username)

    @RequestMapping(value = "/api/user", method = arrayOf(RequestMethod.POST))
    fun createUser(@Valid @RequestBody userBody:UserBody): UserEntity {

        val userEntity= UserEntity(
                username = userBody.username,
                password = userBody.password,
                firstname = userBody.firstname,
                lastname = userBody.lastname)
        userRepository.save(userEntity)

        return userEntity
    }
    /*
    (val id:String?,val username:String?,val password:String?,
                val firstname:String?,val lastname:String?
     */
}