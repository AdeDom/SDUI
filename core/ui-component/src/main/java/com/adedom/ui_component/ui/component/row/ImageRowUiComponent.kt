package com.adedom.ui_component.ui.component.row

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adedom.ui_component.domain.models.ImageComponent
import com.adedom.ui_component.ui.component.image.ImageCardComponent

@Composable
fun ImageRowUiComponent(
    modifier: Modifier = Modifier,
    imageComponents: List<ImageComponent>,
    onClick: (String?) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
    ) {
        items(imageComponents) {
            ImageCardComponent(
                number = it.number,
                name = it.name,
                value = it.value,
                contentDescription = it.contentDescription,
                roundedCornerShape = it.roundedCornerShape,
                newEpisodes = it.newEpisodes,
                modifier = if (it.width == null)
                    Modifier
                        .fillMaxWidth()
                        .height(it.height.dp)
                        .clickable(onClick = {
                            onClick(it.key)
                        })
                else
                    Modifier
                        .size(it.width.dp, it.height.dp)
                        .clickable(onClick = {
                            onClick(it.key)
                        })
            )
        }
    }
}