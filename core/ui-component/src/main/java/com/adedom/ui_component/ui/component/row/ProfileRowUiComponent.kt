package com.adedom.ui_component.ui.component.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adedom.ui_component.domain.models.ProfileComponent
import com.adedom.ui_component.ui.component.text.ProfileCardComponent

@Composable
fun ProfileRowUiComponent(
    modifier: Modifier = Modifier,
    profileComponents: List<ProfileComponent>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
    ) {
        items(profileComponents) {
            ProfileCardComponent(
                name = it.name,
                value = it.value,
                contentDescription = it.contentDescription,
                modifier = Modifier.size(it.width.dp, it.height.dp)
            )
        }
    }
}