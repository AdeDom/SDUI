package com.adedom.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adedom.home.domain.models.HomeModel
import com.adedom.home.domain.usecases.GetHomeUseCase
import com.adedom.home.presentation.event.HomeUiEvent
import com.adedom.home.presentation.state.HomeUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase,
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    private val _nav = Channel<HomeModel>()
    val nav: Flow<HomeModel> = _nav.receiveAsFlow()

    fun onEvent(event: HomeUiEvent) {
        viewModelScope.launch {
            when (event) {
                HomeUiEvent.Initial -> {
                    uiState = uiState.copy(
                        list = getHomeUseCase.execute()
                    )
                }

                is HomeUiEvent.OnClick -> {
                    _nav.send(event.value)
                }
            }
        }
    }
}