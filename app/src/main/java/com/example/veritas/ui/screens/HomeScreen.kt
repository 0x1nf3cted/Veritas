package com.example.veritas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Vertices
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.veritas.R
import com.example.veritas.ui.theme.Beige
import com.example.veritas.ui.theme.DarkBeige
import com.example.veritas.ui.theme.VeritasTheme


@Composable
fun HomeScreen(){
    Column(
        Modifier
            .background(Beige)
            .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        AppBar()
        Spacer(modifier = Modifier.height(4.dp))
        SearchField()
        Text(text = "Trending")


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
                    text = "Good mornong",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Moussa",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    )
                )
            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFFEAE0D5)
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
            .border(
                width = 1.dp,
                color = DarkBeige,
            )
            .fillMaxWidth()
    )
}


