package com.namu.todo

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class AddTodoViewModel(private val repository: TodoRepository): ViewModel() {


    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }
}

class AddTodoViewModelFactory(private val repository: TodoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddTodoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddTodoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}