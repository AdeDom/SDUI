package com.adedom.home.presentation.event

sealed interface HomeUiEvent {

    object Initial : HomeUiEvent

    data class OnClickMovieListener(
        val movieId: Int,
    ) : HomeUiEvent
}