package com.example.veritas.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.veritas.ui.theme.Typography


@Composable
fun TopArticle(onArticleClick: () -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp).clickable{
                onArticleClick()
        }
        .drawBehind {

            val strokeWidth = 2f
            val y = size.height - strokeWidth / 2

            drawLine(
                Color.Gray,
                Offset(0f, y),
                Offset(size.width, y),
                strokeWidth
            )
        }.padding(10.dp)){
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column() {
                Text(text = "Politics", style = Typography.labelSmall)
                Text(text = "This is a title ", style = Typography.titleMedium)
                Text(text = "3hrs ago", style = Typography.labelSmall)
            }
            Box(modifier = Modifier.fillMaxHeight().width(120.dp)){
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1717942110740-80424da8eccc?q=80&w=1936&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    contentDescription = "Translated description of what the image contains",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

        }
    }
}