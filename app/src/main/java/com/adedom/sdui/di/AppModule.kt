package com.adedom.sdui.di

import com.adedom.adaptivecards.data.datasource.DataSourceProvider
import com.adedom.adaptivecards.data.datasource.remote.AdaptiveCardRemoteDataSource
import com.adedom.adaptivecards.data.datasource.remote.AdaptiveCardRemoteDataSourceImpl
import com.adedom.adaptivecards.data.repositories.AdaptiveCardRepository
import com.adedom.adaptivecards.data.repositories.AdaptiveCardRepositoryImpl
import com.adedom.adaptivecards.domain.usecase.GetAdaptiveCardByIdUseCase
import com.adedom.adaptivecards.presentation.viewmodel.AdaptiveCardViewModel
import com.adedom.home.domain.usecases.GetHomeUseCase
import com.adedom.home.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {

    // data
    single { Dispatchers.IO }

    singleOf(::DataSourceProvider)

    singleOf(::AdaptiveCardRemoteDataSourceImpl) { bind<AdaptiveCardRemoteDataSource>() }

    singleOf(::AdaptiveCardRepositoryImpl) { bind<AdaptiveCardRepository>() }

    // domain
    factoryOf(::GetAdaptiveCardByIdUseCase)
    factoryOf(::GetHomeUseCase)

    // presentation
    viewModelOf(::AdaptiveCardViewModel)
    viewModelOf(::HomeViewModel)
}