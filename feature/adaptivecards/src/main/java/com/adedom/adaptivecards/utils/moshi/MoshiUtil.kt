package com.adedom.adaptivecards.utils.moshi

import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.adapter.ComponentTypeAdapter
import com.adedom.adaptivecards.data.models.adapter.ImageSizeAdapter
import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiUtil {

    fun getMoshi(): Moshi {
        val componentAdapter = PolymorphicJsonAdapterFactory
            .of(Component::class.java, "type")
            .withSubtype(Component.AdaptiveCard::class.java, ComponentType.ADAPTIVE_CARD.value)
            .withSubtype(Component.Column::class.java, ComponentType.COLUMN.value)
            .withSubtype(Component.ColumnSet::class.java, ComponentType.COLUMN_SET.value)
            .withSubtype(Component.FactSet::class.java, ComponentType.FACT_SET.value)
            .withSubtype(Component.Image::class.java, ComponentType.IMAGE.value)
            .withSubtype(Component.InputDate::class.java, ComponentType.INPUT_DATE.value)
            .withSubtype(Component.InputText::class.java, ComponentType.INPUT_TEXT.value)
            .withSubtype(Component.TextBlock::class.java, ComponentType.TEXT_BLOCK.value)
            .withSubtype(Component.Banner::class.java, ComponentType.BANNER.value)
            .withSubtype(Component.Text::class.java, ComponentType.TEXT.value)
            .withSubtype(Component.Container::class.java, ComponentType.CONTAINER.value)
            .withSubtype(Component.Cards::class.java, ComponentType.CARDS.value)
            .withSubtype(Component.Button::class.java, ComponentType.BUTTON.value)
            .withSubtype(Component.Badge::class.java, ComponentType.BADGE.value)
            .withSubtype(Component.TextBadge::class.java, ComponentType.TEXT_BADGE.value)
            .withSubtype(Component.LazyColumn::class.java, ComponentType.LAZY_COLUMN.value)
            .withSubtype(Component.LazyHorizontal::class.java, ComponentType.LAZY_HORIZONTAL.value)

        val actionAdapter = PolymorphicJsonAdapterFactory
            .of(Action::class.java, "type")
            .withSubtype(Action.OpenUrl::class.java, ComponentType.ACTION_OPEN_URL.value)
            .withSubtype(Action.ShowCard::class.java, ComponentType.ACTION_SHOW_CARD.value)
            .withSubtype(Action.Submit::class.java, ComponentType.ACTION_SUBMIT.value)
            .withSubtype(Action.OpenMore::class.java, ComponentType.ACTION_OPEN_MORE.value)

        return Moshi.Builder()
            .add(componentAdapter)
            .add(actionAdapter)
            .add(ComponentTypeAdapter)
//            .add(ComponentSizeAdapter)
//            .add(ComponentWeightAdapter)
//            .add(ComponentWidthAdapter)
//            .add(ComponentStyleAdapter)
//            .add(ComponentSpacingAdapter)
//            .add(ComponentAlignAdapter)
//            .add(ComponentIconAdapter)
            .add(ImageSizeAdapter)
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}