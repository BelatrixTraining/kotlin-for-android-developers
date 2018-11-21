package com.example.repository

import com.example.entity.Note
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository:MongoRepository<Note,String> {

    fun findByName(name:String?): List<Note>
}