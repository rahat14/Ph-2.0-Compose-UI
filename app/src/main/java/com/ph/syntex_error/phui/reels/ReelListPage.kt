package com.ph.syntex_error.phui.reels

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.PHUITheme
import com.ph.syntex_error.phui.ui.theme.Poppins
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlinx.coroutines.launch

@OptIn(ExperimentalSnapperApi::class, ExperimentalMaterialApi::class)
@Composable
fun ReelListPage(navController: NavHostController?) {
    val list = (1..20).map { it.toString() }

    val screenHeight = LocalConfiguration.current.screenHeightDp

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
                    Text(
                        text = "Comments", color = Color.White, fontSize = 16.sp,
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xff334155))
                ) {}


                Spacer(modifier = Modifier.size(12.dp))


                LazyColumn() {
                    items(list.size) {

                        CommentRow()

                    }
                }


                Spacer(modifier = Modifier.size(8.dp))

                Card(
                    shape = RoundedCornerShape(50),
                    backgroundColor = Color(0xFF0F172A),
                    modifier = Modifier.border(
                        (0.8).dp,
                        color = Color.White,
                        shape = RoundedCornerShape(50)
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                            .background(Color(0xFF0F172A))

                    ) {


                        Image(
                            painter = painterResource(id = R.drawable.avater),
                            contentDescription = "",
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                        )



                        BasicTextField(
                            value = "",
                            onValueChange = { newText ->

                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(horizontal = 4.dp),
                            minLines = 1,
                            decorationBox = { innerTextField ->
                                Box {
                                    if ("".isEmpty()) {
                                        Text(
                                            text = "Basic Text ",
                                            color = Color(0xffFDFCFF).copy(alpha = .3f)
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )


                    }

                }


            }


        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff0F172A))
    ) {

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
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                navController?.popBackStack()
                            },
                    )

                    Spacer(modifier = Modifier.weight(1f))


                    Card(
                        shape = RoundedCornerShape(32.dp), backgroundColor = Color(0x1AFF136F),
                        modifier = Modifier.clickable {
                            navController?.navigate("reel-my-page")
                        }
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
                            .size(18.dp)
                            .clickable {
                                navController?.navigate("reel-search-page")
                            }, colorFilter = ColorFilter.tint(Color.White)
                    )

                }

                val lazyListState = rememberLazyListState()
                val scope = rememberCoroutineScope()

                LazyColumn(
                    state = lazyListState,
                    flingBehavior = rememberSnapperFlingBehavior(lazyListState),
                    contentPadding = PaddingValues(bottom = 40.dp),
                ) {
                    items(list.size) { index ->
                        ReelItem(screenHeight) { data ->
                            scope.launch {
                                modalSheetState.show()
                            }
                        }

                    }

                }

                Spacer(modifier = Modifier.height(1.dp).padding(WindowInsets.systemBars
                    .only(WindowInsetsSides.Vertical)
                    .add(
                        WindowInsets(left = 0.dp, right = 0.dp, top = 0.dp, bottom = 16.dp)
                    )
                    .asPaddingValues()))


            }

        }

    }

}

@Composable
fun CommentRow() {

    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        CommentMoreOption() {
            showDialog.value = false
        }
    }



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.avater), contentDescription = "",
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
        )

        Column(
            Modifier
                .weight(1f)
                .padding(start = 6.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "UserName",
                    color = Color.White,
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(end = 6.dp)
                )

                Text(
                    text = "2W",
                    color = Color(0xff64748B),
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )

            }


            Text(
                text = "Pls don’t even try this method, hardly ppl will reply",
                color = Color(0xffCBD5E1),
                fontFamily = Poppins,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
            )

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {

                Text(
                    text = "Reply",
                    color = Color(0xff64748B),
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                )

                Spacer(modifier = Modifier.width(8.dp))

                Image(painter = painterResource(id = R.drawable.reel_more_menu),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color(0xff64748B)),
                    modifier = Modifier.clickable {
                        showDialog.value = true
                    })

            }




            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier
                        .width(41.dp)
                        .height(1.dp)
                        .background(Color(0xff334155))
                ) {}

                Text(
                    text = "View all 4 replies",
                    color = Color(0xff64748B),
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(start = 8.dp)
                )

            }


        }


//        Spacer(modifier = Modifier.weight(1f))


        Image(
            painter = painterResource(id = R.drawable.reel_love_react), contentDescription = "",
            modifier = Modifier
                .size(20.dp)
        )


    }

}

@Composable
fun ReelItem(screenHeight: Int, onClick: (String) -> Unit) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight - (screenHeight * .12)).dp)
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
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                ReelInfo(Modifier.weight(1f))
                ReelOptions(Modifier.weight(1f)) { data ->
                    onClick(data)
                }

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

    Row(
        Modifier.padding(end = 32.dp, start = 4.dp, top = 8.dp),
        horizontalArrangement = Arrangement.Start
    ) {

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

        Text(
            text = if (expanded) "Show less" else "more",
            modifier = Modifier.clickable {
                expanded = !expanded
            },
            color = Color(0xffAFAFAF),
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
        )

    }


}

@Composable
fun ReelOptions(modifier: Modifier, onClick: (String) -> Unit) {
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
            modifier = Modifier
                .size(22.dp)
                .clickable {
                    onClick("comment")
                }
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
fun CommentMoreOption(setShowDialog: (Boolean) -> Unit) {
    Dialog(onDismissRequest = { setShowDialog(false) }, properties = DialogProperties()) {
        Surface(
            modifier = Modifier.fillMaxWidth(0.92f),
            color = Color(0xFF1E293B),
            shape = RoundedCornerShape(12.dp)// dialog background
        ) {
            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Delete Comment", color = Color.White, fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(id = R.drawable.cross),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable { setShowDialog(false) },
                        colorFilter = ColorFilter.tint(
                            Color(0xff64748B)
                        )
                    )


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFF334155))
                ) {}


                Spacer(modifier = Modifier.size(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.reel_comment_delete),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.size(4.dp))


                    Text(
                        text = "Delete", color = Color(0xffFF136F), fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                    )


                }

                Spacer(modifier = Modifier.size(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.reel_cross_circle),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )


                    Spacer(modifier = Modifier.size(4.dp))

                    Text(
                        text = "Cancel", color = Color(0xffCBD5E1), fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                    )


                }

                Spacer(modifier = Modifier.size(12.dp))

            }

        }
    }
}



@Preview(name = "PIXEL", device = Devices.PIXEL)
@Preview(name = "PIXEL_XL", device = Devices.PIXEL_XL)
@Preview(name = "PIXEL_2", device = Devices.PIXEL_2)
@Preview(name = "PIXEL_2_XL", device = Devices.PIXEL_2_XL)
@Preview(name = "PIXEL_3", device = Devices.PIXEL_3)
@Preview(name = "PIXEL_3_XL", device = Devices.PIXEL_3_XL)
@Preview(name = "PIXEL_3A", device = Devices.PIXEL_3A)
@Preview(name = "PIXEL_3A_XL", device = Devices.PIXEL_3A_XL)
@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "PIXEL_4_XL", device = Devices.PIXEL_4_XL)
@Preview(name = "AUTOMOTIVE_1024p", device = Devices.AUTOMOTIVE_1024p)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun TemPreview() {
    PHUITheme {
        ReelListPage(null)
    }

}

