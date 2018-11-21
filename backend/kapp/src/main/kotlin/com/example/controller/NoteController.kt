package com.example.controller

import com.example.repository.NoteRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class NoteController(private val repository: NoteRepository){

    @GetMapping("/api/notes")
    fun findAll() = repository.findAll()

    @GetMapping("/api/notes/{name}")
    fun findByLastName(@PathVariable name:String)
            = repository.findByName(name)
}