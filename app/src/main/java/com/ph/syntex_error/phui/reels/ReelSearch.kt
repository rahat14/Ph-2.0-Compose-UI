package com.ph.syntex_error.phui.reels

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.Poppins

@Composable
fun ReelSearch(navController: NavHostController) {
    Box {

        Image(
            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )

        Column(Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.backbtn), contentDescription = "",
                Modifier.size(18.dp).clickable {
                    navController.popBackStack()
                })

                Text(
                    text = "Search", color = Color.White, fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontWeight = FontWeight.W500, fontFamily = Poppins
                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color(0xff0F172A)
                ) {

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 12.dp , vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.saerch),
                            contentDescription = ""
                        )
                        Text(
                            text = "Search Here", color = Color(0xff64748B), fontSize = 15.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                    }




                }

            }

            val list = (1..5).map { it.toString() }

            LazyColumn{
                items(count = list.size){
                    SearchSuggestionItem(){
                        navController.navigate("reel-search-result-page")
                    }
                }

                item {
                    Text(text = "See All Result", color = Color(0xffFF136F) ,
                        fontSize = 14.sp , fontWeight = FontWeight.Bold ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Composable
fun SearchSuggestionItem(onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp).clickable {
          onClick()
        },
        horizontalArrangement = Arrangement.Start ,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(painter = painterResource(id = R.drawable.reel_tag), contentDescription = "",
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(text = "#Pythonprogramming", color = Color.White ,
                fontSize = 16.sp)
            Spacer(modifier = Modifier.size(1.dp))

            Text(text = "1ok Post" , color = Color(0xff64748B) ,
            fontSize = 12.sp)
        }

    }
}


@Composable
fun ReelSearchResult(navController: NavHostController) {
    val list = (1..10).map { it.toString() }
    val screenHight = LocalConfiguration.current.screenHeightDp
    Box {

        Image(
            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Your content scale
        )

        Column(Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.backbtn), contentDescription = "",
                    Modifier.size(18.dp).clickable {
                        navController.popBackStack()
                    })

                Text(
                    text = "#Python", color = Color.White, fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontWeight = FontWeight.W500, fontFamily = Poppins
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(text = "1ok Post" , color = Color(0xff64748B) ,
                    fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.size(8.dp))

            LazyVerticalGrid(columns = GridCells.Fixed(3) , modifier = Modifier.padding(horizontal = 8.dp) ){

                items(list.size){

                    ReelSmallGridItem(screenHight)

                }

            }

            

        }
    }
}
