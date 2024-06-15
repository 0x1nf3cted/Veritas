package com.example.veritas.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.veritas.Article
import com.example.veritas.ui.components.LatestArticle
import com.example.veritas.ui.components.Tag
import com.example.veritas.ui.components.TopArticle
import com.example.veritas.ui.components.TrendingArticle
import com.example.veritas.ui.theme.Beige
import com.example.veritas.ui.theme.DarkBeige
import com.example.veritas.ui.theme.Typography


@Composable
fun HomeScreen(navController: NavHostController) {


    val tagList = listOf(
        "All", "Business", "Culture", "Politics", "Sport", "Economy"
    )

    val lazyLIstState = rememberLazyListState()
    val tagLazyLIstState = rememberLazyListState()
    val snapBehaviour = rememberSnapFlingBehavior(lazyListState = lazyLIstState)
    var selectedTag by remember {
        mutableStateOf(tagList.get(0))
    }
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxWidth()
            .background(Beige)
            .verticalScroll(scrollState)
            .padding(10.dp), horizontalAlignment = Alignment.Start){
        AppBar()
        Spacer(modifier = Modifier.height(4.dp))
        SearchField()
        val list = listOf(
            "A", "B", "C", "D"
        ) + ((0..10).map { it.toString() })



        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Text(text = "Trending", style = Typography.titleLarge)
            Text(text = "View more", style = Typography.labelSmall, color = Color.Magenta)

        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(state = tagLazyLIstState, modifier = Modifier
            .fillMaxWidth()) {
            items(items = tagList, itemContent = { item ->
                Row {

                    Tag(item, (selectedTag == item), onClick = { selectedTag = item })

                    Spacer(modifier = Modifier.width(8.dp))
                }

            })
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(state = lazyLIstState, flingBehavior = snapBehaviour, modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()) {
            items(items = list, itemContent = { item ->
                TrendingArticle(onArticleClick = {
                    navController.navigate(Article)
                })
            })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Latest news", style = Typography.titleLarge)

        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                LatestArticle(tag = selectedTag, onArticleClick = {
                    navController.navigate(Article)
                })
                LatestArticle(tag = selectedTag, onArticleClick = {
                    navController.navigate(Article)
                })
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                LatestArticle(tag = selectedTag, onArticleClick = {
                    navController.navigate(Article)
                })
                LatestArticle(tag = selectedTag, onArticleClick = {
                    navController.navigate(Article)
                })
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Text(text = "Top news", style = Typography.titleLarge)
            Text(text = "View more", style = Typography.labelSmall, color = Color.Magenta)
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            TopArticle(onArticleClick = {
                navController.navigate(Article)
            })
            TopArticle(onArticleClick = {
                navController.navigate(Article)
            })
            TopArticle(onArticleClick = {
                navController.navigate(Article)
            })
        }



    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Good morning",
                    style = Typography.titleLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Moussa",
                    style = Typography.labelLarge
                )
            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Beige
        ),
        actions = {
            IconButton(onClick = { /*navController.navigate("call")*/ }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}

@Composable
fun SearchField(){
    var search_terms by remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Search,
            contentDescription = "",
            tint = Color.Gray
        )
    }

    TextField(

        value = search_terms,
        onValueChange = { text ->
            search_terms = text
        },
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { Text("Search for an event") },
        label = { Text("Search for an event") },
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        modifier = Modifier
            .background(Beige)
            .border(
                width = 1.dp,
                color = DarkBeige,
            )
            .fillMaxWidth()
    )
}







