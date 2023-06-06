package com.ph.syntex_error.phui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SearchPage(navController: NavHostController) {
    Box {
        Image(
            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )




        Column(modifier = Modifier.fillMaxHeight()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Card(
                    modifier = Modifier

                        .weight(1f)
                        .padding(0.dp),
                    backgroundColor = Color(0xff0F172A)
                ) {

                    Row(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.backbtn),
                            contentDescription = "",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }
                        )
                        Text(
                            text = "Find Courses", color = Color(0xff64748B), fontSize = 14.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                    }


                }

            }


            Text(
                text = "Trending Courses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )

            LazyVerticalGrid(
               columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(2.dp),
                modifier = Modifier
                    .padding(0.dp)
            ) {
                items(4) {

                        item ->
                    Box(Modifier.padding(4.dp)) {

                        UpcomingCourseCard(true )

                    }
                }
            }

        }



    }


}