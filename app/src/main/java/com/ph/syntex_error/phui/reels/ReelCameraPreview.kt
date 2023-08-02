package com.ph.syntex_error.phui.reels

import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.ph.syntex_error.phui.R
import com.ph.syntex_error.phui.ui.theme.Poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReelCameraPreview(navController: NavController) {

    var scope = rememberCoroutineScope()

    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden ,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(
            topStart = 20.dp, topEnd = 20.dp
        ), sheetState = modalSheetState,
        sheetBackgroundColor = Color(0xff1E293B),
        sheetContent =
        {
            MusicBottomSheet(modalSheetState)
        }
    ){
        Box(modifier = Modifier.fillMaxSize()) {
            ExampleCameraScreen()
            ReelCreateOptions(modifier = Modifier.align(Alignment.CenterEnd)) {

                scope.launch {
                    modalSheetState.show()
                }


            }

            Image(painter = painterResource(id = R.drawable.cross), contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .size(18.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )

            BottomContainer(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }


}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun MusicBottomSheet(modalSheetState: ModalBottomSheetState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xff1E293B))
            .padding(8.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {


            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
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

            val scope = rememberCoroutineScope()


            Text(text = "Cancel", color = Color(0xffFF136F) , fontSize = 14.sp , fontWeight = FontWeight.W400 , modifier = Modifier
                .padding(horizontal = 8.dp)
                .clickable {
                    scope.launch {
                        modalSheetState.hide()
                    }

                })

        }


        Spacer(modifier = Modifier.size(8.dp))

        Row(horizontalArrangement = Arrangement.Start , modifier = Modifier.fillMaxWidth()) {

            Text(text = "Romantic", color = Color(0xff94A3B8) , fontSize = 12.sp , fontWeight = FontWeight.W400 , modifier = Modifier
                .padding(horizontal = 8.dp)
                .border(
                    (0.8).dp,
                    color = Color(0xff475569),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(6.dp)
            )

            Text(text = "Pop", color = Color(0xff94A3B8) , fontSize = 12.sp , fontWeight = FontWeight.W400 , modifier = Modifier
                .padding(horizontal = 8.dp)
                .border(
                    (0.8).dp,
                    color = Color(0xff475569),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(6.dp)
            )


            Text(text = "Sad", color = Color(0xff94A3B8) , fontSize = 12.sp , fontWeight = FontWeight.W400 , modifier = Modifier
                .padding(horizontal = 8.dp)
                .border(
                    (0.8).dp,
                    color = Color(0xff475569),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(6.dp)
            )

        }

        Spacer(modifier = Modifier.size(8.dp))
        val pagerState = rememberPagerState(initialPage = 0)

        Log.d("TAG", "MusicBottomSheet:  ${pagerState.currentPage}")

        SongTabs(pagerState = pagerState)

        Spacer(modifier = Modifier.size(12.dp))

        Column() {

            MusicRow()
            MusicRow()
            MusicRow()
            
        }


    }


}

@ExperimentalPagerApi
@Composable
fun SongTabs(pagerState: PagerState)  {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list = listOf(
        "For You",
        "Browse",
    )
    // on below line we are creating
    // a variable for the scope.
    val scope = rememberCoroutineScope()

    // on below line we are creating a
    // individual row for our tab layout.
    TabRow(
        // on below line we are specifying
        // the selected index.
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        contentColor = Color(0x4DFFFFFF),
        modifier = Modifier

    ) {
        list.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 5.dp) ,
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray,
                        fontSize = 12.sp,
                        fontFamily = Poppins
                    )
                },
                selected = pagerState.currentPage == index,

                onClick = {
                    Log.d("TAG", "SongTabs: $index ")
                    scope.launch {
                        pagerState.scrollToPage(index)
                    }
                }
            )
        }
    }
}

@Composable
fun MusicRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(4.dp) , horizontalArrangement = Arrangement.Start , verticalAlignment = Alignment.CenterVertically) {

        Box(modifier = Modifier
            .size(50.dp)
            .border(
                (0.8).dp,
                color = Color(0xff475569),
                shape = CircleShape
            )
            .clip(CircleShape))

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "I hate Young boy",
                color = Color(0xffCBD5E1),
                fontFamily = Poppins,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier
                    .padding(vertical = 0.dp, horizontal = 8.dp)

            )

            Text(
                text = "Young boy never broke - 4:21",
                color = Color(0xff64748B),
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(vertical = 0.dp, horizontal = 8.dp)

            )

            
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.reel_song_play),
            contentDescription = "",
            modifier = Modifier
                .size(32.dp)
        )


        Spacer(modifier = Modifier.size(20.dp))


    }
}

@Composable
fun BottomContainer(modifier: Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.reel_create_btn),
            contentDescription = "",
            modifier = Modifier.size(88.dp)
        )



        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.reel_gallery),
                contentDescription = "",
                modifier = Modifier.size(22.dp)
            )


            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.reel_camera_rotated),
                contentDescription = "",
                modifier = Modifier.size(22.dp)
            )
        }

    }


}

@Composable
fun ReelCreateOptions(modifier: Modifier, onClick: (String) -> Unit) {
    Column(
        modifier.padding(end = 16.dp, top = 4.dp, bottom = 4.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(5.dp)

    ) {
        Spacer(modifier = Modifier.weight(1f))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "Add Music",
                color = Color.White,
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .clickable {
                        onClick("")
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.reel_music),
                contentDescription = "",
                modifier = Modifier.size(22.dp)
            )

        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "Reel Speed",
                color = Color.White,
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.reel_speed),
                contentDescription = "",
                modifier = Modifier.size(22.dp)
            )
        }



        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "Timer",
                color = Color.White,
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.reel_timer),
                contentDescription = "",
                modifier = Modifier.size(22.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "Effects",
                color = Color.White,
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.reel_effects),
                contentDescription = "",
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))


    }

}

@Composable
private fun ExampleCameraPreview() {

    val context = LocalContext.current
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val cameraController: LifecycleCameraController =
        remember { LifecycleCameraController(context) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding: PaddingValues ->
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            factory = { context ->
                PreviewView(context).apply {
                    setBackgroundColor(Color.White.toArgb())
                    layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                    scaleType = PreviewView.ScaleType.FILL_START
                    implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                }.also { previewView ->
                    previewView.controller = cameraController
                    cameraController.bindToLifecycle(lifecycleOwner)
                }
            },
            onRelease = {
                cameraController.unbind()
            }
        )
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ExampleCameraScreen() {

    val cameraPermissionState: PermissionState =
        rememberPermissionState(android.Manifest.permission.CAMERA)

    LaunchedEffect(key1 = Unit) {
        if (!cameraPermissionState.status.isGranted && !cameraPermissionState.status.shouldShowRationale) {
            cameraPermissionState.launchPermissionRequest()
        }
    }

    if (cameraPermissionState.status.isGranted) {
        // Permission is granted, we can show the camera preview
        ExampleCameraPreview()
    } else {
        // In this screen you should notify the user that the permission
        // is required and maybe offer a button to start another
        // camera perission request
//        NoCameraPermissionScreen(
//            cameraPermissionState = cameraPermissionState
//        )
    }
}