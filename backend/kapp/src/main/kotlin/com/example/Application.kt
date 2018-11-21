package com.example

import com.example.repository.NoteRepository
import com.example.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {

    companion object {

        /*@Bean
        fun init(repository: NoteRepository)=CommandLineRunner{
            val notes= repository.findAll()
            notes?.forEach {
                println("item $it")
            }
        }*/

        /*@Bean
        fun init(userRepository: UserRepository)=CommandLineRunner{
            val users= userRepository.findAll()
            users?.forEach {
                println("item $it")
            }
        }*/

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }



}