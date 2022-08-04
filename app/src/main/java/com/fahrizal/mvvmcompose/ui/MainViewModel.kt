package com.fahrizal.mvvmcompose.ui

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahrizal.mvvmcompose.ui.dispatcher.CoroutineDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<PrayUiState>(PrayUiState.Empty)
    val uiState: StateFlow<PrayUiState> = _uiState

    init {
        viewModelScope.launch(coroutineDispatcherProvider.io) {

        }
    }

    sealed class PrayUiState {
        object Empty : PrayUiState()
        object Loading : PrayUiState()
        class Error(@StringRes val resId: Int) : PrayUiState()
    }
}