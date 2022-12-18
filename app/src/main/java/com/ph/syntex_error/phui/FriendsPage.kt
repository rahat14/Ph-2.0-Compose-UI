package com.ph.syntex_error.phui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FriendsCard(isFollow: Boolean = false) {

    Card(backgroundColor = Color(0xFF1E293B),
        border = BorderStroke(1.dp, Color(0xff334155)), modifier = Modifier
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


@Composable
fun  FriendsList(){
    Column() {

        Column(modifier = Modifier) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(10.dp),

                ) {

                Text(
                    text = "Friends", style = MaterialTheme.typography.h1.copy(
                        fontSize = 17.sp, color = Color.White
                    )
                )


            }

            Divider(
                color = Color(0xff1E293B), modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )


            Spacer(modifier = Modifier.size(8.dp))


        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
        ) {
            // on below line we are displaying our
            // items upto the size of the list.
            items(20) {

                FriendsCard()

            }




        }

    }
}

