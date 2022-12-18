package com.ph.syntex_error.phui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.ui.theme.cardBackgroundColor
import com.ph.syntex_error.phui.ui.theme.textInActiveColor

@Composable
fun PostCard() {
   Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
       Card(
           modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp),
           shape = RoundedCornerShape(11.dp),
           backgroundColor = cardBackgroundColor

       ) {
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .background(cardBackgroundColor)
                   .padding(horizontal = 12.dp, vertical = 8.dp)
           ) {
               Row(
                   verticalAlignment = Alignment.Top,

                   ) {

                   Image(
                       painter = painterResource(id = R.drawable.avater),
                       contentDescription = "",
                       modifier = Modifier
                           .size(35.dp)
                           .clip(CircleShape),
                       contentScale = ContentScale.Crop,
                   )

                   Spacer(modifier = Modifier.size(8.dp))


                   Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {

                       Text(
                           text = "Faiza Feroz", color = Color.White, fontSize = 15.sp,
                           style = TextStyle(
                               platformStyle = PlatformTextStyle(
                                   includeFontPadding = false
                               )
                           )
                       )
                       Text(
                           text = "15 Dec, 2021 10:35 PM",
                           color = textInActiveColor,
                           fontSize = 12.sp
                       )


                   }


                   Spacer(modifier = Modifier.weight(1f))


                   Image(
                       painter = painterResource(id = R.drawable.carbon_overflow_menu_vertical),
                       contentDescription = "",
                       modifier = Modifier

                   )

               }

//            Spacer(modifier = Modifier.size(10.dp))

               Text(
                   text = "Faiza Feroz",
                   color = Color.White,
                   fontWeight = FontWeight.W600,
                   fontSize = 16.sp,
                   style = TextStyle(
                       platformStyle = PlatformTextStyle(
                           includeFontPadding = false
                       )
                   ),
                   modifier = Modifier.padding(top = 12.dp , bottom = 8.dp)
               )


               Text(
                   text = "random long string here", color = Color(0xffCBD5E1), fontSize = 15.sp,
                   style = TextStyle(
                       platformStyle = PlatformTextStyle(
                           includeFontPadding = false
                       )
                   )
               )

               Divider(
                   color = Color(0xFF64748B),
                   thickness = 1.dp,
                   modifier = Modifier.padding(top = 16.dp , bottom = 4.dp)
               )


               Row (verticalAlignment = Alignment.CenterVertically ,
                   horizontalArrangement = Arrangement.SpaceBetween ,
                   modifier = Modifier.fillMaxWidth()){

                   Row(verticalAlignment = Alignment.CenterVertically) {
                       Image(painter = painterResource(id = R.drawable.heart), contentDescription = "" , modifier = Modifier.size(15.dp) )

                       Text(text = "50 Like", color = textInActiveColor, fontSize = 12.sp , modifier = Modifier.padding(horizontal = 3.dp)
                           , style = TextStyle(
                               platformStyle = PlatformTextStyle(
                                   includeFontPadding = false
                               )
                           )
                       )
                   }

                   Row(verticalAlignment = Alignment.CenterVertically) {
                       Image(painter = painterResource(id = R.drawable.chat), contentDescription = "" , modifier = Modifier.size(15.dp) )

                       Text(text = "2 Comments", color = textInActiveColor, fontSize = 12.sp , modifier = Modifier.padding(horizontal = 3.dp)
                           , style = TextStyle(
                               platformStyle = PlatformTextStyle(
                                   includeFontPadding = false
                               )
                           )
                       )
                   }

                   Card(
                       shape = RoundedCornerShape(5.dp),
                       elevation = 4.dp,
                       backgroundColor = Color(0xffFF136F),
                       modifier = Modifier.padding(vertical = 8.dp)
                   ) {

                       Text(
                           text = "See Others",
                           color = Color.White,
                           textAlign = TextAlign.Center,
                           modifier = Modifier
                               .padding(vertical = 4.dp  , horizontal = 8.dp),
                           fontSize = (13.5).sp
                       )

                   }

               }


           }

       }

       Card(

           modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp),
           shape = RoundedCornerShape(11.dp),
           backgroundColor = cardBackgroundColor

         ) {
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .background(cardBackgroundColor)
                   .padding(horizontal = 12.dp, vertical = 8.dp)
           ) {
               Row(
                   verticalAlignment = Alignment.Top,

                   ) {

                   Image(
                       painter = painterResource(id = R.drawable.avater),
                       contentDescription = "",
                       modifier = Modifier
                           .size(35.dp)
                           .clip(CircleShape),
                       contentScale = ContentScale.Crop,
                   )

                   Spacer(modifier = Modifier.size(8.dp))


                   Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {

                       Text(
                           text = "Faiza Feroz", color = Color.White, fontSize = 15.sp,
                           style = TextStyle(
                               platformStyle = PlatformTextStyle(
                                   includeFontPadding = false
                               )
                           )
                       )
                       Text(
                           text = "15 Dec, 2021 10:35 PM",
                           color = textInActiveColor,
                           fontSize = 12.sp
                       )


                   }


                   Spacer(modifier = Modifier.weight(1f))


                   Image(
                       painter = painterResource(id = R.drawable.carbon_overflow_menu_vertical),
                       contentDescription = "",
                       modifier = Modifier

                   )

               }

//            Spacer(modifier = Modifier.size(10.dp))

               Text(
                   text = "Faiza Feroz",
                   color = Color.White,
                   fontWeight = FontWeight.W600,
                   fontSize = 16.sp,
                   style = TextStyle(
                       platformStyle = PlatformTextStyle(
                           includeFontPadding = false
                       )
                   ),
                   modifier = Modifier.padding(top = 12.dp , bottom = 8.dp)
               )


               Text(
                   text = "random long string here", color = Color(0xffCBD5E1), fontSize = 15.sp,
                   style = TextStyle(
                       platformStyle = PlatformTextStyle(
                           includeFontPadding = false
                       )
                   )
               )

               Divider(
                   color = Color(0xFF64748B),
                   thickness = 1.dp,
                   modifier = Modifier.padding(top = 16.dp , bottom = 4.dp)
               )


               Row (verticalAlignment = Alignment.CenterVertically ,
                   horizontalArrangement = Arrangement.SpaceBetween ,
                   modifier = Modifier.fillMaxWidth()){

                   Row(verticalAlignment = Alignment.CenterVertically) {
                       Image(painter = painterResource(id = R.drawable.heart), contentDescription = "" , modifier = Modifier.size(15.dp) )

                       Text(text = "50 Like", color = textInActiveColor, fontSize = 12.sp , modifier = Modifier.padding(horizontal = 3.dp)
                           , style = TextStyle(
                               platformStyle = PlatformTextStyle(
                                   includeFontPadding = false
                               )
                           )
                       )
                   }

                   Row(verticalAlignment = Alignment.CenterVertically) {
                       Image(painter = painterResource(id = R.drawable.chat), contentDescription = "" , modifier = Modifier.size(15.dp) )

                       Text(text = "2 Comments", color = textInActiveColor, fontSize = 12.sp , modifier = Modifier.padding(horizontal = 3.dp)
                           , style = TextStyle(
                               platformStyle = PlatformTextStyle(
                                   includeFontPadding = false
                               )
                           )
                       )
                   }

                   Card(
                       shape = RoundedCornerShape(5.dp),
                       elevation = 4.dp,
                       backgroundColor = Color(0xffFF136F),
                       modifier = Modifier.padding(vertical = 8.dp)
                   ) {

                       Text(
                           text = "See Others",
                           color = Color.White,
                           textAlign = TextAlign.Center,
                           modifier = Modifier
                               .padding(vertical = 4.dp  , horizontal = 8.dp),
                           fontSize = (13.5).sp
                       )

                   }

               }


           }

       }



   }
}