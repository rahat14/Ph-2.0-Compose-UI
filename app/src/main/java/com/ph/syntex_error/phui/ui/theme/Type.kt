package com.ph.syntex_error.phui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.R

// Set of Material typography styles to start with
//val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
//)
    val Poppins = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium),
        Font(R.font.poppins_bold , FontWeight.Bold)
    )


val Typography = Typography(


    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily =  Poppins

    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily =  Poppins,

    ),




)

