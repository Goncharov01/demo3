package com.example.demo
import java.time.Instant
data class Comment(
            val author: String,
            val content: String,
            val created: Instant
    )