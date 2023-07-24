package com.ph.syntex_error.phui.auth

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.PHUITheme
import com.ph.syntex_error.phui.ui.theme.profileBackgroundColor
import kotlinx.coroutines.launch


@OptIn(ExperimentalTextApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Image(
            painter = painterResource(R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds // Your content scale
        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 24.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically

            ) {

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.backbtn),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Sign In",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }


            Text(
                text = "Explore the magic of coding",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                textAlign = TextAlign.Start
            )


            Text(
                text = "Sign In your Account",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                textAlign = TextAlign.Start
            )

            var fd = remember {
                mutableStateOf("")
            }

            EditText(icon = R.drawable.new_person, text = fd, placeholder = "Name")

            EditText(icon = R.drawable.new_lock, text = fd, placeholder = "Password")

            Text(
                text = "Forgot Password?",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.End
            )

            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 22.dp, horizontal = 32.dp)
            ) {

                Box(
                    modifier = Modifier
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xffB72EAD),
                                    Color(0xff5400EE),

                                    )
                            )
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 12.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Sign In",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                            fontSize = 20.sp
                        )

                        Image(
                            painter = painterResource(id = R.drawable.forward_arrow),
                            contentDescription = ""
                        )


                    }
                }
            }



            Text(
                text = "Or sign in with",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 16.sp,
                modifier = Modifier.padding(12.dp)
            )

            Row(modifier = Modifier.padding()) {

                Image(
                    painter = painterResource(R.drawable.social_google_round),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop // Your content scale
                )

                Spacer(modifier = Modifier.size(12.dp))


                Image(
                    painter = painterResource(R.drawable.social_fb_round),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop // Your content scale
                )
            }

            Spacer(modifier = Modifier.size(50.dp))

            Row(modifier = Modifier.padding()) {

                Text(
                    text = "Don’t have an account?",
                    color = Color.White,
                    fontSize = 16.sp,
                )

                Spacer(modifier = Modifier.size(5.dp))


                Text(
                    text = "Signup",
                    color = Color.White,
                    fontSize = 16.sp,
                    style = androidx.compose.ui.text.TextStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xffB72EAD), Color(0xff5400EE)),
                            tileMode = TileMode.Mirror
                        )
                    ),
                    fontWeight = FontWeight.Bold
                )

            }

            Spacer(modifier = Modifier.size(20.dp))


        }

    }
}

@OptIn(ExperimentalTextApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegisterScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Image(
            painter = painterResource(R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds // Your content scale
        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 24.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically

            ) {

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.backbtn),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Sign Up",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }


            Text(
                text = "Sign Up now to begin an amazing journey",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                textAlign = TextAlign.Start
            )


            Text(
                text = "Create Your Account",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                textAlign = TextAlign.Start
            )

            var fd = remember {
                mutableStateOf("")
            }

            EditText(icon = R.drawable.new_person, text = fd, placeholder = "Name")

            EditText(icon = R.drawable.new_mail, text = fd, placeholder = "Mail")

            EditText(icon = R.drawable.new_lock, text = fd, placeholder = "Password")

            Text(
                text = "Forgot Password?",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.End
            )

            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 22.dp, horizontal = 32.dp)
            ) {

                Box(
                    modifier = Modifier
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xffB72EAD),
                                    Color(0xff5400EE),

                                    )
                            )
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 12.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Signup",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                            fontSize = 20.sp
                        )

                        Image(
                            painter = painterResource(id = R.drawable.forward_arrow),
                            contentDescription = ""
                        )

                    }
                }
            }



            Text(
                text = "Or sign up with",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 16.sp,
                modifier = Modifier.padding(12.dp)
            )

            Row(modifier = Modifier.padding()) {

                Image(
                    painter = painterResource(R.drawable.social_google_round),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop // Your content scale
                )

                Spacer(modifier = Modifier.size(12.dp))


                Image(
                    painter = painterResource(R.drawable.social_fb_round),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop // Your content scale
                )
            }

            Spacer(modifier = Modifier.size(50.dp))

            Row(modifier = Modifier.padding()) {

                Text(
                    text = "Have an account?",
                    color = Color.White,
                    fontSize = 16.sp,
                )

                Spacer(modifier = Modifier.size(5.dp))


                Text(
                    text = "Sign In",
                    color = Color.White,
                    fontSize = 16.sp,
                    style = androidx.compose.ui.text.TextStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xffB72EAD), Color(0xff5400EE)),
                            tileMode = TileMode.Mirror
                        )
                    ),
                    fontWeight = FontWeight.Bold
                )

            }

            Spacer(modifier = Modifier.size(20.dp))


        }

    }
}

@OptIn(ExperimentalTextApi::class, ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WelcomeScreen() {
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(
            topStart = 20.dp, topEnd = 20.dp
        ), sheetState = modalSheetState,
        sheetBackgroundColor = profileBackgroundColor,
        sheetContent = {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()

                    .background(profileBackgroundColor)
                    .padding(8.dp)
            ) {

                Card(
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .height(4.dp)
                        .width(50.dp),
                    backgroundColor = Color(0x24FFFFFF)
                ) {}


                Text(
                    text = "Terms & Conditions", color = Color.White, fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(vertical = 12.dp)
                )


                var isHidden by remember {
                    mutableStateOf(false)
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(profileBackgroundColor)
                        .padding(16.dp),
                    backgroundColor = profileBackgroundColor,
                    border = BorderStroke(1.dp, Color(0xff334155)),
                    shape = RoundedCornerShape(8.dp)
                ) {


                    Column(Modifier.padding(12.dp)) {

                        Row {
                            Text(
                                text = "Whadmklfnbvlkmadmfglkmad adsflkgm alksddmfg askd mfklasdmf lkasmdlk fmat",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                modifier = Modifier.weight(
                                    weight = 1f,
                                    fill = true
                                )
                            )



                            Image(
                                painter = painterResource(id = R.drawable.down_pin),
                                contentDescription = "",
                                modifier = Modifier
                                    .rotate(
                                        if (isHidden) {
                                            -180f
                                        } else {
                                            0f
                                        }
                                    )
                                    .clickable {
                                        isHidden = !isHidden
                                    }
                            )

                        }

                        AnimatedVisibility(visible = isHidden) {

                            Text(
                                text = "Amet minim mollit non deserunt ullamco est sit \n" +
                                        "aliqua dolor do amet sit. Velit officia consequat \n" +
                                        "duis enim velit mollit. Exercitation veniam \n" +
                                        "consequat sunt nostrud amet.",

                                color = Color.White,
                                fontWeight = FontWeight.W400,
                                fontSize = 12.sp
                            )

                        }

                    }


                }


            }


        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff0F172A))
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {



            Image(
                painter = painterResource(R.drawable.login_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds // Your content scale
            )

            Image(
                painter = painterResource(id = R.drawable.backbtn),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 24.dp , top = 24.dp)
                    .size(18.dp)
                ,
                contentScale = ContentScale.Crop,
            )

            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 60.dp)
            ) {






                Image(
                    painter = painterResource(R.drawable.group_116379),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop // Your content scale
                )



            }





            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {

                Text(
                    text = "Welcome To",
                    color = Color.White,
                    fontSize = 16.sp,
                )

                Text(
                    "Programming Hero", color = Color.White,
                    fontSize = 24.sp,

                    style = androidx.compose.ui.text.TextStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xffB72EAD), Color(0xff5400EE)),
                            tileMode = TileMode.Mirror
                        )
                    ),
                    fontWeight = FontWeight.Bold
                )

                val scope = rememberCoroutineScope()

                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 22.dp, horizontal = 32.dp)
                        .clickable {
                            scope.launch {
                                modalSheetState.show()
                            }

                        }
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xffB72EAD),
                                        Color(0xff5400EE),

                                        )
                                )
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 12.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Login",
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                                fontSize = 20.sp
                            )

                        }
                    }
                }

                Text(
                    text = "Or sign in with",
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(12.dp)
                )

                Row(modifier = Modifier.padding()) {

                    Image(
                        painter = painterResource(R.drawable.social_google_round),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop // Your content scale
                    )

                    Spacer(modifier = Modifier.size(12.dp))


                    Image(
                        painter = painterResource(R.drawable.social_fb_round),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop // Your content scale
                    )
                }

                Spacer(modifier = Modifier.size(50.dp))

                Row(modifier = Modifier.padding()) {

                    Text(
                        text = "Don’t have an account?",
                        color = Color.White,
                        fontSize = 16.sp,
                    )

                    Spacer(modifier = Modifier.size(5.dp))


                    Text(
                        text = "Signup",
                        color = Color.White,
                        fontSize = 16.sp,
                        style = androidx.compose.ui.text.TextStyle(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xffB72EAD), Color(0xff5400EE)),
                                tileMode = TileMode.Mirror
                            )
                        ),
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(modifier = Modifier.size(20.dp))


            }





        }


    }

}

@Composable
fun EditText(
    icon: Int,
    text: MutableState<String>,
    placeholder: String,
    isPassword: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .clip(RoundedCornerShape(6.dp))


    ) {

        Box(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xffB72EAD).copy(alpha = 0.15f),
                            Color(0xff5400EE).copy(alpha = 0.15f),

                            )
                    )
                )
                .padding(16.dp)
                .clip(RoundedCornerShape(6.dp))

        ) {

            Row(modifier = Modifier.fillMaxWidth()) {

                Image(painter = painterResource(id = icon), contentDescription = "")

                BasicTextField(
                    value = text.value,
                    onValueChange = { newText ->
                        text.value = newText
                    },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .padding(),
                    minLines = 1,
                    decorationBox = { innerTextField ->
                        Box {
                            if (text.value.isEmpty()) {
                                Text(
                                    text = " " + placeholder,
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

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview() {

    PHUITheme {
        WelcomeScreen()
    }

}