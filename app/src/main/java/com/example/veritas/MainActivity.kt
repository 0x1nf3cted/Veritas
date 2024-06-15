package com.example.veritas

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.veritas.ui.screens.article.ArticleScreen
import com.example.veritas.ui.screens.home.HomeScreen
import com.example.veritas.ui.screens.notification.NotificationScreen
import com.example.veritas.ui.screens.profile.ProfileScreen
import com.example.veritas.ui.screens.search.SearchScreen
import com.example.veritas.ui.theme.Beige
import com.example.veritas.ui.theme.VeritasTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            VeritasTheme {

                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                val receivedNotifications = 2
                Scaffold(bottomBar = {
                    NavigationBar(modifier = Modifier.background(Beige)) {

                            NavigationBarItem(selected = selectedItemIndex == 0, label = { Text(
                                text = "Home"
                            )}, onClick = { selectedItemIndex = 0
                                navController.navigate(Home)}, icon = {

                                        Icon(
                                            imageVector = if (selectedItemIndex == 0){
                                                Icons.Filled.Home
                                            }else {
                                                Icons.Outlined.Home
                                                  }, contentDescription = "Navigation icon"
                                        )

                            })

                        NavigationBarItem(selected = selectedItemIndex == 1, label = { Text(
                            text = "Search"
                        )}, onClick = { selectedItemIndex = 1
                            navController.navigate(Search)}, icon = {

                            Icon(
                                imageVector = if (selectedItemIndex == 1){
                                    Icons.Filled.Search
                                }else {
                                    Icons.Outlined.Search
                                }, contentDescription = "Navigation icon"
                            )

                        })

                        NavigationBarItem(selected = selectedItemIndex == 2, label = { Text(
                            text = "Search"
                        )}, onClick = { selectedItemIndex = 2
                            navController.navigate(Notification)}, icon = {
                            BadgedBox(
                                badge = {
                                    if(receivedNotifications > 0){
                                        Badge{
                                            Text(
                                                text = receivedNotifications.toString()
                                            )
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (selectedItemIndex == 2 ){
                                        Icons.Filled.Notifications
                                    }else {
                                        Icons.Outlined.Notifications
                                    }, contentDescription = "Navigation icon"
                                )
                            }
                        })
                        NavigationBarItem(selected = selectedItemIndex == 3, label = { Text(
                            text = "Profile"
                        )}, onClick = { selectedItemIndex = 3
                            navController.navigate(Profile)}, icon = {

                            Icon(
                                imageVector = if (selectedItemIndex == 3){
                                    Icons.Filled.Person
                                }else {
                                    Icons.Outlined.Person
                                }, contentDescription = "Navigation icon"
                            )

                        })


                    }
                }) {

                        NavHost(navController = navController, startDestination = Home) {
                            composable<Home>  {
                                HomeScreen(navController)
                            }
                            composable<Search>  {
                                SearchScreen()
                            }
                            composable<Notification>  {
                                NotificationScreen()
                            }
                            composable<Profile>  {
                                ProfileScreen()
                            }
                            composable<Article>  {
                                ArticleScreen(navController)
                            }

                    }
                }

            }
        }
    }
}



data class BottomNavigationItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int?,
)

@Serializable
object Home

@Serializable
object Search

@Serializable
object Notification

@Serializable
object Profile


@Serializable
object Article