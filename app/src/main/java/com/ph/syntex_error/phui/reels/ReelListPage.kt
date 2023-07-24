package com.ph.syntex_error.phui.reels

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.PHUITheme

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

            LazyColumn {
                items(list.size) { index ->
                    ReelItem(screenHeight)
                }

            }


        }

    }

}

@Composable
fun ReelItem(screenHeight : Int ) {

    Card(shape = RoundedCornerShape(16.dp),
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

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)) {

                Spacer(modifier = Modifier.weight(1f))

                ReelOptions()

            }


        }

    }

}

@Composable
fun ReelOptions() {
    
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun TemPreview() {

    PHUITheme {

        ReelListPage()
    }

}