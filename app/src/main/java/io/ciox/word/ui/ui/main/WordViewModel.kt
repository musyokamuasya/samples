package io.ciox.word.ui.ui.main

import androidx.lifecycle.*
import io.ciox.word.domain.entity.Word
import io.ciox.word.domain.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel (private val repository: WordRepository): ViewModel() {
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insertWord(word: Word) = viewModelScope.launch{
        repository.insertWord(word)
    }
}

class WordViewModelFactory(private val repository: WordRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)){

            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}