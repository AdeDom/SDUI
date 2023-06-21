package com.adedom.home.domain.usecases

import com.adedom.home.domain.models.HomeModel

class GetHomeUseCase {

    fun execute(): List<HomeModel> {
        return listOf(
            HomeModel(id = 1, text = "Started"),
            HomeModel(id = 2, text = "OverlaysAndPosition"),
        )
    }

}