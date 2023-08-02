package com.ph.syntex_error.phui.reels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.ph.syntex_error.phui.R


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReelHomePage(navController: NavHostController) {
    val screenHight = LocalConfiguration.current.screenHeightDp


    Column(Modifier.fillMaxSize()) {
        val list = (1..10).map { it.toString() }
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(R.drawable.home_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Your content scale
            )


            LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(4.dp)) {

                items(list.size) {

                    ReelGridItem(screenHight){
                        navController.navigate("reel-list-page")
                    }

                }

            }
        }
    }
}

@Composable
fun ReelGridItem(screenWidth: Int, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height((screenWidth / 3.4).dp)
            .fillMaxWidth()
            .padding(8.dp).clickable {
                onClick()
            }
            ,
        elevation = 2.dp,
        backgroundColor = Color.Transparent
    ) {

        Box {

            AsyncImage(
                model = "https://images.pexels.com/photos/17314674/pexels-photo-17314674/free-photo-of-a-bouquet-of-roses-in-a-glass-vase.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                // Spacer(modifier = Modifier.size(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.reel_play),
                    contentDescription = "",
                    modifier = Modifier
                        .size(13.dp)
                        .padding(bottom = 3.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "12.2K", color = Color.White, fontSize = 12.sp)


            }


        }

    }
}


@Composable
fun ReelSmallGridItem(screeHeight: Int) {
    Card(
        shape = RoundedCornerShape(8.dp), modifier = Modifier
            .height((screeHeight / 6.2).dp)
            .fillMaxWidth()
            .padding(4.dp),
        elevation = 2.dp
    ) {

        Box {

            AsyncImage(
                model = "https://random.imagecdn.app/1920/1080",
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .background(
                        Color(0x2B000000)
                    )
                    .fillMaxSize()
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                // Spacer(modifier = Modifier.size(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.reel_video),
                    contentDescription = "",
                    modifier = Modifier.size(22.dp)
                )
                // Spacer(modifier = Modifier.size(4.dp))


            }


        }

    }
}


