package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Literature(
    val litId: Int,
    val forSubjectId: Int,
    val litName: String,
    val litAuthor: String,
    val litDescription: String,
    val litClass: Int,
    val litUrl: String,
    val litImageUrl: String
)
