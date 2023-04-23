package com.adedom.ui_component.ui.component.text

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adedom.ui_component.ui.theme.SDUITheme

@Composable
fun TextProfileNameComponent(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 12.sp,
        fontWeight = FontWeight.Thin,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = modifier.width(80.dp)
    )
}

@Preview
@Composable
fun TextProfileNameComponentPreview() {
    SDUITheme {
        TextProfileNameComponent(text = "ฟีฟ่า เปรมอนันต์")
    }
}