package com.example.flowtestapp.app.screens.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowtestapp.core_data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(0)
    val state: StateFlow<Int> = _state.asStateFlow()

    init {
        listenCurrentNumber()
    }

    private fun listenCurrentNumber() {
        viewModelScope.launch {
            repository.listenCurrentNumber().collect { number ->
                val list = number?.testValueList
                _state.value = list?.get(0)?.value1 ?: 1111
            }
        }
    }

    fun getRandomNumber() {
        viewModelScope.launch {
            repository.getRandomNumber()
        }
    }
}