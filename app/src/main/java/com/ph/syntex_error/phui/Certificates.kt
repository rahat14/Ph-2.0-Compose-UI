package com.ph.syntex_error.phui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.ui.theme.profileBackgroundColor
import java.security.cert.Certificate

@Composable
fun CertificatePage()
{
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
                text = "Certificates", style = MaterialTheme.typography.h1.copy(
                    fontSize = 17.sp, color = Color.White
                )
            )


        }

        Divider(
            color = Color(0xff1E293B), modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )


        Column {

            CertificateItem()
            CertificateItem()
        }




    }
}


@Composable
fun CertificateItem(showUserAvater : Boolean = false){
    Card (
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color(0xff1E293B),
        modifier =  Modifier.padding(8.dp)
            ){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Text(text = "Long text with certificate name in medium size.", color = Color.White ,
            fontSize = 16.sp)
            Spacer(modifier = Modifier.size(4.dp))
            Image(painter = painterResource(id = R.drawable.certificate) , contentScale = ContentScale.Crop, contentDescription = ""
            , modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)

                    .clip(RoundedCornerShape(10.dp)),
            )


            Spacer(modifier = Modifier.size(16.dp))

            Row(horizontalArrangement = Arrangement.SpaceAround ,

            modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color(0xffD9EFFF), CircleShape)// clip to the circle shape
                )

                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color(0xffD9EFFF), CircleShape)// clip to the circle shape
                )

                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color(0xffD9EFFF), CircleShape)// clip to the circle shape
                )

                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color(0xffD9EFFF), CircleShape)// clip to the circle shape
                )
                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color(0xffD9EFFF), CircleShape)// clip to the circle shape
                )



            }
        }


    }
}