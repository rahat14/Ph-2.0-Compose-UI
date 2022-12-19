package com.ph.syntex_error.phui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.ui.theme.cardBackgroundColor
import com.ph.syntex_error.phui.ui.theme.profileBackgroundColor
import com.ph.syntex_error.phui.ui.theme.textInActiveColor

@Composable
fun BookmarkPage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
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
                    fontSize = 16.sp, color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(backgroundColor = Color(0x1AFFFFFF)) {
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "",
                    modifier = Modifier
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
            Text(text = "4 Bookmarks", color = Color.White, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Clear All", color = textInActiveColor, fontSize = 16.sp)
        }

        BookMarkItem()
        BookMarkItem()
        BookMarkItem()
        BookMarkItem()
        BookMarkItem()
        BookMarkItem()
        BookMarkItem()


    }


}

@Composable
fun BookMarkItem() {
    Card(
        backgroundColor = cardBackgroundColor,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.planet),
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .size(55.dp)
            )

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {

                Row {
                    Text(
                        text = "longg tex checcking for all screeen has this ",
                        maxLines = 1,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )

                    Image(
                        painter = painterResource(id = R.drawable.carbon_overflow_menu_vertical),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Portfolio website > Top banner > Add Muscle",
                    color = Color(0xFFFF136F),
                    textDecoration = TextDecoration.Underline
                )

            }

        }

    }
}