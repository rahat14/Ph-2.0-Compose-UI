package com.ph.syntex_error.phui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.MediaMetadata
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.STATE_ENDED
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.ph.syntex_error.phui.ui.theme.Purple200
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

@OptIn(ExperimentalTime::class)
@Composable
fun VideoPlayer(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val listOfVideo = listOf( "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4","https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
    val exoPlayer = remember {
        ExoPlayer.Builder(context).apply {
                setSeekBackIncrementMs(PLAYER_SEEK_BACK_INCREMENT)
                setSeekForwardIncrementMs(PLAYER_SEEK_FORWARD_INCREMENT)
            }.build().apply {
                setMediaItem(MediaItem.Builder().apply {
                        setUri(
                            listOfVideo.first()
                       )
                        setMediaMetadata(
                            MediaMetadata.Builder().setDisplayTitle("My Video").build()
                        )
                    }.build())
                prepare()
                playWhenReady = true
            }
    }
    val currentTime =  remember { mutableStateOf(0L) }
    val isPlaying = remember { mutableStateOf(false) }
    val currentIndex = remember { mutableStateOf(listOfVideo.first()) }

    Column() {
        videoPLayer(exoPlayer = exoPlayer , currentTime , isPlaying)


       Column(  modifier = Modifier.verticalScroll(rememberScrollState())) {
           for (i in listOfVideo) {
               Data(currentTime, isPlaying, exoPlayer , i, currentIndex)
           }
       }
    }


}

fun prepareVideo(link : String , exoPlayer: ExoPlayer) {
    exoPlayer.apply {
        setMediaItem(MediaItem.Builder().apply {
            setUri(
               link
            )
            setMediaMetadata(
                MediaMetadata.Builder().setDisplayTitle("My Video").build()
            )
        }.build())
    }.play()


}

@OptIn(ExperimentalTime::class)
@Composable
fun videoPLayer(exoPlayer: ExoPlayer,
                currentVidTime: MutableState<Long> ,
                playing: MutableState<Boolean> ,
                ){

    var currentTime by remember { mutableStateOf(0L) }
    val context = LocalContext.current
    var shouldShowControls by remember { mutableStateOf(false) }

    var isPlaying by remember { mutableStateOf(exoPlayer.isPlaying) }

    var totalDuration by remember { mutableStateOf(0L) }

    var bufferedPercentage by remember { mutableStateOf(0) }

    var playbackState by remember { mutableStateOf(exoPlayer.playbackState) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {
            DisposableEffect(key1 = Unit) {
                val listener = object : Player.Listener {
                    override fun onEvents(
                        player: Player, events: Player.Events
                    ) {
                        super.onEvents(player, events)
                        totalDuration = player.duration.coerceAtLeast(0L)
                        //   currentTime = player.currentPosition.coerceAtLeast(0L)
                        bufferedPercentage = player.bufferedPercentage
                        isPlaying = player.isPlaying
                        playing.value = player.isPlaying
                        playbackState = player.playbackState
                    }

                    override fun onIsPlayingChanged(isPlaying_: Boolean) {
                        isPlaying = isPlaying_
                        playing.value = isPlaying_
                    }

                }

                exoPlayer.addListener(listener)

                onDispose {
                    exoPlayer.removeListener(listener)
                    exoPlayer.release()
                }

            }

            if (isPlaying) {
                LaunchedEffect(Unit) {
                    while (true) {
                        currentVidTime.value = exoPlayer.currentPosition
                        currentTime = exoPlayer.currentPosition
                        delay(50)
                    }
                }
            }

            AndroidView(modifier = Modifier.clickable {
                shouldShowControls = shouldShowControls.not()
            }, factory = {
                StyledPlayerView(context).apply {
                    player = exoPlayer
                    useController = false
                }
            })



            PlayerControls(
                modifier = Modifier.fillMaxSize(),
                isVisible = { shouldShowControls },
                isPlaying = { isPlaying },
                title = { exoPlayer.mediaMetadata.displayTitle.toString() },
                playbackState = { playbackState },
                onReplayClick = { exoPlayer.seekBack() },
                onForwardClick = { exoPlayer.seekForward() },
                onPauseToggle = {
                    when {
                        exoPlayer.isPlaying -> {
                            // pause the video
                            exoPlayer.pause()
                        }
                        exoPlayer.isPlaying.not() &&
                                playbackState == STATE_ENDED -> {
                            exoPlayer.seekTo(0)
                            exoPlayer.playWhenReady = true
                        }
                        else -> {
                            // play the video
                            // it's already paused
                            exoPlayer.play()
                        }
                    }
                    isPlaying = isPlaying.not()
                    playing.value =  isPlaying.not()
                },
                totalDuration = { totalDuration },
                currentTime = { currentTime },
                bufferedPercentage = { bufferedPercentage },
                onSeekChanged = { timeMs: Float ->
                    exoPlayer.seekTo(timeMs.toLong())
                }
            )

        }




}


@Composable
fun Data(
    currentTime: MutableState<Long>,
    isPlaying: MutableState<Boolean>,
    exoPlayer: ExoPlayer,
    i: String,
    currentIndex: MutableState<String>,) {
    //val videoTime = remember(currentTime()) { currentTime() }

    Row() {

        if(currentIndex.value == i){
            Text("play -> ${isPlaying.value}" ,
                modifier = Modifier.clickable{
                    if(isPlaying.value){
                        exoPlayer.pause()
                    }else {
                        exoPlayer.play()
                    }
                })
            Text(" progress ${currentTime.value}")
        }else {

            Text("play ->" ,
                modifier = Modifier.clickable{
                    prepareVideo(i , exoPlayer = exoPlayer)
                    currentIndex.value = i
                })
            Text("NO  progress")
        }


        Text(" Link ${i}")
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun PlayerControls(
    modifier: Modifier = Modifier,
    isVisible: () -> Boolean,
    isPlaying: () -> Boolean,
    title: () -> String,
    onReplayClick: () -> Unit,
    onForwardClick: () -> Unit,
    onPauseToggle: () -> Unit,
    totalDuration: () -> Long,
    currentTime: () -> Long,
    bufferedPercentage: () -> Int,
    playbackState: () -> Int,
    onSeekChanged: (timeMs: Float) -> Unit
) {

    val visible = remember(isVisible()) { isVisible() }

    AnimatedVisibility(
        modifier = modifier, visible = visible, enter = fadeIn(), exit = fadeOut()
    ) {
        Box(modifier = Modifier.background(Color.Black.copy(alpha = 0.6f))) {


            CenterControls(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                isPlaying = isPlaying,
                onReplayClick = onReplayClick,
                onForwardClick = onForwardClick,
                onPauseToggle = onPauseToggle,
                playbackState = playbackState
            )

//            BottomControls(
//                modifier =
//                Modifier.align(Alignment.BottomCenter)
//                    .fillMaxWidth()
//                    .animateEnterExit(
//                        enter =
//                        slideInVertically(
//                            initialOffsetY = { fullHeight: Int ->
//                                fullHeight
//                            }
//                        ),
//                        exit =
//                        slideOutVertically(
//                            targetOffsetY = { fullHeight: Int ->
//                                fullHeight
//                            }
//                        )
//                    ),
//                totalDuration = totalDuration,
//                currentTime = currentTime,
//                bufferedPercentage = bufferedPercentage,
//                onSeekChanged = onSeekChanged
//            )

        }
    }
}

@Composable
private fun TopControl(modifier: Modifier = Modifier, title: () -> String) {
    val videoTitle = remember(title()) { title() }

    Text(
        modifier = modifier.padding(16.dp),
        text = videoTitle,
        style = MaterialTheme.typography.h6,
        color = Purple200
    )
}

@Composable
private fun CenterControls(
    modifier: Modifier = Modifier,
    isPlaying: () -> Boolean,
    playbackState: () -> Int,
    onReplayClick: () -> Unit,
    onPauseToggle: () -> Unit,
    onForwardClick: () -> Unit
) {
    val isVideoPlaying = remember(isPlaying()) { isPlaying() }

    val playerState = remember(playbackState()) { playbackState() }

    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        IconButton(modifier = Modifier.size(40.dp), onClick = onReplayClick) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = com.google.android.exoplayer2.ui.R.drawable.exo_controls_fastforward),
                contentDescription = "Replay 5 seconds"
            )
        }

        IconButton(modifier = Modifier.size(40.dp), onClick = onPauseToggle) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = when {
                    isVideoPlaying -> {
                        painterResource(id = com.google.android.exoplayer2.ui.R.drawable.exo_icon_pause)
                    }

                    isVideoPlaying.not() && playerState == STATE_ENDED -> {
                        painterResource(id = com.google.android.exoplayer2.ui.R.drawable.exo_controls_play)
                    }

                    else -> {
                        painterResource(id = com.google.android.exoplayer2.ui.R.drawable.exo_icon_play)
                    }
                },
                contentDescription = "Play/Pause"
            )
        }

        IconButton(modifier = Modifier.size(40.dp), onClick = onForwardClick) {

            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = com.google.android.exoplayer2.ui.R.drawable.exo_ic_forward),
                contentDescription = "Forward 10 seconds"
            )
        }
    }
}

@Composable
private fun BottomControls(
    modifier: Modifier = Modifier,
    totalDuration: () -> Long,
    currentTime: () -> Long,
    bufferedPercentage: () -> Int,
    onSeekChanged: (timeMs: Float) -> Unit
) {

    val duration = remember(totalDuration()) { totalDuration() }

    val videoTime = remember(currentTime()) { currentTime() }

    val buffer = remember(bufferedPercentage()) { bufferedPercentage() }

    Column(modifier = modifier.padding(bottom = 32.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Slider(
                value = buffer.toFloat(),
                enabled = false,
                onValueChange = { /*do nothing*/ },
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    disabledThumbColor = Color.Transparent, disabledActiveTrackColor = Color.Gray
                )
            )

            Slider(
                modifier = Modifier.fillMaxWidth(),
                value = videoTime.toFloat(),
                onValueChange = onSeekChanged,
                valueRange = 0f..duration.toFloat(),
                colors = SliderDefaults.colors(
                    thumbColor = Purple200, activeTickColor = Purple200
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = duration.formatMinSec(),
                color = Purple200
            )

            IconButton(modifier = Modifier.padding(horizontal = 16.dp), onClick = {}) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = com.google.android.exoplayer2.ui.R.drawable.exo_controls_fullscreen_enter),
                    contentDescription = "Enter/Exit fullscreen"
                )
            }
        }
    }
}

fun Long.formatMinSec(): String {
    return if (this == 0L) {
        "..."
    } else {
        String.format(
            "%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(this),
            TimeUnit.MILLISECONDS.toSeconds(this) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(this)
            )
        )
    }
}

private const val PLAYER_SEEK_BACK_INCREMENT = 5 * 1000L // 5 seconds
private const val PLAYER_SEEK_FORWARD_INCREMENT = 10 * 1000L // 10 seconds