package io.ciox.word.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_database")
data class Word(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "word") val word: String
)
