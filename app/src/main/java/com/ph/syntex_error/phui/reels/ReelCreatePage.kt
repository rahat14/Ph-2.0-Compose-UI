package com.ph.syntex_error.phui.reels

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.PHUITheme
import com.ph.syntex_error.phui.ui.theme.Poppins
import com.ph.syntex_error.phui.ui.theme.cardBackgroundColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReelCreatePage(navController: NavController) {
    val list = (1..2).map { it.toString() }

    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(
            topStart = 16.dp, topEnd = 16.dp
        ), sheetState = modalSheetState,
        sheetBackgroundColor = Color(0xff1E293B),
        sheetContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xff1E293B))
                    .padding(8.dp)
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.backbtn),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable {
                                scope.launch {
                                    modalSheetState.hide()
                                }
                            },
                        colorFilter = ColorFilter.tint(
                            Color(0xff64748B)
                        )
                    )
                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = "Uploading", color = Color.White, fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(id = R.drawable.cross),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable {
                                scope.launch {
                                    modalSheetState.hide()
                                }
                            },
                        colorFilter = ColorFilter.tint(
                            Color(0xff64748B)
                        )
                    )


                }



                Spacer(modifier = Modifier.size(12.dp))


                LazyColumn() {
                    items(list.size) {

                        VideoUploadRow()

                    }
                }


                Spacer(modifier = Modifier.size(8.dp))


            }


        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff0F172A))
    ) {

        Box(modifier = Modifier.fillMaxSize()) {


            Image(
                painter = painterResource(R.drawable.login_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop // Your content scale
            )

            Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)) {

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {

                    Image(painter = painterResource(id = R.drawable.backbtn),
                        contentDescription = "",
                        Modifier
                            .size(18.dp)
                            .clickable {
                                navController.popBackStack()
                            })

                    Spacer(modifier = Modifier.weight(1f))


                    Text(
                        text = "Edit", color = Color(0xffFF136F),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                        fontWeight = FontWeight.W500, fontFamily = Poppins
                    )

                    Image(
                        painter = painterResource(id = R.drawable.reel_edit_icon),
                        contentDescription = " ",
                        modifier = Modifier.size(24.dp)
                    )


                }

                Spacer(modifier = Modifier.size(12.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((0.8).dp)
                        .background(Color.White.copy(alpha = 0.1F))
                ) {}


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .height(120.dp)
                            .width(100.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {

                        AsyncImage(
                            model = "https://random.imagecdn.app/1920/1080",
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))) {

                        BasicTextField(
                            value = "",
                            onValueChange = { newText ->

                            },
                            textStyle = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .defaultMinSize(minHeight = 120.dp)
                                .background(Color.White.copy(alpha = 0.05f))
                                .padding(12.dp)
                                .clip(shape = RoundedCornerShape(8.dp)),
                            minLines = 1,
                            decorationBox = { innerTextField ->
                                Box {
                                    if ("".isEmpty()) {
                                        Text(
                                            text = "Write a description....",
                                            color = Color(0xffFDFCFF).copy(alpha = .3f),
                                            fontSize = 12.sp
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )
                    }

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((0.8).dp)
                        .background(Color.White.copy(alpha = 0.1F))
                ) {}

                Spacer(modifier = Modifier.size(12.dp))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.reel_music),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Color(0xff94A3B8))
                    )

                    Spacer(modifier = Modifier.size(4.dp))

                    Text(text = "Change Audio", color = Color(0xff94A3B8), fontSize = 12.sp)

                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = "Young boy never...", color = Color(0xff94A3B8), fontSize = 12.sp)

                    Spacer(modifier = Modifier.size(6.dp))

                    Image(
                        painter = painterResource(id = R.drawable.arrow), contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Color(0xff94A3B8))
                    )

                }
                Spacer(modifier = Modifier.weight(1f))


                Card(
                    shape = RoundedCornerShape(5.dp),
                    elevation = 4.dp,
                    backgroundColor = Color(0xffFF136F),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            scope.launch {
                                modalSheetState.show()
                            }
                        }
                ) {

                    Text(
                        text = "Share",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )

                }


            }


        }
    }

}

@Composable
fun VideoUploadRow() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        backgroundColor = Color.White.copy(alpha = 0.05f),
        elevation = 0.dp

    ) {



        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)

        ) {

            Image(
                painter = painterResource(id = R.drawable.reel_flim),
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 8.dp , vertical = 4.dp).size(36.dp)
            )

            Column() {

                Text(
                    text = "Romantic Video.mp4", color = Color(0xffCBD5E1), fontSize = 14.sp,
                    fontWeight = FontWeight.W400, modifier = Modifier.padding(vertical = 0.dp)
                )

                Text(
                    text = "10 MB", color = Color(0xffCBD5E1), fontSize = 11.sp,
                    fontWeight = FontWeight.W400, modifier = Modifier.padding(vertical = 0.dp)
                )

                Row(Modifier.fillMaxWidth()) {

                    GradientProgressbar1()

                    Spacer(modifier = Modifier.size(8.dp))

                    Image(
                        painter = painterResource(id = R.drawable.reel_upload_pause),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable {

                            },

                        )



                    Image(
                        painter = painterResource(id = R.drawable.reel_upload_cancel),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(18.dp)
                            .clickable {

                            },

                        )

                }

                Text(
                    text = "95% Complete", color = Color(0xffCBD5E1), fontSize = 11.sp,
                    fontWeight = FontWeight.W400, modifier = Modifier.padding(vertical = 0.dp)
                )

                Spacer(modifier = Modifier.size(8.dp))

            }

        }


    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 33)
fun SystemPreview() {

    PHUITheme {

     //   ReelCreatePage()
    }

}

@Composable
fun GradientProgressbar1(
    indicatorHeight: Dp = 8.dp,
    backgroundIndicatorColor: Color = Color.Black.copy(alpha = 0.2f),
    indicatorPadding: Dp = 4.dp,
    gradientColors: List<Color> = listOf(
        Color(0xFFF9A641),
        Color(0xFFFE4D60),
    ),
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    val downloadedPercentage = 76f

    val animateNumber = animateFloatAsState(
        targetValue = downloadedPercentage, animationSpec = tween(
            durationMillis = animationDuration, delayMillis = animationDelay
        )
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.height(20.dp)
    ) {
        val option = BitmapFactory.Options()
        option.apply {
            inPreferredConfig = Bitmap.Config.ARGB_8888
        }


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
            val brush = Brush.linearGradient(
                colors = gradientColors, start = Offset(0f, 0f)
            )

            drawLine(
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = progress, y = size.height / 2),
                brush = brush
            )


        }
//        Spacer(modifier = Modifier.width(10.dp))
//
//        Text(
//            text = downloadedPercentage.toInt().toString() + "%",
//            color = Color.White,
//        )


    }


}

