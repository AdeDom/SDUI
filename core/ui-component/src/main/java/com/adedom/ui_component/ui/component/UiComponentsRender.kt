package com.adedom.ui_component.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adedom.ui_component.domain.models.*
import com.adedom.ui_component.ui.component.image.ImageUiComponent
import com.adedom.ui_component.ui.component.row.ImageRowUiComponent
import com.adedom.ui_component.ui.component.row.ProfileRowUiComponent
import com.adedom.ui_component.ui.component.text.ProfileCardComponent
import com.adedom.ui_component.ui.component.text.TextUiComponent

@Composable
fun UiComponentsRender(
    modifier: Modifier = Modifier,
    uiComponents: List<UiComponent>,
    onClick: () -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.clickable(onClick = onClick)
    ) {
        items(uiComponents) {
            when (it) {
                is ImageRowComponent -> {
                    ImageRowUiComponent(imageComponents = it.imageComponents)
                }
                is ProfileRowComponent -> {
                    ProfileRowUiComponent(profileComponents = it.profileComponents)
                }
                is TextComponent -> {
                    TextUiComponent(
                        value = it.value,
                        colorString = it.color,
                        fontSize = it.fontSize,
                        fontWeight = it.fontWeight,
                        padding = it.padding
                    )
                }
                is ImageComponent -> {
                    ImageUiComponent(
                        value = it.value,
                        contentDescription = it.contentDescription,
                        roundedCornerShape = it.roundedCornerShape,
                        modifier = if (it.width == null)
                            Modifier
                                .fillMaxWidth()
                                .height(it.height.dp)
                        else
                            Modifier.size(it.width.dp, height = it.height.dp)
                    )
                }
                is ProfileComponent -> {
                    ProfileCardComponent(
                        name = it.name,
                        value = it.value,
                        contentDescription = it.contentDescription,
                        modifier = Modifier.size(it.width.dp, height = it.height.dp)
                    )
                }
                is SpacerComponent -> {
                    SpacerUiComponent(Modifier.height(it.height.dp))
                }
                NoneComponent -> {
                    NoneUiComponent()
                }
            }
        }
    }
}