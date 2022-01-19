package io.ciox.word.domain.repository

import androidx.annotation.WorkerThread
import io.ciox.word.domain.dao.WordDao
import io.ciox.word.domain.entities.Word
import kotlinx.coroutines.flow.Flow

class WordRepository (private val wordDao: WordDao) {
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insertWord(word: Word){
        wordDao.addWord(word)
    }
}