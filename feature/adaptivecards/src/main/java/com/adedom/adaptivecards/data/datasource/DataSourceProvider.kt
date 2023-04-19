package com.adedom.adaptivecards.data.datasource

import com.adedom.adaptivecards.data.datasource.remote.MockyService
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.adapter.ComponentSizeAdapter
import com.adedom.adaptivecards.data.models.adapter.ComponentSpacingAdapter
import com.adedom.adaptivecards.data.models.adapter.ComponentStyleAdapter
import com.adedom.adaptivecards.data.models.adapter.ComponentTypeAdapter
import com.adedom.adaptivecards.data.models.adapter.ComponentWeightAdapter
import com.adedom.adaptivecards.data.models.adapter.ComponentWidthAdapter
import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class DataSourceProvider {

    fun getMockyService(): MockyService {
        val moshi: Moshi = Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory
                    .of(Component::class.java, "type")
                    .withSubtype(Component.Column::class.java, ComponentType.COLUMN.value)
                    .withSubtype(Component.ColumnSet::class.java, ComponentType.COLUMN_SET.value)
                    .withSubtype(Component.FactSet::class.java, ComponentType.FACT_SET.value)
                    .withSubtype(Component.Image::class.java, ComponentType.IMAGE.value)
                    .withSubtype(Component.TextBlock::class.java, ComponentType.TEXT_BLOCK.value)
            )
            .add(ComponentTypeAdapter)
            .add(ComponentSizeAdapter)
            .add(ComponentWeightAdapter)
            .add(ComponentWidthAdapter)
            .add(ComponentStyleAdapter)
            .add(ComponentSpacingAdapter)
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://run.mocky.io/")
            .build()
            .create()
    }
}