package com.ph.syntex_error.phui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.home, "Home")
    object Enrolled : NavigationItem("enrolled", R.drawable.enrolled, "Enrolled")
    object Playground : NavigationItem("playground", R.drawable.scroll, "Playground")
    object Forum : NavigationItem("forum", R.drawable.scroll, "Forum")
    object Profile : NavigationItem("profile", R.drawable.profile, "Profile")
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(

        NavigationItem.Home,
        NavigationItem.Enrolled,
        NavigationItem.Playground,
        NavigationItem.Forum,
        NavigationItem.Profile

    )
    BottomNavigation(
        backgroundColor = Color(0xff1E293B),
        contentColor = Color(0xff787f89)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon),
                        contentDescription = "" , modifier = Modifier
                            .size(25.dp)
                            .padding(2.dp) )
                },
                label = { Text(text = item.title , fontSize = 11.sp  , maxLines = 1 , overflow = TextOverflow.Ellipsis) },
                selectedContentColor = Color(0xFFFF136F),
                unselectedContentColor = Color(0xff787f89),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {

                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }

                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomePage(navController)
        }
        composable(NavigationItem.Enrolled .route) {
            MyCoursePage()
        }
        composable(NavigationItem.Playground.route) {
            //PostCard()
        }
        composable(NavigationItem.Forum.route) {
            PostCard()
        }
        composable(NavigationItem.Profile.route) {
            ProfilePage(navController)
        }

        composable("gem-store") {
            GemStorePage()
        }
        composable("badge-page") {
            BadgePage()
        }
        composable("friend-page") {
            FriendsList()
        }
        composable("certificate-page") {
            CertificatePage()
        }
        composable("leaderboard-page") {
            LeaderBoardPage()
        }
        composable("search-page") {
            SearchPage(navController)
        }


        composable("bookmark-page") {
            BookmarkPage()
        }

        composable("module-page") {
            ModulePage(navController)
        }

        composable("planet-page") {
            PlanetPage(navController)
        }

        composable("video-page") {
            VideoCourseDetails()
        }
    }
}
