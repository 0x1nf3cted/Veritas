package com.example.veritas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.veritas.ui.theme.Beige
import com.example.veritas.ui.theme.Typography


@Composable
fun TrendingArticle(onArticleClick: () -> Unit){
    Box(modifier = Modifier
        .width(350.dp)
        .padding(4.dp).clickable{
            onArticleClick()
        }){

        AsyncImage(
            model = "https://images.unsplash.com/photo-1717942110740-80424da8eccc?q=80&w=1936&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            contentDescription = "Translated description of what the image contains",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = -4.dp, y = 4.dp)
        ){
            PieChart(
                modifier = Modifier
                    .size(40.dp),
                input = listOf(
                    PieChartInput(
                        color = Color.Black,
                        value = 29,
                        description = "Python"
                    ),
                    PieChartInput(
                        color = Color.Gray,
                        value = 21,
                        description = "Swift"
                    ),
                    PieChartInput(
                        color = Color.Green,
                        value = 32,
                        description = "JavaScript"
                    )
                ),
            )
        }
        Box(modifier = Modifier.padding(start = 10.dp, bottom = 8.dp, end = 10.dp), contentAlignment = Alignment.BottomStart){
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                Box(Modifier.background(Color.Yellow)){
                    Text(text = "Trending", color = Color.Black, fontSize = 14.sp, modifier = Modifier.padding(4.dp), style = Typography.labelLarge)
                }
                Box(
                    Modifier
                        .background(Beige)
                        .fillMaxWidth()){
                    Column(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                    ) {
                        Text(text = "This is a second text", color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "Le Parisien", color = Color.Gray, style = Typography.labelSmall)
                            Text(text = "14 Juin", color = Color.Gray, style = Typography.labelSmall)
                        }

                    }
                }
            }
        }
    }
}