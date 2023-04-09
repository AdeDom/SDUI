package com.adedom.ui_component.ui.component.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adedom.ui_component.ui.component.image.ProfileUiComponent
import com.adedom.ui_component.ui.theme.SDUITheme

@Composable
fun ProfileCardComponent(
    modifier: Modifier = Modifier,
    name: String,
    value: String = "",
    contentDescription: String? = null
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ProfileUiComponent(
            value = value,
            contentDescription = contentDescription,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextProfileNameComponent(text = name)
    }
}

@Preview
@Composable
fun ProfileCardComponentPreview() {
    SDUITheme {
        ProfileCardComponent(
            name = "ฟีฟ่า เปรมอนันต์",
            modifier = Modifier.size(80.dp)
        )
    }
}