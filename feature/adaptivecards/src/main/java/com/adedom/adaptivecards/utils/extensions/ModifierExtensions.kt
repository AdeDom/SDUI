package com.adedom.adaptivecards.utils.extensions

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import com.adedom.adaptivecards.data.models.Action

fun Modifier.clickable(
    action: Action?,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: (Action) -> Unit
): Modifier {
    return if (action != null) {
        this.clickable(
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
            onClick = {
                onClick(action)
            },
        )
    } else {
        this
    }
}