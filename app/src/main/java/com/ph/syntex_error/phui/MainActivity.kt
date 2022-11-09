package com.ph.syntex_error.phui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*



import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.ui.theme.PHUITheme
import com.ph.syntex_error.phui.ui.theme.Poppins
import com.ph.syntex_error.phui.ui.theme.profileBackgroundColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PHUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = profileBackgroundColor
                ) {
                    ProfilePage()
                }
            }
        }
    }
}


@Composable
fun ProfilePage() {

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
                        painter = painterResource(id = R.drawable.settings),
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

        LiveSupportContainer()

        AchievementCard()

        SavedContainer()

        FriendsContainer()

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
                    fontSize = 15.sp, color = Color(0xffFF136F)
                ),
                fontWeight = FontWeight.Medium,
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
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.profile_demo),
                contentDescription = "",
                Modifier.size(90.dp)
            )

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
fun LiveSupportContainer() {
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
            Card(backgroundColor = Color(0xFFFF136F), modifier = Modifier) {

                Row(
                    Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = " Go ", color = Color.White)
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
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
    animationDelay: Int = 0
) {
    val downloadedPercentage = 20f

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


        }
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = downloadedPercentage.toInt().toString() + "%",
            color = Color.White,
        )


    }


}

@Composable
fun AchievementCard() {

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
                AchievementItem()

                AchievementItem()
                AchievementItem(true)
            }

        }

    }

}

@Composable
fun AchievementItem(isLast: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
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
                    .padding(vertical = 16.dp, horizontal = 12.dp)
                    .size(40.dp)
            )

        }
        Spacer(modifier = Modifier.size(12.dp))
        Column {

            Text(
                text = "Badges", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.W400
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
fun SavedContainer() {

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
            SavedCard("Bookmarks", R.drawable.bookmarks_1)

            SavedCard("My Concepts", R.drawable.my_concepts)
        }

    }

}

@Composable
fun SavedCard(name: String, icon: Int) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp - 45.dp


    Card(
        backgroundColor = Color(0xff1E293B), modifier = Modifier
            .width(screenWidth / 2)
            .padding(end = 8.dp), shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.size(8.dp))

            Image(
                painter = painterResource(id = icon), contentDescription = "", modifier = Modifier
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
fun  InviteFriendContainer(){

    Card(backgroundColor = Color(0xFF1E293B), modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp) ,
        shape = RoundedCornerShape(8.dp)
       )


    {

        Row(modifier = Modifier .dashedBorder(width = 1.dp, color = Color(0xff64748B), radius = 8.dp).padding(8.dp)) {

            Image(painter = painterResource(id = R.drawable.people), contentDescription = "" , Modifier.padding(horizontal = 8.dp , vertical = 12.dp).size(66.dp) )

            Spacer(modifier = Modifier.weight(1f))

            Column (modifier =  Modifier.padding(vertical = 8.dp , horizontal = 18.dp) , horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Invite Friends", style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontFamily = Poppins
                    )
                )
                Text(text = "Learn coding with your friends", color = Color(0xff94A3B8) , fontSize = 14.sp , modifier = Modifier.padding(end = 12.dp))


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
                        modifier = Modifier
                            .padding(vertical = 4.dp  , horizontal = 8.dp),
                        fontSize = 14.sp
                    )

                }

            }

        }


    }

}


@Composable
fun FriendsContainer() {

    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Friends",
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = Color.White
            )

            Text(text = "View All", color = Color(0xff94A3B8), fontSize = 11.sp)
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


fun Modifier.dashedBorder(width: Dp, radius: Dp, color: Color) =
    drawBehind {
        drawIntoCanvas {
            val paint = Paint()
                .apply {
                    strokeWidth = width.toPx()
                    this.color = color
                    style = PaintingStyle.Stroke
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
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
fun FriendsCard(isFollow: Boolean = false) {

    Card(backgroundColor = Color(0xFF1E293B), border = BorderStroke(1.dp, Color(0xff334155)), modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 6.dp)) {

        Box(modifier = Modifier.width(130.dp)) {

            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = "",
                Modifier
                    .padding(12.dp)
                    .size(12.dp)
                    .align(Alignment.TopEnd)
            )

        }


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 8.dp  , horizontal = 6.dp)
        ) {
            Spacer(modifier = Modifier.size(4.dp))
            Image(
                painter = painterResource(id = R.drawable.avater),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "Zahid Hasan",
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Color.White,
                modifier =
                Modifier
                    .width(60.dp)
                    .padding(top = 6.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.size(4.dp))
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.small_diamod),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = (2.5).dp)
                        .size(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "220",
                    color = Color(0xff94A3B8),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600
                )


            }

            if(isFollow){
                Card(
                    shape = RoundedCornerShape(5.dp),
                    elevation = 0.dp,
                    backgroundColor = Color(0xff0F172A),
                    modifier = Modifier.padding(horizontal = 18.dp, vertical = 6.dp)
                ) {

                    Text(
                        text = "Following",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(4.dp)
                            .width(80.dp),
                        fontSize = 10.sp
                    )

                }
            }else{
                Card(
                    shape = RoundedCornerShape(5.dp),
                    elevation = 4.dp,
                    backgroundColor = Color(0xffFF136F),
                    modifier = Modifier.padding(horizontal = 18.dp, vertical = 6.dp)
                ) {

                    Text(
                        text = "Follow",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(4.dp)
                            .width(80.dp),
                        fontSize = 10.sp
                    )

                }
            }

        }


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PHUITheme {
        ProfilePage()
    }
}