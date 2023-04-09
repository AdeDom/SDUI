package com.adedom.ui_component.ui.component.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adedom.ui_component.data.models.PaddingData

@Composable
fun TextUiComponent(
    modifier: Modifier = Modifier,
    value: String,
    colorString: String,
    fontSize: Int,
    fontWeight: Int,
    padding: PaddingData
) {
    Text(
        text = value,
        color = Color(android.graphics.Color.parseColor("#$colorString")),
        fontSize = fontSize.sp,
        fontWeight = FontWeight(fontWeight),
        modifier = modifier
            .padding(
                start = padding.start.dp,
                top = padding.top.dp,
                end = padding.end.dp,
                bottom = padding.bottom.dp
            )
    )
}