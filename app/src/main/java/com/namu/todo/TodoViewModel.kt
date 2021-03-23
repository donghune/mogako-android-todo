package com.namu.todo

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository): ViewModel() {

    val items: LiveData<List<Todo>> = repository.allTodo.asLiveData()
    val adapter: TodoAdapter = TodoAdapter()

    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }
}

class TodoViewModelFactory(private val repository: TodoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}