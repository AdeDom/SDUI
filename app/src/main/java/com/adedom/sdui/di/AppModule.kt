package com.adedom.sdui.di

import com.adedom.home.data.repositories.HomeRepository
import com.adedom.home.data.repositories.HomeRepositoryImpl
import com.adedom.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {

    // data
    singleOf(::HomeRepositoryImpl) { bind<HomeRepository>() }

    // domain

    // presentation
    viewModelOf(::HomeViewModel)
}