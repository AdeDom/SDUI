package com.adedom.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adedom.home.data.repositories.HomeRepository
import com.adedom.home.presentation.event.HomeUiEvent
import com.adedom.home.presentation.state.HomeUiState
import com.adedom.ui_component.domain.models.AppDialogComponent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    private val _nav = Channel<String>()
    val nav: Flow<String> = _nav.receiveAsFlow()

    fun onEvent(event: HomeUiEvent) {
        viewModelScope.launch {
            when (event) {
                HomeUiEvent.Initial -> {
                    uiState = uiState.copy(uiComponents = homeRepository.getHome().components)
                }
                is HomeUiEvent.OnClickMovieListener -> {
                    if (event.key != null) {
                        _nav.send(event.key)
                    } else {
                        uiState = uiState.copy(dialog = AppDialogComponent.EmptyData)
                    }
                }
                HomeUiEvent.OnClickHideDialogListener -> {
                    uiState = uiState.copy(dialog = null)
                }
            }
        }
    }
}