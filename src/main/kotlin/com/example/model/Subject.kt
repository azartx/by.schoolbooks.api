package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Subject(
    val subjectId: String,
    val subjectName: String
)
