package com.example.veritas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.veritas.ui.theme.Beige
import com.example.veritas.ui.theme.Typography

@Composable
fun Tag(value: String, selected: Boolean, onClick: () -> Unit){
    Box(modifier = Modifier.clickable(onClick = onClick).background(if (selected) Color.Black else Beige).border(
        width = 1.dp,
        color = Color.Black,
    ).padding(horizontal = 12.dp, vertical = 6.dp)){
        Text(text = value, style = Typography.bodyMedium, color = if (selected) Beige else Color.Black)
    }
}