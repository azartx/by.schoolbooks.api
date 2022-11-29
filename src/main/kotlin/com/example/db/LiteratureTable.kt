package com.example.db

import com.example.model.Literature
import com.example.db.dao.LiteratureDaoImpl
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object LiteratureTable : Table() {
    val litId = integer("id").autoIncrement()
    val forSubjectId = integer("subjectid")
    val litName = varchar("name", 128)
    val litAuthor = varchar("author", 64)
    val litDescription = varchar("description", 512)
    val litClass = integer("class")
    val litUrl = varchar("url", 128)
    val litImageUrl = varchar("imgurl", 128)

    val dao = LiteratureDaoImpl()
    override val primaryKey = PrimaryKey(litId)
}

fun toLiterature(row: ResultRow) = Literature(
    litId = row[LiteratureTable.litId],
    forSubjectId = row[LiteratureTable.forSubjectId],
    litName = row[LiteratureTable.litName],
    litAuthor = row[LiteratureTable.litAuthor],
    litDescription = row[LiteratureTable.litDescription],
    litClass = row[LiteratureTable.litClass],
    litUrl = row[LiteratureTable.litUrl],
    litImageUrl = row[LiteratureTable.litImageUrl]
)
