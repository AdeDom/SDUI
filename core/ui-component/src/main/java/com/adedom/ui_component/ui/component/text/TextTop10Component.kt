package com.adedom.ui_component.ui.component.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adedom.ui_component.ui.theme.SDUITheme

@Composable
fun TextTop10Component(
    modifier: Modifier = Modifier,
    number: Int,
    name: String,
) {
    Row(
        verticalAlignment = BiasAlignment.Vertical(0.8f),
        modifier = modifier
    ) {
        Text(
            number.toString(),
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 100.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .offset(
                    x = (-5).dp,
                    y = 27.dp
                )
        )
        Text(
            name,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(180.dp)
        )
    }
}

@Preview
@Composable
fun TextTop10ComponentPreview() {
    SDUITheme {
        TextTop10Component(
            number = 1,
            name = "เขยบ้านไร่ สะไภ้ไฮโซ",
        )
    }
}