package com.ph.syntex_error.phui


import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.decode.VideoFrameDecoder
import coil.request.ImageRequest
import coil.request.videoFrameMillis
import com.ph.syntex_error.phui.auth.LoginScreen
import com.ph.syntex_error.phui.auth.WelcomeScreen
import com.ph.syntex_error.phui.reels.ReelCameraPreview
import com.ph.syntex_error.phui.reels.ReelCreatePage
import com.ph.syntex_error.phui.reels.ReelGridItem
import com.ph.syntex_error.phui.reels.ReelHomePage
import com.ph.syntex_error.phui.reels.ReelListPage
import com.ph.syntex_error.phui.ui.theme.PHUITheme
import com.ph.syntex_error.phui.ui.theme.Poppins
import com.ph.syntex_error.phui.ui.theme.profileBackgroundColor
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //   WindowCompat.setDecorFitsSystemWindows(window, true )
        setContent {
            PHUITheme {

                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                //VideoCourseDetails()
                // AllCoursePage(navController)
              //  ReelListPage(null)
                //  HomePageScreen(navController = navController)
              //  ReelCreatePage()

            //   ReelHomePage(navController = navController)
                // BadgePage()

                var context = LocalContext.current

                val imageLoader = ImageLoader
                    .Builder(context)

                    .components {
                        add(VideoFrameDecoder.Factory())

                    }

                    .build()

                var readable = ImageRequest.Builder(context)
                    .data("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4")
                    .videoFrameMillis(25000)
                    .build()

              



            }
        }
    }
}



@Composable
fun HomePageScreen(navController: NavHostController) {

    Scaffold(

        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = profileBackgroundColor ,// Set background color to avoid the white flashing when you switch between screens
        //  bottomBar = { BottomNavigationBar(navController) },
    )

}


@Composable
fun ProfilePage(navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(profileBackgroundColor)
    ) {
        // top bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(10.dp),

            ) {

            Text(
                text = "Profile", style = MaterialTheme.typography.h1.copy(
                    fontSize = 18.sp, color = Color.White
                )
            )

            Spacer(Modifier.weight(1.0f))

            Card(backgroundColor = Color(0xff1E293B)) {
                Row(modifier = Modifier.padding(6.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.gear_icon),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(4.dp))

                    Text(
                        text = "Settings ", style = TextStyle(
                            fontSize = 14.sp, color = Color.White
                        )
                    )

                }
            }

        }

        Divider(
            color = Color(0xff1E293B), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        ProfileCard()
        profileComplete()

        ProfileAcivmentCard()

        LiveSupportContainer(navController)

        AchievementCard(navController)

        SavedContainer(navController)

        FriendsContainer(navController)

        InviteFriendContainer()

    }
}

@Composable
fun ProfileAcivmentCard() {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(0.dp),
        userScrollEnabled = false,
        modifier = Modifier
            .height(280.dp)
            .padding(12.dp)
    ) {
        items(4) { item ->
            OptionMenu()
        }
    }

}

@Composable
fun profileComplete() {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp,
        backgroundColor = Color(0xFF271526).compositeOver(Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = "",
                Modifier
                    .padding(12.dp)
                    .size(12.dp)
                    .align(Alignment.TopEnd)
            )

        }



        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text(
                text = "Profile Completeness", style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontFamily = Poppins
                )
            )

            Spacer(Modifier.height(10.dp))
            GradientProgressbar1()
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Complete Profile",
                style = TextStyle(
                    fontSize = 14.sp, color = Color(0xffFF136F)
                ),
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins,
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline,
                    )
                )
            )


        }


    }

}

@Composable
fun ProfileCard() {
    Card(
        backgroundColor = Color.Transparent,

        elevation = 4.dp,
        modifier = Modifier.padding(18.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_card_background),
            contentDescription = "profile card",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Box(modifier = Modifier.fillMaxWidth()) {

            Image(
                painter = painterResource(id = R.drawable.edit_profile),
                contentDescription = "profile card",
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
                    .align(Alignment.TopEnd)
            )
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()

        ) {

            Spacer(modifier = Modifier.height(26.dp))

            Box(modifier = Modifier.dashedBorder(2.dp, 45.dp, Color.Red)) {
                Image(
                    painter = painterResource(id = R.drawable.profile_demo),
                    contentDescription = "",
                    Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                )
            }


            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Zahid Hossain", style = TextStyle(
                        fontWeight = FontWeight.W500,
                        fontSize = 17.sp,
                        color = Color.White,
                        fontFamily = Poppins
                    )
                )

                Spacer(modifier = Modifier.width(6.dp))

                Image(
                    painter = painterResource(id = R.drawable.verified),
                    contentDescription = "",
                    modifier = Modifier.size(22.dp)
                )

            }

            Text(text = "Number Hero", color = Color(0xff94A3B8))


            Spacer(modifier = Modifier.width(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "123", style = TextStyle(
                        fontWeight = FontWeight.W600, color = Color.White, fontFamily = Poppins
                    )
                )

                Text(text = " Followers", color = Color(0xff94A3B8))
                Spacer(modifier = Modifier.width(10.dp))

                Divider(
                    color = Color(0xff64748B), modifier = Modifier
                        .height(12.dp)
                        .width(1.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "23", style = TextStyle(
                        fontWeight = FontWeight.W600, color = Color.White, fontFamily = Poppins
                    )
                )

                Text(text = " Following", color = Color(0xff94A3B8))

            }

        }

    }

}

@Composable
fun OptionMenu() {
    Card(
        backgroundColor = Color(0xff1E293B),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 8.dp),
        shape = RoundedCornerShape(10.dp),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.diamond_2), contentDescription = "")

            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "130", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White
            )

            Text(
                text = "Days Streak",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(
                    0xff64748B
                )
            )

        }

    }

}

@Composable
fun LiveSupportContainer(navController: NavHostController) {
    Card(
        backgroundColor = Color(0xff1E293B),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Card(
                backgroundColor = Color(0xfFFC3F3F), modifier = Modifier
                    .padding(4.dp)
                    .size(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.radio_1),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                )
            }

            Text(text = " Live Support", color = Color.White)

            Spacer(modifier = Modifier.weight(1f))
            Card(backgroundColor = Color(0xFFFF136F), modifier = Modifier.clickable(onClick = {

                navController.navigate("gem-store") {
                    launchSingleTop = true
                }

            })) {

                Row(
                    Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = " Go ", color = Color.White)
                    Image(
                        painter = painterResource(id = R.drawable.avater),
                        contentDescription = "",
                        modifier = Modifier
                    )
                }

            }

        }

    }

}

@Composable
fun GradientProgressbar1(
    yellowEffect: Boolean = true,
    indicatorHeight: Dp = 8.dp,
    backgroundIndicatorColor: Color = Color.Black.copy(alpha = 0.2f),
    indicatorPadding: Dp = 8.dp,
    gradientColors: List<Color> = listOf(
        Color(0xFFFFCC3E),
        Color(0xFFF79C41),
        Color(0xFFFFCC3E),
        Color(0xFFF79C41),

        ),
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    downloadedPercentage: Float = 0f
) {


    val animateNumber = animateFloatAsState(
        targetValue = downloadedPercentage, animationSpec = tween(
            durationMillis = animationDuration, delayMillis = animationDelay
        )
    )

//    LaunchedEffect(Unit) {
//        viewModel.startThreadGradient()
//    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.height(20.dp)
    ) {


        Canvas(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(indicatorHeight)
                .padding(horizontal = indicatorPadding)
        ) {

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
            drawLine(
                brush = Brush.linearGradient(
                    colors = gradientColors, start = Offset(0f, 0f)
                ),
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = progress, y = size.height / 2)
            )

            if (yellowEffect) {

                drawLine(
                    color = Color(0xffFCD34D),
                    cap = StrokeCap.Round,
                    strokeWidth = 8.48f,
                    start = Offset(x = 0f * 0.8f, y = size.height / 3),
                    end = Offset(x = (progress - 12), y = size.height / 3)
                )

            }


        }
        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = downloadedPercentage.toInt().toString() + "%",
            color = Color.White,
        )


    }


}

@Composable
fun AchievementCard(navController: NavHostController) {

    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(horizontal = 16.dp)) {

        Text(
            text = "Achievement",
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(8.dp))

        Card(
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xFF1E293B),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column {
                AchievementItem(title = "Badges", navController, route = "badge-page")
                AchievementItem(title = "Certificate", navController, route = "certificate-page")
                AchievementItem(
                    title = "Leaderboard",
                    isLast = true,
                    navController = navController,
                    route = "leaderboard-page"
                )
            }

        }

    }

}

@Composable
fun AchievementItem(
    title: String = "Badges",
    navController: NavHostController,
    isLast: Boolean = false,
    route: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate(route) {
                    launchSingleTop = true
                }
            }, verticalAlignment = Alignment.CenterVertically
    ) {

        Card(
            backgroundColor = Color(0xFF0F172A),
            modifier = Modifier,
            shape = RoundedCornerShape(7.dp),
        ) {

            Image(
                painter = painterResource(id = R.drawable.award__1__1),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(vertical = 14.dp, horizontal = 12.dp)
                    .size(30.dp)
            )

        }
        Spacer(modifier = Modifier.size(12.dp))
        Column {

            Text(
                text = title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.W400
            )
            Text(
                text = "Tap to see your all ",
                color = Color(0xff94A3B8),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.size(12.dp))


            if (!isLast) {
                Divider(
                    thickness = 0.5.dp, modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .background(
                            brush = Brush.linearGradient(

                                colors = listOf(
                                    Color(0xff334155),
                                    Color(0xffD9D9D9),
                                    Color(0xffD9D9D9),
                                    Color(0xff334155),
                                ),


                                )
                        )
                )
            }


        }


    }
}

@Composable
fun SavedContainer(navController: NavHostController) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Saved",
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val modifier = Modifier
            SavedCard("Bookmarks", R.drawable.bookmarks_1, navController)

            SavedCard("My Concepts", R.drawable.my_concepts, navController)
        }

    }

}

@Composable
fun SavedCard(name: String, icon: Int, navController: NavHostController) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp - 45.dp


    Card(
        backgroundColor = Color(0xff1E293B),
        modifier = Modifier
            .width(screenWidth / 2)
            .padding(end = 8.dp)
            .clickable {
                navController.navigate("bookmark-page") {
                    launchSingleTop = true
                }

            },
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.size(8.dp))

            Image(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .size(60.dp)
            )

            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                color = Color.White,
            )

            Spacer(modifier = Modifier.size(8.dp))

        }


    }


}

@Composable
fun InviteFriendContainer() {

    Card(
        backgroundColor = Color(0xFF1E293B),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    )


    {

        Row(
            modifier = Modifier
                .dashedBorder(width = 1.dp, color = Color(0xff64748B), radius = 8.dp)
                .padding(8.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.people),
                contentDescription = "",
                Modifier
                    .padding(horizontal = 8.dp, vertical = 12.dp)
                    .size(66.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 18.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Invite Friends", style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontFamily = Poppins
                    )
                )
                Text(
                    text = "Learn coding with your friends",
                    color = Color(0xff94A3B8),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 12.dp)
                )


                Card(
                    shape = RoundedCornerShape(5.dp),
                    elevation = 4.dp,
                    backgroundColor = Color(0xffFF136F),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {

                    Text(
                        text = "Invite Friends",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                        fontSize = 14.sp
                    )

                }

            }

        }


    }

}


@Composable
fun FriendsContainer(navController: NavHostController) {

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Friends",
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = Color.White
            )

            Text(text = "View All",
                color = Color(0xff94A3B8),
                fontSize = 11.sp,
                modifier = Modifier.clickable {
                    navController.navigate("friend-page") {
                        launchSingleTop = true
                    }
                })
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {

            FriendsCard(isFollow = true)
            FriendsCard()
            FriendsCard()
            FriendsCard()
            FriendsCard()
            FriendsCard()

        }

    }

}


fun Modifier.dashedBorder(width: Dp, radius: Dp, color: Color) = drawBehind {
    drawIntoCanvas {
        val paint = Paint().apply {
            strokeWidth = width.toPx()
            this.color = color
            style = PaintingStyle.Stroke
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 30f), 0f)
        }
        it.drawRoundRect(
            width.toPx(),
            width.toPx(),
            size.width - width.toPx(),
            size.height - width.toPx(),
            radius.toPx(),
            radius.toPx(),
            paint
        )
    }
}

@Composable
fun PremiumCourses() {

    AnimatedVisibility(visible = true) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.premium_course_bg),
                contentDescription = "profile card",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()

            )


            Box(
                modifier = Modifier.fillMaxWidth()


            ) {

                Image(
                    painter = painterResource(id = R.drawable.ballon_astronut),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(110.dp)
                        .padding(top = 4.dp),
                    contentScale = ContentScale.Crop
                )

            }
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Unlock Premium Courses",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600
                )
                Text(
                    text = "Get ready to know more\n" + "And get more premium courses",
                    color = Color(0xFF94A3B8),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W400
                )

                Button(
                    onClick = {

                    }, colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xff2D7D46),
                        contentColor = Color(0xff2D7D46),
                        disabledBackgroundColor = Color(0xff2D7D46),
                        disabledContentColor = Color(0xff2D7D46)
                    ), modifier = Modifier.padding(top = 8.dp)
                ) {

                    Text(text = "Upgrade to Pro", color = Color.White, fontSize = 16.sp)

                }
            }


        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PHUITheme {

        Column() {
            GradientProgressbar1(downloadedPercentage = -10f)
        }

    }
}