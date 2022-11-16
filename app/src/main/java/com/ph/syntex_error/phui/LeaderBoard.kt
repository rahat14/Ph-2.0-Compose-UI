package com.ph.syntex_error.phui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.ui.theme.cardBackgroundColor
import com.ph.syntex_error.phui.ui.theme.orangeColor
import com.ph.syntex_error.phui.ui.theme.profileBackgroundColor
import com.ph.syntex_error.phui.ui.theme.textInActiveColor

@Composable
fun LeaderBoardPage() {
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
                text = "Leaderboard", style = MaterialTheme.typography.h1.copy(
                    fontSize = 17.sp, color = Color.White
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(backgroundColor = Color(0x1AFFFFFF)) {
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "", modifier = Modifier
                        .padding(6.dp)
                        .size(20.dp)
                )
            }


        }

        Divider(
            color = Color(0xff1E293B), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        LeaderStandingCard()
        LeaderList()


    }


}

@Composable
fun LeaderList() {

    val list = mutableListOf<Int>(1 ,2 ,3 ,4, 5, 6, 7,8)

    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp),
        modifier = Modifier.offset(
            y= (-5).dp
        )
    ) {


            list.forEachIndexed { index, data ->


                LeaderItem(index == 0 )

                if (index !=  list.lastIndex && index != 0){
                    Divider(color = Color(0xff334155), thickness = 1.dp , modifier = Modifier.padding(horizontal = 16.dp))
                }else if(index == list.lastIndex){
                    Divider(color = Color(0xff334155), thickness = 1.dp)


                }





            }



        InviteFriendContainer()




    }

}

@Composable
fun LeaderItem(isFirst: Boolean = false) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .background(
                if (isFirst) {
                    Color(0xff6808FF)
                } else {
                    Color.Transparent
                }
            )
            .padding(horizontal = 8.dp)
            .padding(12.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Text(
                text = "123",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            Image(
                painter = painterResource(id = R.drawable.avater), contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)                       // clip to the circle shape

            )

            Text(
                text = "Name Of Usefasr",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
            )
        }

        Image(
            painter = painterResource(id = R.drawable.canada), contentDescription = "",
            modifier = Modifier
                .height(13.dp)
                .width(24.dp)
            // clip to the circle shape
        )


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.diamond_2), contentDescription = "",
                modifier = Modifier
                    .padding(bottom = 3.dp)
                    .size(13.dp)
            )



            Text(
                text = "130", style = MaterialTheme.typography.h1.copy(
                    fontSize = 12.sp, color = Color(0xFFFC9A40),
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )


            Image(
                painter = painterResource(id = R.drawable.share_icon), contentDescription = "",
                modifier = Modifier.size(18.dp)
            )


        }


    }
}

@Composable
fun LeaderStandingCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.avater), contentDescription = "",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(3.dp, Color(0xFFF78D6C), CircleShape)
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(
                text = "Not Rahat",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600
            )

            Row {

                Image(
                    painter = painterResource(id = R.drawable.diamond_2), contentDescription = "",
                    modifier = Modifier.size(13.dp)
                )

                Text(
                    text = " 130", style = MaterialTheme.typography.h1.copy(
                        fontSize = 12.sp, color = Color(0xFFFC9A40),
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

            }

            Spacer(modifier = Modifier.size(4.dp))

            Card(
                modifier = Modifier
                    .height(66.dp)
                    .width(70.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.i_2nd),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

            }
        }


        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.trophy__4__1),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.size(6.dp))

            Image(
                painter = painterResource(id = R.drawable.avater), contentDescription = "",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(2.dp, Color(0xFF0FEBCB), CircleShape)
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(
                text = "Rahat",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600
            )

            Row {

                Image(
                    painter = painterResource(id = R.drawable.diamond_2), contentDescription = "",
                    modifier = Modifier.size(13.dp)
                )

                Text(
                    text = " 1320", style = MaterialTheme.typography.h1.copy(
                        fontSize = 12.sp, color = Color(0xFFFC9A40),
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

            }

            Spacer(modifier = Modifier.size(4.dp))


            Card(
                modifier = Modifier
                    .height(93.dp)
                    .width(70.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.i_1st),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

            }
        }




        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.avater), contentDescription = "",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(3.dp, Color(0xFFF78D6C), CircleShape)
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(
                text = "Not Rahat",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600
            )

            Row {

                Image(
                    painter = painterResource(id = R.drawable.diamond_2), contentDescription = "",
                    modifier = Modifier.size(13.dp)
                )

                Text(
                    text = " 130", style = MaterialTheme.typography.h1.copy(
                        fontSize = 12.sp, color = Color(0xFFFC9A40),
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

            }

            Spacer(modifier = Modifier.size(4.dp))

            Card(
                modifier = Modifier
                    .height(55.dp)
                    .width(70.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.i_3rd),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

            }
        }


        Spacer(modifier = Modifier.weight(1f))


    }

}



@Composable
fun BookmarkPage() {
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
                text = "Bookmarks", style = MaterialTheme.typography.h1.copy(
                    fontSize = 17.sp, color = Color.White
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(backgroundColor = Color(0x1AFFFFFF)) {
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "", modifier = Modifier
                        .padding(6.dp)
                        .size(20.dp)
                )
            }


        }

        Divider(
            color = Color(0xff1E293B), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        Row(modifier = Modifier.padding(12.dp)) {
            Text(text = "4 Bookmarks", color = Color.White , fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Clear All" , color = textInActiveColor , fontSize = 16.sp)
        }

        BookMarkItem()
        BookMarkItem()
        BookMarkItem()
        BookMarkItem()
        BookMarkItem()


    }


}

@Composable
fun BookMarkItem(){
    Card (backgroundColor = cardBackgroundColor , shape = RoundedCornerShape(12.dp) ,
    modifier = Modifier.padding(horizontal = 16.dp  , vertical = 8.dp)){

        Row (verticalAlignment = Alignment.CenterVertically , modifier = Modifier.padding(vertical = 10.dp , horizontal = 4.dp )){

            Image(
                painter = painterResource(id = R.drawable.planet),
                contentDescription = "", modifier = Modifier
                    .padding(8.dp)
                    .size(55.dp)
            )

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {

                Row {
                    Text(text = "longg tex checcking for all screeen has this ", maxLines = 1 ,
                    color = Color.White , fontSize = 14.sp , fontWeight = FontWeight.Medium ,
                    modifier = Modifier.weight(1f), overflow = TextOverflow.Ellipsis)

                    Image(
                        painter = painterResource(id = R.drawable.carbon_overflow_menu_vertical),
                        contentDescription = "", modifier = Modifier
                            .size(24.dp)
                    )
                }

                Text(text = "Portfolio website > Top banner > Add Muscle",
                    color = Color(0xFFFF136F) ,
                    textDecoration = TextDecoration.Underline
                )

            }

        }

    }
}