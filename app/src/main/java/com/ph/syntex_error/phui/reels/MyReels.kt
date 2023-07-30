package com.ph.syntex_error.phui.reels

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.Poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyReelPage(navController: NavHostController) {

    Box() {

        val pagerState = rememberPagerState(initialPage = 0)

        Image(
            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )

        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.size(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.backbtn),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).padding(bottom = 3.dp),
                )

                Text(
                    text = "Profile", color = Color.White, fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontWeight = FontWeight.W500, fontFamily = Poppins
                )

                Spacer(modifier = Modifier.weight(1f))



                Image(
                    painter = painterResource(R.drawable.reel_share),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .size(20.dp), colorFilter = ColorFilter.tint(Color.White)
                )

            }

            val list = (1..10).map { it.toString() }

            Tabs(pagerState = pagerState)
            val screenHight = LocalConfiguration.current.screenHeightDp

            LazyVerticalGrid(columns = GridCells.Fixed(2) , modifier = Modifier.padding(4.dp)){

                items(list.size){

                    ReelGridItem(screenHight){

                       // navController.navigate("")

                    }

                }

            }



        }

        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = Color(0xffFF136F),
            modifier = Modifier.align(Alignment.BottomCenter).padding(24.dp)
        ) {
            Row(
                Modifier.padding(vertical = 6.dp, horizontal = 12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.reel_rounded_add),
                    contentDescription = "",
                    Modifier
                        .padding(bottom = 2.dp, end = 4.dp)
                        .size(24.dp)
                )

                        Text(
                    text = "Create",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(500),
                        color = Color.White,
                    )
                )
            }

        }



    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list = listOf(
        "My Video",
        "Liked Reels",
        "Saved Reels"
    )
    // on below line we are creating
    // a variable for the scope.
    val scope = rememberCoroutineScope()

    // on below line we are creating a
    // individual row for our tab layout.
    TabRow(
        // on below line we are specifying
        // the selected index.

        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color(0xff221E34),
        contentColor = Color(0x4DFFFFFF),
        indicator = { tabPositions ->
            Box {}
        },
        modifier = Modifier.height(50.dp).padding(horizontal = 8.dp).clip(RoundedCornerShape(8.dp))
    ) {
        list.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                modifier = if (pagerState.currentPage == index)
                    Modifier
                        .padding(horizontal = 4.dp, vertical = 5.dp)
                        .clip(RoundedCornerShape(8.dp))
                    .background(
                        Color(0xFFFF136F)
                    )

                else Modifier.padding(horizontal = 4.dp, vertical = 5.dp) ,
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray,
                        fontSize = 12.sp,
                        fontFamily = Poppins
                    )
                },
                selected = pagerState.currentPage == index,

                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

