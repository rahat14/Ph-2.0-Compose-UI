package com.ph.syntex_error.phui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.ph.syntex_error.phui.ui.theme.Poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ModulePage(navController: NavHostController) {
    val pagerState = rememberPagerState(initialPage = 0)

    Box {
        Image(

            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            Row(
                modifier = Modifier
                    .background(Color(0xff0F172A))
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.backbtn), contentDescription = "",
                    modifier = Modifier
                        .height((15.4).dp)
                        .width(18.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier

                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xffAEBBFF),
                                        Color(0xff9ED0FF),

                                        )
                                )
                            )
                    ) {
                        Card(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(
                                    top = 1.dp,
                                    bottom = 4.dp,
                                    start = (1.5).dp,
                                    end = (1.5).dp
                                )
                        ) {
                            Box(
                                modifier = Modifier.background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xff5F5FFF),
                                            Color(0xff5222D0),

                                            )
                                    )


                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.diamond_2),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(16.dp)
                                            .padding(bottom = 2.dp)
                                    )

                                    Text(
                                        text = " 23256 ",
                                        fontSize = 13.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.W600,
                                        style = TextStyle(
                                            platformStyle = PlatformTextStyle(
                                                includeFontPadding = false
                                            )
                                        ),
                                        modifier = Modifier.padding(horizontal = 4.dp)
                                    )


                                }
                            }


                        }

                    }


                }


                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(horizontal = 8.dp)

                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xffFFD6AE),
                                        Color(0xffFF9EA7),

                                        )
                                )
                            )
                    ) {
                        Card(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(
                                    top = 1.dp,
                                    bottom = 4.dp,
                                    start = (1.5).dp,
                                    end = (1.5).dp
                                )
                        ) {
                            Box(
                                modifier = Modifier.background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xffF9A641),
                                            Color(0xffFE4D60),

                                            )
                                    )


                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {


                                    Text(
                                        text = " Upgrade To Pro ",
                                        fontSize = 13.sp,
                                        color = Color(0xff0F172A),
                                        fontWeight = FontWeight.SemiBold,
                                        style = TextStyle(
                                            platformStyle = PlatformTextStyle(
                                                includeFontPadding = false
                                            ), fontFamily = Poppins
                                        ),
                                        modifier = Modifier.padding(horizontal = 4.dp)
                                    )


                                }
                            }


                        }

                    }


                }

                Image(
                    painter = painterResource(id = R.drawable.trophy_with_back),
                    contentDescription = ""
                )

            }
            
            
            Box(modifier = Modifier.height(220.dp)){
                
                Image( painter = painterResource(id = R.drawable.video_cover),
                    contentDescription = "" )


                Image( painter = painterResource(id = R.drawable.play),
                    contentDescription = "" , contentScale = ContentScale.Crop , modifier = Modifier.align(Alignment.Center) )
                
            }

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {

                Text(text = "Mobile App Development Beginner to Advance" , color = Color.White ,
                    fontSize = 16.sp )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "203 Lesson", fontSize = 12.sp, color = Color(0xffE2E8F0))
                    Text(text = " • ", fontSize = 22.sp, color = Color(0xffE2E8F0))
                    Text(text = "Python Programming", fontSize = 12.sp, color = Color(0xffE2E8F0))
                }

                RocketProgressbar1()


            }

            // on below line we are calling tabs

            ModuleTabs(pagerState = pagerState)
            // on below line we are calling tabs content
            // for displaying our page for each tab layout
            ModuleTabContent(pagerState = pagerState , navController)
          







        }
    }


}



@ExperimentalPagerApi
@Composable
fun ModuleTabContent(pagerState: PagerState, navController: NavHostController) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState, count = 3) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            0 -> ModuleLessonTab(navController)
            1 -> ModuleLessonTab(navController)
            2 -> ModuleLessonTab(navController)

        }
    }
}

@Composable
fun ModuleLessonTab(navController: NavHostController) {
    
    Column(modifier = Modifier.padding(top = 12.dp)) {

        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        ModuleLessonItem(navController)
        
    }
}
@Composable
fun ModuleLessonItem(navController: NavHostController) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(horizontal = 16.dp, vertical = 2.dp)
        .clickable {
            navController.navigate("planet-page")
        }
        ) {
        
        Image(painter = painterResource(id = R.drawable.vertical_divider),
            contentDescription = "",
        modifier = Modifier
            .height(58.dp)
            .padding(top = 3.dp)
        )

        Column(modifier = Modifier.padding(horizontal = 8.dp), 
            verticalArrangement = Arrangement.Top) {

            Text(text = "Basic Concept" , color = Color.White ,
                fontSize = 17.sp , fontWeight = FontWeight.W700 ,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Spacer(Modifier.height(6.dp))

            Text(text = "12 lessons" , color = Color.White ,
                fontSize = 14.sp , fontWeight = FontWeight.W400 )



        }

    }
}

@ExperimentalPagerApi
@Composable
fun ModuleTabs(pagerState: PagerState) {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list = listOf(
        "Lessons",
        "About",
        "Achievement"

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

        // on below line we are
        // specifying background color.
        backgroundColor = Color.Transparent,

        // on below line we are specifying content color.
        contentColor = Color.White,

        // on below line we are specifying
        // the indicator for the tab
        indicator = { tabPositions ->
            // on below line we are specifying the styling
            // for tab indicator by specifying height
            // and color for the tab indicator.
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        // on below line we are specifying icon
        // and text for the individual tab item
        list.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                // on below line we are specifying icon
                // for each tab item and we are calling
                // image from the list which we have created.
                // on below line we are specifying the text for
                // the each tab item and we are calling data
                // from the list which we have created.
                text = {
                    Text(
                        list[index],
                        fontSize = 12.sp,
                        // on below line we are specifying the text color
                        // for the text in that tab
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                // on below line we are specifying
                // the tab which is selected.
                selected = pagerState.currentPage == index,
                // on below line we are specifying the
                // on click for the tab which is selected.
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}








