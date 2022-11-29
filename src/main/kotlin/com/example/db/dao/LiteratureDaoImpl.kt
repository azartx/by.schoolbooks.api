package com.example.db.dao

import com.example.model.Literature
import com.example.db.DatabaseFactory.dbQuery
import com.example.db.LiteratureTable
import com.example.db.toLiterature
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class LiteratureDaoImpl : LiteratureDao {
    override suspend fun getAllLiterature(): List<Literature> {
        return dbQuery { LiteratureTable.selectAll().map(::toLiterature) }
    }

    override suspend fun getLiteratureBySubjectId(subjectId: Int): List<Literature> {
        return dbQuery { LiteratureTable.select { LiteratureTable.forSubjectId eq subjectId }.map(::toLiterature) }
    }

    override suspend fun getLiteratureBySubjectAndClass(subjectId: Int, classNumber: Int): List<Literature> {
        return dbQuery {
            LiteratureTable
                .select { (LiteratureTable.forSubjectId eq subjectId) and (LiteratureTable.litClass eq classNumber) }
                .map(::toLiterature)
        }
    }

    override suspend fun getSingleBookById(id: Int): Literature {
        return dbQuery { toLiterature(LiteratureTable.select(LiteratureTable.litId.eq(id)).first()) }
    }
}
