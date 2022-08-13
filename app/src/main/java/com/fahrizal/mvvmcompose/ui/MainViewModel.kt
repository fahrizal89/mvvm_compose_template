package com.fahrizal.mvvmcompose.ui

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahrizal.mvvmcompose.R
import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.domain.usecase.GetPraySchedules
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val ioCoroutineDispatcher: CoroutineDispatcher,
    private val getPraySchedules: GetPraySchedules
) : ViewModel() {

    private val _uiState = MutableStateFlow<PrayUiState>(PrayUiState.Empty)
    val uiState: StateFlow<PrayUiState> = _uiState

    fun fetchData(city: String) {
        //set loading when fetching data
        _uiState.value = PrayUiState.Loading

        //invoke getPraySchedules use case in the ViewModel scope
        viewModelScope.launch(ioCoroutineDispatcher) {
            getPraySchedules(city)
                .catch { throwable ->
                    //log the error
                    Timber.e(throwable)

                    //show general error to user. User don't need to know exception
                    _uiState.value = PrayUiState.Error(R.string.general_error)
                }
                .collect { prayList ->
                    //expose data to UI
                    _uiState.value = PrayUiState.Loaded(prayList)
                }
        }
    }

    sealed class PrayUiState {
        object Empty : PrayUiState()
        object Loading : PrayUiState()
        class Loaded(val prayList: List<Pray>) : PrayUiState()
        class Error(@StringRes val resId: Int) : PrayUiState()
    }
}