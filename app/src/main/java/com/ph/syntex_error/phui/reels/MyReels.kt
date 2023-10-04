package com.ph.syntex_error.phui.reels

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ph.syntex_error.phui.ContentPage
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.dashedBorder
import com.ph.syntex_error.phui.ui.theme.PHUITheme
import com.ph.syntex_error.phui.ui.theme.Poppins
import com.ph.syntex_error.phui.ui.theme.cardBackgroundColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyReelPage(navController: NavHostController?) {

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
                    modifier = Modifier
                        .size(20.dp)
                        .padding(bottom = 3.dp)
                        .clickable {
                            navController?.popBackStack()
                        },
                )

                Text(
                    text = "Profile", color = Color.White, fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontWeight = FontWeight.W500, fontFamily = Poppins
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(R.drawable.reel_gear_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .size(20.dp), colorFilter = ColorFilter.tint(Color.White)
                )

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
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
                .clickable {
                    navController?.navigate("reel-camera-page")
                }
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
        modifier = Modifier
            .height(50.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(8.dp))
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


@Composable
@Preview
fun contentPreview1() {

    PHUITheme {

        MyReelProfilePage(null)
    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyReelProfilePage(navController: NavHostController?) {

    Box() {

        val pagerState = rememberPagerState(initialPage = 0)

        Image(
            painter = painterResource(R.drawable.reel_back),
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
                    modifier = Modifier
                        .size(20.dp)
                        .padding(bottom = 3.dp)
                        .clickable {
                            navController?.popBackStack()
                        },
                )

                Text(
                    text = "Profile", color = Color.White, fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontWeight = FontWeight.W500, fontFamily = Poppins
                )

                Spacer(modifier = Modifier.weight(1f))


            }


            Card(elevation = 8.dp  ,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .padding(16.dp),
                backgroundColor = Color.Transparent,
            ) {

                Box(
                    contentAlignment = Alignment.TopStart
                ) {
                    Image(painter = painterResource(id = R.drawable.profile_card_background),
                        contentDescription = "reel_profile_card_bg" , Modifier.fillMaxWidth(1f),
                        contentScale = ContentScale.Crop)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .padding(top = 20.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {




                            Box(modifier = Modifier.dashedBorder(2.dp, 25.dp, Color.Red)) {
                                Image(
                                    painter = painterResource(id = R.drawable.avater),
                                    contentDescription = "",
                                    Modifier
                                        .size(50.dp)
                                        .clip(CircleShape)
                                )
                            }




                        Spacer(modifier = Modifier.width(10.dp))

                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {


                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically ,
                            ) {
                                Text(
                                    text = "Zahid Hossain", style = TextStyle(
                                        fontWeight = FontWeight.W500,
                                        fontSize = 14.sp,
                                        color = Color.White,
                                        fontFamily = Poppins
                                    )
                                )

                                Spacer(modifier = Modifier.width(6.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.verified),
                                    contentDescription = "",
                                    modifier = Modifier.size(18.dp)
                                )


                            }

                            Spacer(modifier = Modifier.height(3.dp))

                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "123", style = TextStyle(
                                        fontWeight = FontWeight.W600, color = Color.White, fontFamily = Poppins,fontSize = 12.sp
                                    )
                                )

                                Text(text = " Followers", color = Color(0xff94A3B8) , fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(10.dp))

                                Divider(
                                    color = Color(0xff64748B), modifier = Modifier
                                        .height(12.dp)
                                        .width(1.dp)
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Text(
                                    text = "23", style = TextStyle(
                                        fontWeight = FontWeight.W600, color = Color.White, fontFamily = Poppins,fontSize = 12.sp
                                    )
                                )

                                Text(text = " Following", color = Color(0xff94A3B8) , fontSize = 12.sp)

                            }

                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "123", style = TextStyle(
                                        fontWeight = FontWeight.W600, color = Color.White, fontFamily = Poppins , fontSize = 12.sp
                                    )
                                )

                                Text(text = " Followers", color = Color(0xff94A3B8), fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(10.dp))

                                Divider(
                                    color = Color(0xff64748B), modifier = Modifier
                                        .height(12.dp)
                                        .width(1.dp)
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Text(
                                    text = "23", style = TextStyle(
                                        fontWeight = FontWeight.W600, color = Color.White, fontFamily = Poppins , fontSize = 12.sp
                                    )
                                )

                                Text(text = " Following", color = Color(0xff94A3B8),fontSize = 12.sp)

                            }



                            Card(
                                border = BorderStroke(1.dp, Color(0xff475569)),
                                shape = RoundedCornerShape(4.dp),
                                backgroundColor = Color.Transparent,
                                modifier = Modifier.padding(top = 4.dp),
                                contentColor = Color.Transparent,
                                elevation = 0.dp
                            ) {
                                Text(
                                    text = "Follow",
                                    color = Color.White,
                                    fontFamily = Poppins,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp).background(Color.Transparent)
                                )
                            }

                        }
                    }

                }



            }

            val list = (1..10).map { it.toString() }
            val screenHight = LocalConfiguration.current.screenHeightDp

            Text(
                text = "All Reels",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFCBD5E1),
                ),
                modifier = Modifier
                    .padding(16.dp)
            )

            LazyVerticalGrid(columns = GridCells.Fixed(2) , modifier = Modifier.padding(horizontal = 12.dp)){

                items(list.size){

                    ReelGridItem(screenHight){

                        // navController.navigate("")

                    }

                }

            }






        }




    }
}

