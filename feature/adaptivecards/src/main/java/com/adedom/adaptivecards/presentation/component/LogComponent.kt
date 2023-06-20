package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component

@Composable
fun ComponentText(component: Component) {
    when (component) {
        is Component.AdaptiveCard -> AdaptiveCardText(component = component)
        is Component.Column -> ColumnText(component = component)
        is Component.ColumnSet -> ColumnSetText(component = component)
        is Component.FactSet -> FactSetText(component = component)
        is Component.Image -> ImageText(component = component)
        is Component.InputDate -> InputDateText(component = component)
        is Component.InputText -> InputTextText(component = component)
        is Component.TextBlock -> TextBlockText(component = component)
        is Component.Banner -> BannerText(component = component)
        is Component.Text -> TextText(component = component)
        is Component.Container -> ContainerText(component = component)
        is Component.Cards -> CardsText(component = component)
        is Component.Button -> ButtonText(component = component)
        is Component.Badge -> BadgeText(component = component)
        is Component.TextBadge -> TextBadgeText(component = component)
        is Component.LazyColumn -> LazyColumnText(component = component)
        is Component.LazyHorizontal -> LazyHorizontalText(component = component)
    }
}

@Composable
fun ActionText(action: Action) {
    when (action) {
        is Action.OpenUrl -> ActionOpenUrlText(action = action)
        is Action.ShowCard -> ActionShowCardText(action = action)
        is Action.Submit -> ActionSubmitText(action = action)
        is Action.OpenMore -> ActionOpenMoreText(action = action)
    }
}

@Composable
fun ActionOpenUrlText(modifier: Modifier = Modifier, action: Action.OpenUrl) {
    Column(modifier = modifier) {
        action.type?.let { Text(it.value) }
        action.title?.let { Text(it) }
        action.url?.let { Text(it) }
        Line()
    }
}

@Composable
fun ActionShowCardText(modifier: Modifier = Modifier, action: Action.ShowCard) {
    Column(modifier = modifier) {
        action.type?.let { Text(it.value) }
        action.title?.let { Text(it) }
        action.card?.let { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun ActionSubmitText(modifier: Modifier = Modifier, action: Action.Submit) {
    Column(modifier = modifier) {
        action.type?.let { Text(it.value) }
        action.title?.let { Text(it) }
    }
}

@Composable
fun ActionOpenMoreText(modifier: Modifier = Modifier, action: Action.OpenMore) {
    Column(modifier = modifier) {
        action.type?.let { Text(it.value) }
        action.title?.let { Text(it) }
        action.url?.let { Text(it) }
        Line()
    }
}

@Composable
fun AdaptiveCardText(modifier: Modifier = Modifier, component: Component.AdaptiveCard) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.body?.forEach { ComponentText(component = it) }
        component.actions?.forEach { ComponentText(component = it) }
        component.schema?.let { Text(it) }
        component.version?.let { Text(it) }
        Line()
    }
}

@Composable
fun ColumnText(modifier: Modifier = Modifier, component: Component.Column) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
//        component.index?.let { Text(it.toString()) }
        component.items?.forEach { ComponentText(component = it) }
//        component.width?.let { Text(it.value) }
//        component.style?.let { Text(it.value) }
        component.selectAction?.let { ActionText(action = it) }
        Line()
    }
}

@Composable
fun ColumnSetText(modifier: Modifier = Modifier, component: Component.ColumnSet) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.columns?.forEach { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun FactSetText(modifier: Modifier = Modifier, component: Component.FactSet) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.facts?.forEach { fact ->
            fact.data?.let { Text(it) }
            fact.title?.let { Text(it) }
            fact.value?.let { Text(it) }
        }
        Line()
    }
}

@Composable
fun ImageText(modifier: Modifier = Modifier, component: Component.Image) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
//        component.style?.let { Text(it.value) }
        component.url?.let { Text(it) }
        component.size?.let { Text(it.value) }
//        component.info?.let { Text(it.toString()) }
//        component.ratio?.let { Text(it) }
//        component.column?.let { Text(it.toString()) }
//        component.overlays?.forEach { ComponentText(component = it) }
//        component.items?.forEach { ComponentText(component = it) }
//        component.images?.forEach { Text(it) }
        Line()
    }
}

@Composable
fun InputDateText(modifier: Modifier = Modifier, component: Component.InputDate) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.id?.let { Text(it) }
    }
}

@Composable
fun InputTextText(modifier: Modifier = Modifier, component: Component.InputText) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.id?.let { Text(it) }
        component.placeholder?.let { Text(it) }
        component.isMultiline?.let { Text(it.toString()) }
    }
}

@Composable
fun TextBlockText(modifier: Modifier = Modifier, component: Component.TextBlock) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
//        component.index?.let { Text(it.toString()) }
//        component.size?.let { Text(it.value) }
//        component.weight?.let { Text(it.value) }
//        component.spacing?.let { Text(it.value) }
        component.text?.let { Text(it) }
//        component.isSubtle?.let { Text(it.toString()) }
//        component.wrap?.let { Text(it.toString()) }
        Line()
    }
}

@Composable
fun BannerText(modifier: Modifier = Modifier, component: Component.Banner) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.index?.let { Text(it.toString()) }
        component.info?.let { Text(it.toString()) }
        component.url?.let { Text(it) }
        component.items?.forEach { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun TextText(modifier: Modifier = Modifier, component: Component.Text) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.index?.let { Text(it.toString()) }
        component.text?.let { Text(it) }
        component.size?.let { Text(it.value) }
        Text(component.color)
        component.weight?.let { Text(it.value) }
        component.align?.let { Text(it.value) }
        component.spacing?.let { Text(it.value) }
        component.selectAction?.let { ActionText(action = it) }
        component.maxLines?.let { Text(it.toString()) }
        Line()
    }
}

@Composable
fun ContainerText(modifier: Modifier = Modifier, component: Component.Container) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
//        component.index?.let { Text(it.toString()) }
        component.items?.forEach { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun CardsText(modifier: Modifier = Modifier, component: Component.Cards) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.index?.let { Text(it.toString()) }
        component.background?.let { Text(it) }
        component.size?.let { Text(it.value) }
        component.column?.let { Text(it.toString()) }
        component.spacing?.let { Text(it.value) }
        component.page?.let { Text(it.toString()) }
        component.items?.forEach { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun ButtonText(modifier: Modifier = Modifier, component: Component.Button) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.icon?.let { Text(it.value) }
        component.align?.let { Text(it.value) }
        Line()
    }
}

@Composable
fun BadgeText(modifier: Modifier = Modifier, component: Component.Badge) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.style?.let { Text(it.value) }
        component.items?.forEach { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun TextBadgeText(modifier: Modifier = Modifier, component: Component.TextBadge) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.text?.let { Text(it) }
        component.meta?.let { Text(it.toString()) }
        component.spacing?.let { Text(it.value) }
        Text(component.color)
        component.selectAction?.let { ActionText(action = it) }
        Line()
    }
}

@Composable
fun LazyColumnText(modifier: Modifier = Modifier, component: Component.LazyColumn) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.body?.forEach { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun LazyHorizontalText(modifier: Modifier = Modifier, component: Component.LazyHorizontal) {
    Column(modifier = modifier) {
        component.type?.let { Text(it.value) }
        component.column?.let { Text(it.toString()) }
        component.columns?.forEach { ComponentText(component = it) }
        Line()
    }
}

@Composable
fun Line(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black)
    )
}