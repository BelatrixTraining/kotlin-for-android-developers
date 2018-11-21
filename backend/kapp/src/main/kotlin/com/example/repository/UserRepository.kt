package com.example.repository

import com.example.entity.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<UserEntity, String> {

    fun findByUsername(username:String?): List<UserEntity>
}