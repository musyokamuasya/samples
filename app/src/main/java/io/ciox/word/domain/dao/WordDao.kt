package io.ciox.word.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.ciox.word.domain.entity.Word
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {
//    Add word to db, query words in db, delete words from db

    @Query("SELECT * FROM word_database ORDER BY word ASC")
    suspend fun getAlphabetizedWords() : Flow<List<Word>>

    @Query("DELETE FROM word_database ")
    suspend fun deleteWord(word: Word)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWord(word: Word)
}