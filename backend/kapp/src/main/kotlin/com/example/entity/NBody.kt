package com.example.entity

import com.fasterxml.jackson.annotation.JsonCreator

data class UserBody @JsonCreator constructor(val username:String?, val password:String?,
                                             val firstname:String?, val lastname:String?)