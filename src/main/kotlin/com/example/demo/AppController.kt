package com.example.demo

import org.springframework.web.bind.annotation.*
import java.time.Instant

@CrossOrigin
    @RestController
    class AppController {

        @GetMapping("/")
        fun index() = "This is home!"
        @GetMapping("/comment")
        fun getComment() : Comment {
            val comment = Comment(
                    author = "codebeast",
                    content = "I'm so loving Kotlin",
                    created = Instant.now()
            )
            return comment
        }
//    @RequestMapping(value = "/comment", method = arrayOf(RequestMethod.POST))
    @PostMapping
    fun createUser(@RequestBody newComment: NewComment): Comment {
        val comment = Comment(
                author = newComment.author,
                content = newComment.content,
                created = Instant.now()
        )
        return comment
    }
    }