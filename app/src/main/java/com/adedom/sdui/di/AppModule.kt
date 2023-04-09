package com.adedom.sdui.di

import com.adedom.home.data.repositories.HomeRepository
import com.adedom.home.data.repositories.HomeRepositoryImpl
import com.adedom.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // data
    single<HomeRepository> { HomeRepositoryImpl(get()) }

    // domain

    // presentation
    viewModel { HomeViewModel(get()) }
}