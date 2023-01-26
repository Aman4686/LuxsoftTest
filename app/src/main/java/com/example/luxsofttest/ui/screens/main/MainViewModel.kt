package com.example.luxsofttest.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luxsofttest.cloud.MainRepository
import com.example.luxsofttest.ui.screens.main.state.LoadingMainViewState
import com.example.luxsofttest.ui.screens.main.state.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository,
) : ViewModel(){

    val mainViewStateFlow: StateFlow<MainViewState> get() = _mainViewStateFlow
    private val _mainViewStateFlow = MutableStateFlow<MainViewState>(LoadingMainViewState)

    init {
        viewModelScope.launch {
           val result = mainRepository.getCards()
        }
    }

}