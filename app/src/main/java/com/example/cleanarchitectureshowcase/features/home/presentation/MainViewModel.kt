package com.example.cleanarchitectureshowcase.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureshowcase.features.home.domain.GetMockDataUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMockDataUsecase: GetMockDataUsecase
): ViewModel() {

    private val _state = MutableStateFlow<List<DataUI>?>(null)
    val state = _state

    fun someProccess() {
        viewModelScope.launch {
            val result = getMockDataUsecase.invoke("Params")
            state.value = result
        }
    }
}