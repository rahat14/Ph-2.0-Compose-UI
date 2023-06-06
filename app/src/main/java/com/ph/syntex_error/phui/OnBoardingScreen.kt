package com.ph.syntex_error.phui

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ph.syntex_error.phui.ui.theme.Poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {
    var modifier = Modifier
    val onboardingScreenList =
        arrayListOf(R.drawable.onboaring_one, R.drawable.onboaring_two, R.drawable.onboaring_three)
    val pagerState = rememberPagerState(initialPage = 0)
    val startColor = listOf(Color(0xffE855DE), Color(0xff7633F1), Color(0xff08D6C7))
    val endColor = listOf(Color(0xff5400EE), Color(0xff2E0083), Color(0xff012227))
    val scope = rememberCoroutineScope()


    Box(Modifier.fillMaxSize()) {

        Image(

            painter = painterResource(onboardingScreenList[pagerState.currentPage]),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        ) // Your content scale

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            OnBoardTabsContent(pagerState = pagerState, modifier)
            Spacer(modifier = modifier.weight(1f))
            OnboardDotsIndicator(selected = pagerState.currentPage)
            Spacer(modifier = modifier.weight(1f))

          Card( shape = RoundedCornerShape(8.dp), modifier = Modifier.padding(horizontal = 16.dp)) {
              Box(modifier = Modifier
                  .fillMaxWidth()
                  .background(
                      brush = Brush.horizontalGradient(
                          colors = listOf(
                              startColor[pagerState.currentPage],
                              endColor[pagerState.currentPage],
                          ),

                          ),
                      shape = RoundedCornerShape(8.dp)
                  )

                  .clickable {
                      if (pagerState.currentPage == (pagerState.pageCount - 1)) {
                      } else {
                          scope.launch {
                              pagerState.animateScrollToPage(pagerState.currentPage + 1)

                          }
                      }
                  }
                  .padding(5.dp)

              ) {

                  Row(
                      verticalAlignment = Alignment.CenterVertically,
                      modifier = Modifier.padding(vertical = 5.dp),
                      horizontalArrangement = Arrangement.Center
                  ) {
                      Spacer(modifier = Modifier.weight(1f))
                      Text(text = "Next", color = Color.White)
                      Image(
                          painter = painterResource(id = R.drawable.forward_arrow),
                          contentDescription = ""
                      )
                      Spacer(modifier = Modifier.weight(1f))
                  }

              }
          }


        }

    }


}


@ExperimentalPagerApi
@Composable
fun OnBoardTabsContent(pagerState: PagerState, modifier: Modifier.Companion) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState, count = 3) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            0 -> Screen(pagerState, modifier)
            1 -> Screen(pagerState, modifier)
            2 -> Screen(pagerState, modifier)
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Screen(pagerState: PagerState, modifier: Modifier.Companion) {
    val botImageArray = listOf(R.drawable.bot_1, R.drawable.bot_2, R.drawable.bot_3)
    val painter = painterResource(id = botImageArray[pagerState.currentPage])
    val headerArray = listOf("Build your own game", "Coding got fun!", "learning in a new way")
    val subsArray = listOf(
        "Learn to code, do programming, coding & play coding games",
        "Learn to code, do programming, coding & play coding games",
        "Learn to code, do programming, coding & play coding games"
    )

    var screenHeight = LocalConfiguration.current.screenHeightDp - 200


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding()
            .height(screenHeight.dp)
    ) {

        Spacer(modifier = Modifier.size(100.dp))


        Image(
            painter = painter, contentDescription = "", modifier =
            Modifier
                .height(208.dp)
                .width(204.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = headerArray[pagerState.currentPage], color = Color(0xffFDFCFF),
            fontFamily = Poppins, textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.W600
        )

        Text(
            text = subsArray[pagerState.currentPage],
            color = Color(0xffFDFCFF).copy(alpha = 0.6f),
            fontFamily = Poppins,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(horizontal = 24.dp)
        )


    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardDotsIndicator(
    dots: Int = 3,
    selectedColor: Color = Color(0xffFDFCFF),
    unSelectedColor: Color = Color(0xffFDFCFF),
    modifier: Modifier = Modifier,
    selected: Int = 0,
    totalSize: Int = 3

) {
    val totalDots = dots

    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {

        items(totalDots) { index ->
            if (index == selected) {

                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(color = selectedColor)
                        .animateItemPlacement()
                        .padding()
                )


            } else {


                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(selectedColor.copy(alpha = 0.3f))
                        .animateItemPlacement()
                        .padding()
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun OnboardPreviews() {

    OnBoardingScreen()

}