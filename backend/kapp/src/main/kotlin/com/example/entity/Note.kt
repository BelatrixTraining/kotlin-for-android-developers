package com.example.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "notes")
data class Note(val id:String?,val name:String?,val description:String?,val path:String?,
                val userId:String?)