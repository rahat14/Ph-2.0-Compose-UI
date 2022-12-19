package com.ph.syntex_error.phui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.ui.theme.cardBackgroundColor
import com.ph.syntex_error.phui.ui.theme.orangeColor
import com.ph.syntex_error.phui.ui.theme.profileBackgroundColor
import com.ph.syntex_error.phui.ui.theme.textInActiveColor
import kotlin.math.ceil


@Composable
fun GemStorePage() {
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
                text = "Gem Store", style = MaterialTheme.typography.h1.copy(
                    fontSize = 17.sp, color = Color.White
                )
            )


        }

        Divider(
            color = Color(0xff1E293B), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        GemCountCard()

        GemOption()

        Spacer(modifier = Modifier.size(8.dp))

        SingleGemMenuOption("Finish after each lesson")
        SingleGemMenuOption("Each correct quiz")
        SingleGemMenuOption("Getting badge")
        SingleGemMenuOption("After each challenge")
        SingleGemMenuOption(
            "Surprise bonus",
            subtitle = "20 Gem for winning, deduct 5 Gems for losing"
        )
        SingleGemMenuOption(
            "Code on Playground ",
            subtitle = "Stay with Code on Playground 5 minutes"
        )
        SingleGemMenuOption(
            "Finish the Basic concepts of python in 3 days",
            subtitle = "100 gems for winning, deduct 20 Gems for losing"
        )

    }
}

@Composable
fun BadgePage() {
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
                text = "Badges", style = MaterialTheme.typography.h1.copy(
                    fontSize = 17.sp, color = Color.White
                )
            )


        }

        Divider(
            color = Color(0xff1E293B), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.size(42.dp))
            Image(
                painter = painterResource(id = R.drawable.man),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Variable Man",
                fontWeight = FontWeight.W600,
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit  mollit.",
                color = textInActiveColor, fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 20.dp), textAlign = TextAlign.Center
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(16.dp), backgroundColor = cardBackgroundColor,
                border = BorderStroke(1.dp, Color(0xff334155))
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Python",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(id = R.drawable.chevron_down),
                        contentDescription = "", modifier = Modifier
                            .width(13.dp)
                            .height(10.dp)
                    )

                }

            }


            Card(modifier = Modifier.padding(16.dp) , backgroundColor = cardBackgroundColor , shape = RoundedCornerShape(5.dp)) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier.padding(10.dp).height(220.dp),
                    userScrollEnabled = false
                )

                {
                    val matrix = ColorMatrix()




                    items(12) {
                        var painter  = painterResource(id = R.drawable.un_locked)
                        if(it < 2 ){
                            matrix.setToSaturation(1F)
                            painter=   painterResource(id = R.drawable.un_locked)
                        }else {
                            matrix.setToSaturation(0F)
                           painter =  painterResource(id = R.drawable.locked)
                        }
                        Image(
                            painter = painterResource(id = R.drawable.un_locked),
                            contentDescription = "",
                            modifier = Modifier.size(66.dp).padding(6.dp),
                            colorFilter = ColorFilter.colorMatrix(matrix)
                        )


                    }

                }

            }

        }
    }
}

@Composable
fun GemCountCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(11.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
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
                .padding(horizontal = 20.dp, vertical = 14.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {

                Text(
                    text = "You Have",
                    modifier = Modifier,
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White, fontSize = 14.sp,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                    )
                )

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = "1330 ", style = MaterialTheme.typography.body1.copy(
                            fontSize = 24.sp, color = orangeColor,
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            ),
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = " Gems", style = MaterialTheme.typography.body1.copy(
                            fontSize = 14.sp, color = textInActiveColor
                        )
                    )
                }

            }
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.big_gem_store),
                contentDescription = "",
                modifier = Modifier.size(52.dp)
            )
        }

    }
}

@Composable
fun GemOption() {

    Card(
        backgroundColor = cardBackgroundColor, shape = RoundedCornerShape(6.dp),
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Card(backgroundColor = Color(0xffFF136F), modifier = Modifier.weight(1f)) {

                Text(
                    text = "Earn Game",
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(4.dp)
                )
            }

            Text(
                text = "Spent Gem",
                color = textInActiveColor,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )

        }

    }

}

@Composable
fun SingleGemMenuOption(
    title: String, subtitle: String = "",
    icon: Int = R.drawable.ic_document, gem: Int = 12
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(6.dp),
        backgroundColor = cardBackgroundColor
    ) {

        // var verticalAlignment = Alignment.CenterVertically
        val verticalAlignment = if (subtitle.isEmpty()) {
            Alignment.CenterVertically
        } else {
            Alignment.Top
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = verticalAlignment
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_document), contentDescription = "",
                modifier = Modifier.size(32.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 4.dp
                    )
                    .weight(
                        weight = 1f,
                        fill = true
                    )
            ) {

                Text(text = "$title", color = Color.White, fontSize = 14.sp)
                if (subtitle.isNotEmpty()) {
                    Text(
                        text = "$subtitle", color = textInActiveColor,
                        fontSize = 12.sp
                    )
                }
            }


            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.diamond_2),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .size(16.dp)
                )
                Text(
                    text = " 20",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600
                )

            }

        }

    }

}