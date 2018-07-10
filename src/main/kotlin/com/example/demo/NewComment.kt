package com.example.demo

import com.fasterxml.jackson.annotation.JsonCreator

data class NewComment @JsonCreator constructor(
            val author: String,
            val content: String
    )