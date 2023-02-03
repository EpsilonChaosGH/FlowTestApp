package com.example.flowtestapp.app.screens.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowtestapp.core_data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(0)
    val state: StateFlow<Int> = _state

    init {
        listenCurrentNumber()
    }

    private fun listenCurrentNumber() {
        viewModelScope.launch {
            repository.listenCurrentNumber().collect { number ->
                _state.value = number?.number ?: 0
            }
        }
    }

    fun getRandomNumber() {
        viewModelScope.launch {
            repository.getRandomNumber()
        }
    }
}