package com.ph.syntex_error.phui.reels

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.PHUITheme
import com.ph.syntex_error.phui.ui.theme.Poppins
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun ReelListPage() {
    val list = (1..10).map { it.toString() }

    var screenHeight = LocalConfiguration.current.screenHeightDp
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )

        Column(Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.backbtn),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                )

                Spacer(modifier = Modifier.weight(1f))


                Card(
                    shape = RoundedCornerShape(32.dp), backgroundColor = Color(0x1AFF136F)
                ) {
                    Row(
                        Modifier.padding(vertical = 6.dp, horizontal = 12.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.reel_add),
                            contentDescription = "",
                            Modifier
                                .padding(bottom = 2.dp, end = 4.dp)
                                .size(12.dp)
                        )

                        Text(
                            text = "Create",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFF136F),
                            )
                        )
                    }

                }


                Image(
                    painter = painterResource(R.drawable.saerch),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 8.dp)
                        .size(18.dp), colorFilter = ColorFilter.tint(Color.White)
                )

            }

            val lazyListState = rememberLazyListState()

            LazyColumn(
                state = lazyListState,
                flingBehavior = rememberSnapperFlingBehavior(lazyListState),
            ) {
                items(list.size) { index ->
                    ReelItem(screenHeight)
                }

            }


        }

    }

}

@Composable
fun ReelItem(screenHeight: Int) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight - 60).dp)
            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
        backgroundColor = Color.Transparent,

        ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.login_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop // Your content scale
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, start = 12.dp)
                    .align(Alignment.BottomCenter) ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                ReelInfo(Modifier.weight(1f))
                ReelOptions(Modifier.weight(1f))

            }


        }

    }

}

@Composable
fun ReelInfo(modifier: Modifier) {
    Row(modifier = modifier) {
        Column(modifier = Modifier) {

            Spacer(modifier = modifier.weight(1f))

            Row(
                modifier = Modifier, verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.avater),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                )

                Text(
                    text = "UserName",
                    color = Color.White,
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )


                Card(
                    border = BorderStroke(1.dp, Color(0xff475569)),
                    backgroundColor = Color.Transparent
                ) {
                    Text(
                        text = "Follow",
                        color = Color.White,
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }


            }

            HideableLongText()

        }
    }
}

@Composable
fun HideableLongText() {
    var expanded by remember {
        mutableStateOf(false)
    }

    Row(Modifier.padding(end = 32.dp , start = 4.dp , top = 8.dp), horizontalArrangement = Arrangement.Start) {

        Text(
            text = "Sunsets and planes and long dis tance talking my life" +
                    "\n \n #santorini #echoesluxurysuites #beautifulhotels #hotelsandresorts #luxuryvacations #best_worldplaces #luxuryworldtraveler #vacations #travelandleisure #wonderful_places ",
            color = Color.White,
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            overflow = TextOverflow.Ellipsis,
            minLines = 1,
            maxLines = if (!expanded) 1 else Int.MAX_VALUE,
            modifier = Modifier
                .weight(1f)
                .animateContentSize()
        )

        Text(text = if (expanded) "Show less" else "more",
            modifier = Modifier.clickable {
                expanded = !expanded
            } ,
            color =  Color(0xffAFAFAF) ,
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            )

    }


}

@Composable
fun ReelOptions(modifier: Modifier) {
    Column(
        Modifier
            .padding(end = 16.dp, top = 4.dp, bottom = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.reel_love),
            contentDescription = "",
            modifier = Modifier.size(22.dp)
        )
        Text(
            text = "12k",
            color = Color.White,
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.reel_message),
            contentDescription = "",
            modifier = Modifier.size(22.dp)
        )
        Text(
            text = "15",
            color = Color.White,
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.reel_share),
            contentDescription = "",
            modifier = Modifier.size(22.dp)
        )
        Text(
            text = "12",
            color = Color.White,
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.reel_bookmark),
            contentDescription = "",
            modifier = Modifier.size(22.dp)
        )
        Text(
            text = "Save",
            color = Color.White,
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.size(12.dp))

        Image(
            painter = painterResource(id = R.drawable.reel_more_menu),
            contentDescription = "",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.size(12.dp))

        Image(
            painter = painterResource(R.drawable.avater),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)                       // clip to the circle shape
        )


    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun TemPreview() {

    PHUITheme {

        ReelListPage()
    }

}