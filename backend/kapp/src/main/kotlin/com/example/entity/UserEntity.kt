package com.example.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class UserEntity(val username:String?, val password:String?,
                      val firstname:String?, val lastname:String?) {
    var id:String?=null
}