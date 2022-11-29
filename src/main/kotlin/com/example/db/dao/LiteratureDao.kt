package com.example.db.dao

import com.example.model.Literature

interface LiteratureDao {
    suspend fun getAllLiterature(): List<Literature>
    suspend fun getLiteratureBySubjectId(subjectId: Int): List<Literature>
    suspend fun getLiteratureBySubjectAndClass(subjectId: Int, classNumber: Int): List<Literature>
    suspend fun getSingleBookById(id: Int): Literature
}
