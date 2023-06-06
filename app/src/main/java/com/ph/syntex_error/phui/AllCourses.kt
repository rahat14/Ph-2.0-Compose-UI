package com.ph.syntex_error.phui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun AllCoursePage(navController: NavHostController) {
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


            Box(modifier = Modifier){

                Row(
                    modifier = Modifier
                        .background(Color.Transparent)
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



                    Text(
                        text = " All Courses ",
                        fontSize = 14.sp,
                        color = Color(0xffFFFFFF),
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            ), fontFamily = Poppins
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))


                }
            }



            AllCourseModuleTabs(pagerState = pagerState)
            // on below line we are calling tabs content
            // for displaying our page for each tab layout
            CourseModuleTabContent(pagerState = pagerState , navController)








        }
    }



}



@ExperimentalPagerApi
@Composable
fun CourseModuleTabContent(pagerState: PagerState, navController: NavHostController) {
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

@ExperimentalPagerApi
@Composable
fun AllCourseModuleTabs(pagerState: PagerState) {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list = listOf(
        "All",
        "Trending",
        "New Courses"

    )
    // on below line we are creating
    // a variable for the scope.
    val scope = rememberCoroutineScope()

    Row(modifier = Modifier.padding(horizontal = 16.dp)) {




        Card(
            elevation = 0.dp,
            shape =  if(pagerState.currentPage == 0 ){RoundedCornerShape(8.dp)} else {RoundedCornerShape(0.dp)},
            backgroundColor = if(pagerState.currentPage == 0 ){Color(0x1AFF136F)} else {Color.Transparent},
            modifier = Modifier.clickable {
                scope.launch {
                    pagerState.animateScrollToPage(0)
                }
            }
        ) {
            Text(text = "All" , color = if(pagerState.currentPage == 0 ){Color(0xffFF136F)} else {Color(0xff475569)}  , fontSize = 17.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .background(Color.Transparent)
            )
        }

        Card(
            elevation = 0.dp,
            shape =  if(pagerState.currentPage == 1 ){RoundedCornerShape(8.dp)} else {RoundedCornerShape(0.dp)},
            backgroundColor = if(pagerState.currentPage == 1 ){Color(0x1AFF136F)} else {Color.Transparent},
            modifier = Modifier.clickable {
                scope.launch {
                    pagerState.animateScrollToPage(1)
                }
            }
            ) {
            Text(text = "Trending" , color = if(pagerState.currentPage == 1 ){Color(0xffFF136F)} else {Color(0xff475569)}  , fontSize = 17.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .background(Color.Transparent)
            )
        }



        Card(
            elevation = 0.dp,
            shape =  if(pagerState.currentPage == 2 ){RoundedCornerShape(8.dp)} else {RoundedCornerShape(0.dp)},
            backgroundColor = if(pagerState.currentPage == 2 ){Color(0x1AFF136F)} else {Color.Transparent},
            modifier = Modifier.clickable {
                scope.launch {
                    pagerState.animateScrollToPage(2)
                }
            }
            ) {
            Text(text = "New Courses" , color = if(pagerState.currentPage == 2 ){Color(0xffFF136F)} else {Color(0xff475569)}  , fontSize = 17.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .background(Color.Transparent)
            )
        }



    }

}

@Composable
fun TrendingCourseCardGridItem() {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.course_image_demo),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .height(76.dp),
                contentScale = ContentScale.Crop,

                )

            Box(
                modifier = Modifier
                    .height(100.dp)
                    .background(
                        Color(0xff521316)
                    )
            ) {

                Image(
                    painter = painterResource(id = R.drawable.backgorund_shape_coruse),
                    contentDescription = null,
                    modifier = Modifier,
                    contentScale = ContentScale.FillBounds
                )


                Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                    Text(
                        text = "Java Programming Made Easy", fontSize = 14.sp, color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "203 Lesson", fontSize = 12.sp, color = Color(0xffE2E8F0))
                        Text(text = " • ", fontSize = 22.sp, color = Color(0xffE2E8F0))
                        Text(text = "3566 Enrolled", fontSize = 12.sp, color = Color(0xffE2E8F0))
                    }
                }
            }


        }

    }
}

@Composable
fun CourseList() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(0.dp),
        userScrollEnabled = false,
        modifier = Modifier
    ) {
        items(12) {
            TrendingCourseCardGridItem()
        }

    }


}