package com.ph.syntex_error.phui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ph.syntex_error.phui.ui.theme.Poppins


@Composable
fun PlanetPage(navController: NavHostController) {

    Box {
        Image(

            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )
        Column(modifier = Modifier) {

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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xff0F172A))
                    .padding(8.dp)
            ) {

                Text(
                    text = "Python Day One", fontSize = 18.sp,
                    fontWeight = FontWeight.W700, color = Color.White
                )

                Text(
                    text = "Python In One night ", fontSize = 14.sp,
                    fontWeight = FontWeight.W400, color = Color(0xff475569)
                )
            }




            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                PlanetItem(isSat = true , navController = navController )
                PlanetItem(isActive = true ,navController =  navController)
                PlanetItem(navController = navController)
                PlanetItem(navController = navController)
                PlanetItem(navController = navController)


            }


        }
    }


}

@Composable
fun PlanetItem(isActive: Boolean = false, isSat: Boolean = false , navController: NavHostController) {

    Row(modifier = Modifier
        .clickable {
            navController.navigate("video-page")

        }
        .padding(vertical = 8.dp, horizontal = 16.dp)) {


        if (isActive) {
            
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.space_man),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 40.dp, start = 16.dp),

                )
        }

        if (!isSat && !isActive) {

            Spacer(modifier = Modifier.width(20.dp))


        }


        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            val colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })



            Image(
                painter = painterResource(id = R.drawable.planet_),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(140.dp),
                colorFilter = if (isSat) {
                    colorFilter
                } else {
                    null
                }

            )


            Text(
                text = "2. Output", fontSize = 16.sp,
                fontWeight = FontWeight.W400, color = Color.White
            )


            Text(
                text = "(06 Content)", fontSize = 12.sp,
                fontWeight = FontWeight.W400, color = Color(0xff94A3B8)
            )

        }


    }


}


@Composable
fun VideoCourseDetails(

) {

    Box {
        Image(

            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )
        Column(modifier = Modifier) {

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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xff0F172A))
                    .padding(8.dp)
            ) {

                Text(
                    text = "Python Day One", fontSize = 18.sp,
                    fontWeight = FontWeight.W700, color = Color.White
                )

                Text(
                    text = "Python In One night ", fontSize = 14.sp,
                    fontWeight = FontWeight.W400, color = Color(0xff475569)
                )
            }


            Box(modifier = Modifier.height(220.dp)) {

                Image(
                    painter = painterResource(id = R.drawable.video_cover),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                        .height(210.dp)
                )


                Image(
                    painter = painterResource(id = R.drawable.player_play),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.align(Alignment.Center)
                )

            }



            Column(modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 0.dp
                )
                .verticalScroll(rememberScrollState())) {

                VideoItem()
                VideoItem()
                VideoItem()
                VideoItem()
                VideoItem()
                VideoItem()
                VideoItem()
                VideoItem()


            }


        }
    }


}

@Composable
fun VideoItem() {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xff195075),
        modifier = Modifier.padding(vertical = 5.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxSize()

                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xff202354),
                            Color(0xff195075),

                            )
                    )
                )
                .padding(8.dp)
               ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.video_item_icon ), contentDescription = "",
                modifier = Modifier.size(42.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 8.dp
                    )
                    .weight(
                        weight = 1f,
                        fill = true
                    )
            ) {

                Text(text = "2. VS Code Install", color = Color.White, fontSize = 16.sp)

                GradientProgressbar1(yellowEffect = true)

            }


            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.btn_play_lock),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .size(32.dp)
                )


            }

        }

    }
}
