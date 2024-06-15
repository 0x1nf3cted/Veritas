package com.example.veritas.ui.screens.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.veritas.ui.components.PieChart
import com.example.veritas.ui.components.PieChartInput
import com.example.veritas.ui.theme.Beige
import com.example.veritas.ui.theme.Blue
import com.example.veritas.ui.theme.LightBlue
import com.example.veritas.ui.theme.LightRed
import com.example.veritas.ui.theme.Red
import com.example.veritas.ui.theme.Typography


@Composable
fun ArticleScreen(navController: NavController){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .verticalScroll(scrollState).background(Beige)) {
        AppBar(false, navController)
        ArticleContent()
        Analytics()

    }
}



@Composable
fun ArticleContent(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Beige)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)){
            AsyncImage(
                model = "https://images.unsplash.com/photo-1717942110740-80424da8eccc?q=80&w=1936&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                contentDescription = "Translated description of what the image contains",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)){
            Column {
                Text(text = "this is a title of a very important and interesting article", style = Typography.titleLarge)
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Row {
                        Text(text = "Le Parisien", style = Typography.labelSmall, color = Color.Gray)
                        Spacer(modifier = Modifier.width(10.dp))
                        Spacer(modifier = Modifier
                            .height(14.dp)
                            .width(2.dp)
                            .background(Color.LightGray))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "4 hrs ago", style = Typography.labelSmall, color = Color.Gray)
                    }
                    Text(text = "24 sources", style = Typography.labelSmall, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Analytics")
            }
        }
    }
}




@Composable
fun Analytics(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 100.dp)){
        PieChart(
            modifier = Modifier
                .size(400.dp),
            centerText="27 sources",
            input = listOf(
                PieChartInput(
                    color = Red,
                    value = 6,
                    description = "droite"
                ),
                PieChartInput(
                    color = LightRed,
                    value = 4,
                    description = "centre droite"
                ),
                PieChartInput(
                    color = Color.White,
                    value = 2,
                    description = "centre"
                ),
                PieChartInput(
                    color = LightBlue,
                    value = 8,
                    description = "centre gauche"
                ),
                PieChartInput(
                    color = Blue,
                    value = 7,
                    description = "gauche"
                )
            ),
        )
    }

}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(bookmarked: Boolean, navController: NavController){
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {},
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Beige
        ),
        actions = {
            IconButton(onClick = { /*navController.navigate("call")*/ }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            IconButton(onClick = { /*navController.navigate("call")*/ }) {
                Icon(
                    imageVector =
                        if (bookmarked) {
                            Icons.Filled.Bookmark
                        }else{
                            Icons.Outlined.Bookmark
                        }
                    ,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}
