package com.ph.syntex_error.phui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.ph.syntex_error.phui.ui.theme.Poppins
import com.ph.syntex_error.phui.ui.theme.cardBackgroundColor
import com.ph.syntex_error.phui.ui.theme.textInActiveColor
import kotlinx.coroutines.launch

@Composable
fun HomePage(navController: NavHostController) {
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
                    painter = painterResource(id = R.drawable.ph_logo), contentDescription = "",
                    modifier = Modifier
                        .height((27.4).dp)
                        .width(31.dp)
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
                    )
                    {
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
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = ""
                )

            }


            Row(
                modifier = Modifier.fillMaxWidth()
                    .clickable {
                    navController.navigate("search-page")

                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color(0xff0F172A)
                ) {

                    Row(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.saerch),
                            contentDescription = ""
                        )
                        Text(
                            text = "Find Courses", color = Color(0xff64748B), fontSize = 14.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                    }


                }


                Card(
                    modifier = Modifier.padding(16.dp),
                    shape = RoundedCornerShape(6.dp),
                    backgroundColor = Color(0xff0F172A)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.bi_filter),
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp)
                    )


                }
            }

            Row(modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp)) {
                Text(
                    text = "My Courses",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "View All", fontSize = 14.sp, color = Color(0xff94A3B8)
                )
            }

            MyCourseHorizontal()

            VideoCourseContainer(navController)

            TrendingCourseContainer()

            UpcomingCourseContainer()

            ShortCourseContainer()


            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                backgroundColor = Color(0xffD80F5D)

            ) {


                Row(
                    modifier =
                    Modifier
                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                        .background(Color(0xffFF136F))
                        .padding(10.dp)
                        .clip(RoundedCornerShape(6.dp)),

                    horizontalArrangement = Arrangement.Center

                ) {

                    Text(
                        text = "Explore all courses",
                        fontSize = 16.sp,
                        color = Color(0xffE2E8F0)
                    )


                }


            }


        }
    }


}

@Composable
fun VideoCourseContainer(navController: NavHostController) {
    Column(modifier = Modifier
        .clickable {
            navController.navigate("module-page")

        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            Text(
                text = "Video Courses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "View All", fontSize = 14.sp, color = Color(0xff94A3B8)
            )
        }


        Row(
            modifier = Modifier.horizontalScroll(
                rememberScrollState()
            )
        ) {

            TrendingCourseCard()
            TrendingCourseCard()
            TrendingCourseCard()
            TrendingCourseCard()
            TrendingCourseCard()

        }

        Image(painter = painterResource(id = R.drawable.scroll_indicator),
            contentDescription = "" , modifier = Modifier.padding(top = 13.dp , bottom = 4.dp) )



    }
}

@Composable
fun TrendingCourseContainer() {
    Column(modifier = Modifier.padding(horizontal = 0.dp) ,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Row(modifier = Modifier.padding(vertical = 8.dp , horizontal = 16.dp)) {
            Text(
                text = "Trending Courses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "View All", fontSize = 14.sp, color = Color(0xff94A3B8)
            )
        }


        Row(
            modifier = Modifier.horizontalScroll(
                rememberScrollState()
            )
        ) {

            TrendingCourseCard()
            TrendingCourseCard()
            TrendingCourseCard()
            TrendingCourseCard()
            TrendingCourseCard()

        }

        Image(painter = painterResource(id = R.drawable.scroll_indicator),
            contentDescription = "" , modifier = Modifier.padding(top = 13.dp , bottom = 4.dp) )



    }
}

@Composable
fun UpcomingCourseContainer() {
    Column(modifier = Modifier.padding(0.dp)
    , horizontalAlignment = Alignment.CenterHorizontally) {

        Row(modifier = Modifier.padding(vertical = 8.dp , horizontal = 16.dp)) {
            Text(
                text = "Upcoming Courses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "View All", fontSize = 14.sp, color = Color(0xff94A3B8)
            )
        }


        Row(
            modifier = Modifier.horizontalScroll(
                rememberScrollState()
            )
        ) {

            UpcomingCourseCard()
            UpcomingCourseCard()
            UpcomingCourseCard()
            UpcomingCourseCard()
            UpcomingCourseCard()

        }


        Image(painter = painterResource(id = R.drawable.scroll_indicator),
            contentDescription = "" , modifier = Modifier.padding(top = 13.dp , bottom = 4.dp) )


    }
}

@Composable
fun ShortCourseContainer() {
    Column(modifier = Modifier.padding(0.dp)) {

        Row(modifier = Modifier.padding(vertical = 8.dp , horizontal = 16.dp)) {
            Text(
                text = "Short Courses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "View All", fontSize = 14.sp, color = Color(0xff94A3B8)
            )
        }


        Row(
            modifier = Modifier.horizontalScroll(
                rememberScrollState()
            )
        ) {

            ShortCourseCard()
            ShortCourseCard()
            ShortCourseCard()
            ShortCourseCard()
            ShortCourseCard()

        }


    }
}


@Composable
fun TrendingCourseCard() {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)

    ) {

        Column(
            modifier = Modifier
                .width(220.dp)
        ) {

            Box(modifier = Modifier.height(120.dp)) {




                Image(
                    painter = painterResource(id = R.drawable.course_image_demo),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp)
                        )
                        .height(120.dp),
                    contentScale = ContentScale.Crop,

                    )


                Image(
                    painter = painterResource(id = R.drawable.pro_badge),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                    ,
                    contentScale = ContentScale.Crop,

                    )


            }



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
fun UpcomingCourseCard(isOnGrid: Boolean = false ) {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp)

    ) {
        val modifier : Modifier = Modifier.width(220.dp)

        if(isOnGrid){
            modifier.fillMaxWidth()
        }

        Column(
            modifier = modifier

        ) {

            Image(
                painter = painterResource(id = R.drawable.upcoming_course_demo),
                contentDescription = null,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp)
                    )
                    .height(if(isOnGrid){80.dp}else {120.dp}),
                contentScale = ContentScale.Crop,

                )

            Box(
                modifier = Modifier
                    .height(if(isOnGrid){60.dp}else {100.dp})
                    .background(
                        Color(0xff2E7EDC)
                    )
            ) {

                Image(
                    painter = painterResource(id = R.drawable.backgorund_shape_coruse),
                    contentDescription = null,
                    modifier = Modifier,
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.tint(Color(0xff00D1FF))
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
fun ShortCourseCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(
            horizontal = 4.dp, vertical = 2.dp
        )

    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xff4289FF),
                            Color(0xff01FDD6),
                        )
                    )
                )
        ) {

            Column(
                modifier = Modifier
                    .padding(1.dp)
                    .clip(RoundedCornerShape(7.dp))
            ) {

                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xff0A051D),
                                    Color(0xff190D4C),
                                )
                            )
                        )
                ) {


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.image_4),
                            contentDescription = null,
                            modifier = Modifier.size(33.dp),
                            contentScale = ContentScale.FillBounds
                        )

                        Spacer(modifier = Modifier.size(8.dp))

                        Text(
                            text = "HTML\nCourse",
                            fontSize = 16.sp,
                            color = Color(0xffE2E8F0)
                        )

                    }

                }


            }

        }


    }
}


@Composable
fun MyCourseHorizontal() {

    Card(
        backgroundColor = cardBackgroundColor, modifier = Modifier.padding(horizontal = 12.dp ,
            vertical = 9.dp),

        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(cardBackgroundColor)
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ) {

            Row(
                verticalAlignment = Alignment.Top,
            ) {


                Text(
                    text = "Python Programming Beginners to Advance",
                    color = Color(0xffCBD5E1), fontSize = 12.sp,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),

                    )





                Spacer(modifier = Modifier.weight(1f))


                Image(
                    painter = painterResource(id = R.drawable.carbon_overflow_menu_vertical),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White)


                )

            }

            Text(
                text = "Fundamentals",
                color = Color.White,
                fontSize = 16.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Text(
                text = "Lesson 2/10",
                color = Color(0xffCBD5E1),
                fontSize = 12.sp,
                modifier = Modifier.padding(vertical = 5.dp)
            )

            RocketProgressbar1()


        }
    }


}

@Composable
fun RocketProgressbar1(
    indicatorHeight: Dp = 8.dp,
    backgroundIndicatorColor: Color = Color.Black.copy(alpha = 0.2f),
    indicatorPadding: Dp = 8.dp,
    gradientColors: List<Color> = listOf(
        Color(0xFF9CDBFF),
        Color(0xFF9CDBFF),
        Color(0xFF9CDBFF),
        Color(0xFF9CDBFF),

        ),
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    val downloadedPercentage = 50f

    val animateNumber = animateFloatAsState(
        targetValue = downloadedPercentage, animationSpec = tween(
            durationMillis = animationDuration, delayMillis = animationDelay
        )
    )

//    LaunchedEffect(Unit) {
//        viewModel.startThreadGradient()
//    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        Canvas(modifier = Modifier.fillMaxSize()) {
//            drawLine(
//                color = Color.Red,
//                start = Offset(0f, size.height / 2),
//                end = Offset(size.width, size.height / 2),
//                strokeWidth = 10f,
//                cap = StrokeCap.Round,
//                pathEffect = PathEffect.cornerPathEffect(50f)
//            )
//        }
//        Canvas(modifier = Modifier.fillMaxSize()) {
//            drawLine(
//                color = Color.Red.copy(alpha = 0.5f),
//                start = Offset(0f, size.height / 2),
//                end = Offset(size.width, size.height / 2),
//                strokeWidth = 60f,
//                cap = StrokeCap.Round,
//                pathEffect = PathEffect.cornerPathEffect(100f)
//            )
//        }
//    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.height(20.dp)
    ) {
        val option = BitmapFactory.Options()
        option.apply {
            inPreferredConfig = Bitmap.Config.ARGB_8888
        }

        val imageBitmapp = BitmapFactory.decodeResource(
            LocalContext.current.resources, R.drawable.startup1, option
        )

        val LD = LocalDensity.current

        val platfrom_width = LD.run { 35.dp.toPx() }
        val platfrom_height = LD.run { 30.dp.toPx() }

        val imageBitmap = Bitmap.createScaledBitmap(
            imageBitmapp, platfrom_width.toInt(), platfrom_height.toInt(), true
        ).asImageBitmap()




        Canvas(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(indicatorHeight)
                .padding(horizontal = indicatorPadding)

        ) {


            val gradient = Brush.radialGradient(
                listOf(Color.Red.copy(.3f), Color.Red, Color.Red.copy(.3f)),
                center = Offset(300f, 300f),
                radius = 500f
            )

//            drawLine(
//                color = Color.Red.copy(alpha = 0.5f),
//                start = Offset(0f, size.height / 2),
//                end = Offset(size.width, size.height / 2),
//                strokeWidth = 60f,
//                cap = StrokeCap.Round,
//                pathEffect = PathEffect.cornerPathEffect(100f)
//            )

            // Background indicator
            drawLine(
                color = backgroundIndicatorColor,
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = size.width, y = size.height / 2)
            )


            // Convert the downloaded percentage into progress (width of foreground indicator)
            val progress =
                (animateNumber.value / 100) * size.width // size.width returns the width of the canvas

            // Foreground indicator
//            brush = Brush.linearGradient(
//                colors = gradientColors, start = Offset(0f, 0f)
//            ),

            drawLine(
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = progress, y = size.height / 2),
                color =  Color(0xff99D7FF)
            )
            val center = Offset(size.width / 2, size.height / 2)

            val gradientPaint = Paint().apply {
                style = PaintingStyle.Fill
                shader = RadialGradientShader(
                    center, center.y,
                    colors = listOf(Color.Red, Color.Transparent),
                    tileMode = TileMode.Clamp
                )
            }


            //        }
//        Canvas(modifier = Modifier.fillMaxSize()) {
//            drawLine(
//                color = Color.Red.copy(alpha = 0.5f),
//                start = Offset(0f, size.height / 2),
//                end = Offset(size.width, size.height / 2),
//                strokeWidth = 60f,
//                cap = StrokeCap.Round,
//                pathEffect = PathEffect.cornerPathEffect(100f)
//            )
//        }
//    }


            drawImage(
                image = imageBitmap, topLeft = Offset(
                    x = progress - 50,
                    y = -((size.height / 2) + 20)
                )

            )


        }
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = downloadedPercentage.toInt().toString() + "%",
            color = Color.White,
        )




    }


}


@Composable
fun ContentPage() {

    Column(modifier = Modifier.background(Color.White)) {

        Column(
            modifier = Modifier
                .background(Color(0xff0F172A))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .background(Color(0xff0F172A))
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ph_logo), contentDescription = "",
                    modifier = Modifier
                        .height((27.4).dp)
                        .width(31.dp)
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
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = ""
                )

            }

            Text(
                text = "Data Structure",
                fontWeight = FontWeight.W700,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 12.dp),
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Python Programming", fontSize = 14.sp, color = textInActiveColor
                )
                Text(
                    text = "  ⬤  ", fontSize = 5.sp, color = textInActiveColor
                )
                Text(
                    text = "Basic Concept", fontSize = 14.sp, color = textInActiveColor
                )
            }

        }


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Data Structure",
                fontSize = 16.sp,
                color = Color.Black,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )


            Card(shape = RoundedCornerShape(4.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fi_sr_volume_1),
                        contentDescription = ""
                    )

                    Text(
                        text = " Audio",
                        fontSize = 14.sp,
                        color = Color.Black,
                    )

                }


            }


        }


        Text(
            text = "Long Taksndfgokas mndkmasd mfas;dmf kasmd maskdfmka sdm", fontSize = 14.sp
        )


        Image(
            painter = painterResource(id = R.drawable.profile_card_background),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp)),
        )

        SingleOptions()

    }


}


@Composable
fun SingleOptions() {
    Card(
        shape = RoundedCornerShape(17.dp), backgroundColor = Color(0xff0F172A)

    ) {
        Row() {

            DashedDivider(
                color = Color.White,
                thickness = 12.dp,
                modifier = Modifier
                    .height(80.dp)
                    .padding(start = 12.dp)

            )

            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Decision Making",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = "9/9",
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color(0xffB8B8B8)
                )



                RatingBar()


            }


        }
    }

}


@Composable
fun DashedDivider(
    thickness: Dp = 22.dp,
    color: Color = Color.White,
    phase: Float = 110f,
    intervals: FloatArray = floatArrayOf(25f, 45f),
    modifier: Modifier
) {
    Canvas(
        modifier = modifier
    ) {
        val dividerHeight = thickness.toPx()
        drawRoundRect(

            color = color,
            style = Stroke(
                width = dividerHeight,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = intervals,
                    phase = phase
                )
            ),
            cornerRadius = CornerRadius(x = 12f, y = 12f)
        )
    }
}

@Composable
fun RatingBar(TotalStart: Int = 5, rate: Int = 3) {
    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        for (i in 1..5) {
            var imagepainter = painterResource(id = R.drawable.star_active)

            imagepainter = if (i <= rate) {
                painterResource(id = R.drawable.star_active)
            } else {
                painterResource(id = R.drawable.star__inactive)
            }

            Image(painter = imagepainter, contentDescription = "")
        }

    }

}


@Composable
fun MyCoursePage() {
    Column() {


        TabLayout()


    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {

    // on below line we are creating variable for pager state.
    val pagerState = rememberPagerState(initialPage = 0)

    // on below line we are creating a column for our widgets.
    Column(
        // for column we are specifying modifier on below line.
        modifier = Modifier.background(Color.White)
    ) {
        // on the below line we are specifying the top app bar
        // and specifying background color for it.
        TopAppBar(backgroundColor = Color(0xff0F172A)) {
            // on below line we are specifying a column
            // for our text view to display a text
            // in our top app bar.
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                // on below line we are providing alignment for our
                // column to center of our top app bar.

                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                // on below line we are specifying a text and
                // specifying a text as "Tab Layout Example"
                Text(
                    text = "My Courses",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        // on below line we are calling tabs
        Tabs(pagerState = pagerState)
        // on below line we are calling tabs content
        // for displaying our page for each tab layout
        TabsContent(pagerState = pagerState)
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list = listOf(
        "Ongoing",
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
        backgroundColor = Color(0xff0F172A),

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

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState, count = 2) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            0 -> OnGoingTab()
            1 -> AchievementTab()

        }
    }
}


@ExperimentalPagerApi
@Composable
fun OnGoingTab() {


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(
                id = R.drawable.home_bg
            ),

            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )




        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()

                )
        ) {

            MyCourseHorizontal()
            MyCourseHorizontal()
            MyCourseHorizontal()

        }


    }


}

@ExperimentalPagerApi
@Composable
fun AchievementTab() {


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(
                id = R.drawable.home_bg
            ),

            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )




        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()

                )
        ) {

            CertificateItem()
            CertificateItem()
            CertificateItem()

        }


    }


}